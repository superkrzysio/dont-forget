package kw.dontforget.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Recurring
{
    @Id
    @GeneratedValue
    private int id;

    private String title;
    @Column(length = 2000)
    private String description;

    private EventType eventType;

    @OneToMany
    private Set<DaysBasedRecurrence> daysBasedRecurrences;

    @OneToMany
    private Set<DayOfMonthBasedRecurrence> dayOfMonthBasedRecurrences;

    @OneToMany
    private Set<DayOfYearBasedRecurrence> dayOfYearBasedRecurrences;

    private int warningLevel0 = 7;  // green color
    private int warningLevel1 = 2;  // yellow color

    private int warningLevel2 = 0;  // red color


    public int getId()
    {
        return id;
    }

    public void setId(final int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(final String description)
    {
        this.description = description;
    }

    public EventType getEventType()
    {
        return eventType;
    }

    public void setEventType(final EventType eventType)
    {
        this.eventType = eventType;
    }

    public Set<DaysBasedRecurrence> getDaysBasedRecurrences()
    {
        return daysBasedRecurrences;
    }

    public void setDaysBasedRecurrences(final Set<DaysBasedRecurrence> daysBasedRecurrences)
    {
        this.daysBasedRecurrences = daysBasedRecurrences;
    }

    public Set<DayOfMonthBasedRecurrence> getDayOfMonthBasedRecurrences()
    {
        return dayOfMonthBasedRecurrences;
    }

    public void setDayOfMonthBasedRecurrences(final Set<DayOfMonthBasedRecurrence> dayOfMonthBasedRecurrences)
    {
        this.dayOfMonthBasedRecurrences = dayOfMonthBasedRecurrences;
    }

    public Set<DayOfYearBasedRecurrence> getDayOfYearBasedRecurrences()
    {
        return dayOfYearBasedRecurrences;
    }

    public void setDayOfYearBasedRecurrences(final Set<DayOfYearBasedRecurrence> dayOfYearBasedRecurrences)
    {
        this.dayOfYearBasedRecurrences = dayOfYearBasedRecurrences;
    }

    public int getWarningLevel0()
    {
        return warningLevel0;
    }

    public void setWarningLevel0(final int warningLevel0)
    {
        this.warningLevel0 = warningLevel0;
    }

    public int getWarningLevel1()
    {
        return warningLevel1;
    }

    public void setWarningLevel1(final int warningLevel1)
    {
        this.warningLevel1 = warningLevel1;
    }

    public int getWarningLevel2()
    {
        return warningLevel2;
    }

    public void setWarningLevel2(final int warningLevel2)
    {
        this.warningLevel2 = warningLevel2;
    }
}
