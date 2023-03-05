package kw.dontforget.persistence;

import kw.dontforget.models.Recurring;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RecurringRepository extends JpaRepository<Recurring, Integer>
{
}
