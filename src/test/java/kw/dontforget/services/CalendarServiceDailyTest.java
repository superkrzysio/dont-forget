package kw.dontforget.services;

import kw.dontforget.models.DaysBasedRecurrence;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class CalendarServiceDailyTest extends CalendarServiceAbstractTest
{

    @Test
    public void testEveryDayFromToday()
    {
        service.setClock(createClock(2020, 1, 1));
        final DaysBasedRecurrence recurrence = daily(1, LocalDate.of(2020, 1, 1));
        Assertions.assertThat(service.daysRemaining(recurrence)).isEqualTo(0);
    }

    @Test
    public void testEveryDaySincePast()
    {
        service.setClock(createClock(2020, 1, 10));
        final DaysBasedRecurrence recurrence = daily(1, LocalDate.of(2020, 1, 1));
        Assertions.assertThat(service.daysRemaining(recurrence)).isEqualTo(0);
    }

    @Test
    public void testEveryDaySinceFuture()
    {
        service.setClock(createClock(2020, 1, 1));
        final DaysBasedRecurrence recurrence = daily(1, LocalDate.of(2020, 1, 10));
        Assertions.assertThat(service.daysRemaining(recurrence)).isEqualTo(9);
    }

    @Test
    public void testDayAhead()
    {
        service.setClock(createClock(2020, 1, 10));
        final DaysBasedRecurrence recurrence = daily(2, LocalDate.of(2020, 1, 9));
        Assertions.assertThat(service.daysRemaining(recurrence)).isEqualTo(1);
    }

    @Test
    public void testMultiplePeriodsAhead()
    {
        service.setClock(createClock(2020, 1, 10));
        final DaysBasedRecurrence recurrence = daily(2, LocalDate.of(2020, 1, 1));
        Assertions.assertThat(service.daysRemaining(recurrence)).isEqualTo(1);
    }

}