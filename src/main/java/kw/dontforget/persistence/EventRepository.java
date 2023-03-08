package kw.dontforget.persistence;

import kw.dontforget.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer>
{
    List<Event> findAllByActive(boolean b);
}
