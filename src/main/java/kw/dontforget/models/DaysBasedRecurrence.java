package kw.dontforget.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class DaysBasedRecurrence
{
    @Id
    @GeneratedValue
    private int id;

    private int period;

    private LocalDate created;

    public int getId()
    {
        return id;
    }

    public void setId(final int id)
    {
        this.id = id;
    }

    public int getPeriod()
    {
        return period;
    }

    public void setPeriod(final int period)
    {
        this.period = period;
    }

    public LocalDate getCreated()
    {
        return created;
    }

    public void setCreated(final LocalDate created)
    {
        this.created = created;
    }
}
