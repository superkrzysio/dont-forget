package kw.dontforget.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class CalendarServiceSimpleDateTest extends CalendarServiceAbstractTest
{
    @Test
    public void testToday()
    {
        service.setClock(createClock(2020, 2, 29));
        final LocalDate testDay = LocalDate.of(2020, 2, 29);
        Assertions.assertThat(service.daysRemaining(testDay)).isEqualTo(0);
    }

    @Test
    public void testTomorrow()
    {
        service.setClock(createClock(2020, 2, 29));
        final LocalDate testDay = LocalDate.of(2020, 3, 1);
        Assertions.assertThat(service.daysRemaining(testDay)).isEqualTo(1);
    }

    @Test
    public void testYesterday()
    {
        service.setClock(createClock(2020, 1, 1));
        final LocalDate testDay = LocalDate.of(2019, 12, 31);
        Assertions.assertThat(service.daysRemaining(testDay)).isEqualTo(-1);
    }

}
