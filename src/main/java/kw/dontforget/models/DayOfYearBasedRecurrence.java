package kw.dontforget.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DayOfYearBasedRecurrence
{
    @Id
    @GeneratedValue
    private int id;

    private int month;

    private int day;

    public int getId()
    {
        return id;
    }

    public void setId(final int id)
    {
        this.id = id;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(final int month)
    {
        this.month = month;
    }

    public int getDay()
    {
        return day;
    }

    public void setDay(final int day)
    {
        this.day = day;
    }
}
