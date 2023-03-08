package kw.dontforget.services;

public class EventNotFoundException extends Exception
{
    private final int id;

    public EventNotFoundException(final int id)
    {
        super();
        this.id = id;
    }

    @Override
    public String getMessage()
    {
        return "Event " + this.id + " does not exist.";
    }
}
