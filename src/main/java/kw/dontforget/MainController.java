package kw.dontforget;

import kw.dontforget.persistence.Event;
import kw.dontforget.persistence.EventRepository;
import kw.dontforget.persistence.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/add/{title}")
    public String added(@PathVariable("title") final String title) {
        Event e = new Event();
        e.setTitle(title);
        e.setDescription("desc");
        e.setEventType(EventType.NORMAL);
        eventRepository.save(e);
        return "hello";
    }

    @GetMapping("/all")
    public String getAll(Model model)
    {
        model.addAttribute("events", eventRepository.findAll());
        return "all";
    }
}
