package kw.dontforget.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DayOfMonthBasedRecurrence
{
    @Id
    @GeneratedValue
    private int id;

    private int day;

    public int getId()
    {
        return id;
    }

    public DayOfMonthBasedRecurrence setId(final int id)
    {
        this.id = id;
        return this;
    }

    public int getDay()
    {
        return day;
    }

    public DayOfMonthBasedRecurrence setDay(final int day)
    {
        this.day = day;
        return this;
    }
}
