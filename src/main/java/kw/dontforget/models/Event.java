package kw.dontforget.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private int id;

    private String title;
    @Column(length = 2000)
    private String description;
    private LocalDate dueDate;
    private EventType eventType;

    private int warningLevel1 = 2;  // yellow color

    private int warningLevel2 = 0;  // red color


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getWarningLevel1() {
        return warningLevel1;
    }

    public void setWarningLevel1(int warningLevel1) {
        this.warningLevel1 = warningLevel1;
    }

    public int getWarningLevel2() {
        return warningLevel2;
    }

    public void setWarningLevel2(int warningLevel2) {
        this.warningLevel2 = warningLevel2;
    }
}
