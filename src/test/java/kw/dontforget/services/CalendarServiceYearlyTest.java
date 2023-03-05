package kw.dontforget.services;

import kw.dontforget.models.DayOfYearBasedRecurrence;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.DateTimeException;

@SpringBootTest
public class CalendarServiceYearlyTest extends CalendarServiceAbstractTest
{
    @Test
    public void testToday()
    {
        service.setClock(createClock(2020, 1, 1));
        final DayOfYearBasedRecurrence recurrence = yearly(1, 1);
        Assertions.assertThat(service.daysRemaining(recurrence)).isEqualTo(0);
    }

    @Test
    public void testTomorrow()
    {
        service.setClock(createClock(2020, 1, 1));
        final DayOfYearBasedRecurrence recurrence = yearly(1, 2);
        Assertions.assertThat(service.daysRemaining(recurrence)).isEqualTo(1);
    }

    @Test
    public void testTomorrowNextMonth()
    {
        service.setClock(createClock(2020, 1, 31));
        final DayOfYearBasedRecurrence recurrence = yearly(2, 1);
        Assertions.assertThat(service.daysRemaining(recurrence)).isEqualTo(1);
    }

    @Test
    public void testTomorrowNextYear()
    {
        service.setClock(createClock(2020, 12, 31));
        final DayOfYearBasedRecurrence recurrence = yearly(1, 1);
        Assertions.assertThat(service.daysRemaining(recurrence)).isEqualTo(1);
    }

    @Test
    public void testYesterday()
    {
        service.setClock(createClock(2022, 1, 15));
        final DayOfYearBasedRecurrence recurrence = yearly(1, 14);
        Assertions.assertThat(service.daysRemaining(recurrence)).isEqualTo(364);
    }

    @Test
    public void testYesterdayLeapYear()
    {
        service.setClock(createClock(2020, 1, 15));
        final DayOfYearBasedRecurrence recurrence = yearly(1, 14);
        Assertions.assertThat(service.daysRemaining(recurrence)).isEqualTo(365);
    }

    @Test
    public void testLeapYearSettings()
    {
        service.setClock(createClock(2020, 1, 15));
        final DayOfYearBasedRecurrence recurrence = yearly(2, 29);
        Assertions.assertThatThrownBy(() -> service.daysRemaining(recurrence)).isInstanceOf(DateTimeException.class);
    }

    @Test
    public void testInvalidCalendarSettings()
    {
        service.setClock(createClock(2020, 1, 15));
        final DayOfYearBasedRecurrence recurrence = yearly(4, 31);
        Assertions.assertThatThrownBy(() -> service.daysRemaining(recurrence)).isInstanceOf(DateTimeException.class);
    }
}
