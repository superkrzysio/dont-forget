package kw.dontforget.controllers;

import kw.dontforget.models.Event;
import kw.dontforget.persistence.EventRepository;
import kw.dontforget.services.CalendarService;
import kw.dontforget.services.EventNotFoundException;
import kw.dontforget.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/events")
public class EventController
{
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventService eventService;

    @Autowired
    private CalendarService calendarService;

    @GetMapping("/add")
    public String addPage(final Model model)
    {
        model.addAttribute("event", new Event());
        return "add_event";
    }

    @PostMapping("/save")
    public String submit(@ModelAttribute final Event event)
    {
        eventRepository.save(event);
        return "redirect:/events/";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable("id") final int id, final Model model)
    {
        model.addAttribute("event", eventRepository.findById(id));
        return "add_event";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") final int id)
    {
        eventRepository.deleteById(id);
        return "redirect:/events/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") final int id, final Model model) throws EventNotFoundException
    {
        final Event event = eventService.get(id);
        model.addAttribute("event", eventService.get(id));
        model.addAttribute("remaining", calendarService.daysRemaining(event.getDueDate()));
        model.addAttribute("level", eventService.getWarningLevel(id).name());
        return "view_event";
    }

    @GetMapping("/postpone/{id}/{days}")
    public String postpone(@PathVariable("id") final int id, @PathVariable("days") final int days) throws EventNotFoundException
    {
        eventService.postpone(id, days);
        return "redirect:/events/view/" + id;
    }

    @GetMapping("/complete/{id}")
    public String complete(@PathVariable("id") final int id) throws EventNotFoundException
    {
        eventService.complete(id);
        return "redirect:/events/";
    }

    @GetMapping("/")
    public String getAll(final Model model)
    {
        model.addAttribute("events", eventService.getAllActive());
        return "all";
    }
}
