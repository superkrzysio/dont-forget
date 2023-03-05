package kw.dontforget.services;

import kw.dontforget.models.DayOfMonthBasedRecurrence;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.DateTimeException;

@SpringBootTest
class CalendarServiceMonthlyTest extends CalendarServiceAbstractTest
{


    @Test
    public void testToday()
    {
        service.setClock(createClock(2020, 1, 1));
        final DayOfMonthBasedRecurrence recurrence = monthly(1);
        Assertions.assertThat(service.daysRemaining(recurrence)).isEqualTo(0);
    }

    @Test
    public void testTomorrow()
    {
        service.setClock(createClock(2020, 1, 1));
        final DayOfMonthBasedRecurrence recurrence = monthly(2);
        Assertions.assertThat(service.daysRemaining(recurrence)).isEqualTo(1);
    }

    @Test
    public void testTomorrowMonthTooShort()
    {
        service.setClock(createClock(2020, 2, 28));
        final DayOfMonthBasedRecurrence recurrence = monthly(29);
        Assertions.assertThatThrownBy(() -> service.daysRemaining(recurrence)).isInstanceOf(DateTimeException.class);
    }

    @Test
    public void testTomorrowNextMonthMarch()
    {
        service.setClock(createClock(2021, 2, 28));
        final DayOfMonthBasedRecurrence recurrence = monthly(1);
        Assertions.assertThat(service.daysRemaining(recurrence)).isEqualTo(1);
    }

    @Test
    public void testTomorrowNextMonthFebruary()
    {
        service.setClock(createClock(2021, 1, 28));
        final DayOfMonthBasedRecurrence recurrence = monthly(1);
        Assertions.assertThat(service.daysRemaining(recurrence)).isEqualTo(4);
    }

    @Test
    public void testYesterdayJuly()
    {
        service.setClock(createClock(2021, 7, 15));
        final DayOfMonthBasedRecurrence recurrence = monthly(14);
        Assertions.assertThat(service.daysRemaining(recurrence)).isEqualTo(30);
    }

    @Test
    public void testYesterdayLeapFebruary()
    {
        service.setClock(createClock(2020, 2, 15));
        final DayOfMonthBasedRecurrence recurrence = monthly(14);
        Assertions.assertThat(service.daysRemaining(recurrence)).isEqualTo(28);
    }

}