package kw.dontforget.persistence;

import kw.dontforget.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer>
{

}
