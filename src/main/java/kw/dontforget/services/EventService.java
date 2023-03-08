package kw.dontforget.services;

import kw.dontforget.models.Event;
import kw.dontforget.models.EventType;
import kw.dontforget.persistence.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService
{
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CalendarService calendarService;

    public List<Event> getAllActive()
    {
        return eventRepository.findAllByActive(true);
    }

    public void postpone(final int id, final int days) throws EventNotFoundException
    {
        final Event event = get(id);
        LocalDate dueDate = event.getDueDate();
        dueDate = dueDate.plusDays(days);
        event.setDueDate(dueDate);
        eventRepository.save(event);
    }

    public void complete(final int id) throws EventNotFoundException
    {
        final Event event = get(id);
        event.setActive(false);
        eventRepository.save(event);
    }

    public void uncomplete(final int id) throws EventNotFoundException
    {
        final Event event = get(id);
        event.setActive(true);
        eventRepository.save(event);
    }

    public Event get(final int id) throws EventNotFoundException
    {
        return eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
    }

    public WarningLevel getWarningLevel(final int id) throws EventNotFoundException
    {
        final Event event = get(id);
        if (event.getEventType() == EventType.FORECAST)
        {
            return WarningLevel.FORECAST;
        }
        final int daysRemaining = calendarService.daysRemaining(event.getDueDate());
        if (daysRemaining <= event.getWarningLevel2())
        {
            return WarningLevel.DUE;
        }
        if (daysRemaining <= event.getWarningLevel1())
        {
            return WarningLevel.WARNING;
        }
        return WarningLevel.INFO;
    }
}
