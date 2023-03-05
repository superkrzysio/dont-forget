package kw.dontforget.services;

import kw.dontforget.models.DayOfMonthBasedRecurrence;
import kw.dontforget.models.DayOfYearBasedRecurrence;
import kw.dontforget.models.DaysBasedRecurrence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;

@Service
public class CalendarService
{
    @Autowired
    private Clock clock;

    public int daysRemaining(final DaysBasedRecurrence recurrence)
    {
        if (LocalDate.now(clock).isBefore(recurrence.getCreated()))
        {
            return (int) Duration.between(LocalDate.now(clock).atStartOfDay(), recurrence.getCreated().atStartOfDay()).toDays();
        }
        long daysBetween = Duration.between(recurrence.getCreated().atStartOfDay(), LocalDate.now(clock).atStartOfDay()).toDays();
        daysBetween %= recurrence.getPeriod();
        return (int) daysBetween;
    }

    public int daysRemaining(final DayOfMonthBasedRecurrence recurrence)
    {
        recurrenceConfigMustBeValidForAllMonths(recurrence);

        final int dayNow = LocalDate.now(clock).getDayOfMonth();
        if (recurrence.getDay() >= dayNow)
        {
            return recurrence.getDay() - dayNow;
        } else
        {
            final LocalDate now = LocalDate.now(clock);
            final LocalDate nextMonthDate = LocalDate.of(now.getYear(), now.getMonth().plus(1), recurrence.getDay());
            return (int) Duration.between(now.atStartOfDay(), nextMonthDate.atStartOfDay()).toDays();
        }
    }

    public int daysRemaining(final DayOfYearBasedRecurrence recurrence)
    {
        recurrenceConfigMustBeValidForNonLeapYear(recurrence);

        final LocalDate now = LocalDate.now(clock);
        final LocalDate thisYearDate = LocalDate.of(now.getYear(), recurrence.getMonth(), recurrence.getDay());
        if (!now.isAfter(thisYearDate))
        {
            return (int) Duration.between(now.atStartOfDay(), thisYearDate.atStartOfDay()).toDays();
        } else
        {
            final LocalDate nextYearDate = LocalDate.of(now.getYear() + 1, recurrence.getMonth(), recurrence.getDay());
            return (int) Duration.between(now.atStartOfDay(), nextYearDate.atStartOfDay()).toDays();
        }
    }

    public int daysRemaining(final LocalDate until)
    {
        return (int) Duration.between(LocalDate.now(clock).atStartOfDay(), until.atStartOfDay()).toDays();
    }

    private static void recurrenceConfigMustBeValidForAllMonths(DayOfMonthBasedRecurrence recurrence)
    {
        final int sampleNonLeapYear = 2021;
        final int shortestMonth = 2;
        LocalDate.of(sampleNonLeapYear, shortestMonth, recurrence.getDay());
    }

    private static void recurrenceConfigMustBeValidForNonLeapYear(DayOfYearBasedRecurrence recurrence)
    {
        final int sampleNonLeapYear = 2021;
        LocalDate.of(sampleNonLeapYear, recurrence.getMonth(), recurrence.getDay());
    }

    public void setClock(final Clock clock)
    {
        this.clock = clock;
    }
}
