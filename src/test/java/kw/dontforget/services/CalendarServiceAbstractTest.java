package kw.dontforget.services;

import kw.dontforget.models.DayOfMonthBasedRecurrence;
import kw.dontforget.models.DayOfYearBasedRecurrence;
import kw.dontforget.models.DaysBasedRecurrence;
import org.junit.jupiter.api.AfterEach;

import javax.annotation.Resource;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

public class CalendarServiceAbstractTest
{
    @Resource
    protected CalendarService service;
    @Resource
    private Clock defaultClock;

    @AfterEach
    public void restoreClock()
    {
        service.setClock(defaultClock);
    }

    protected Clock createClock(final int year, final int month, final int day)
    {
        final ZoneOffset zone = ZoneOffset.UTC;
        final Instant dayInstant = LocalDate.of(year, month, day).atStartOfDay().toInstant(zone);
        return Clock.fixed(dayInstant, zone);

    }

    protected DaysBasedRecurrence daily(final int period, final LocalDate start)
    {
        final DaysBasedRecurrence recurrence = new DaysBasedRecurrence();
        recurrence.setPeriod(period);
        recurrence.setCreated(start);
        return recurrence;
    }

    protected DayOfMonthBasedRecurrence monthly(final int day)
    {
        final DayOfMonthBasedRecurrence recurrence = new DayOfMonthBasedRecurrence();
        recurrence.setDay(day);
        return recurrence;
    }

    protected DayOfYearBasedRecurrence yearly(final int month, final int day)
    {
        final DayOfYearBasedRecurrence recurrence = new DayOfYearBasedRecurrence();
        recurrence.setDay(day);
        recurrence.setMonth(month);
        return recurrence;
    }
}
