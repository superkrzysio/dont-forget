package kw.dontforget;

import kw.dontforget.models.Event;
import kw.dontforget.persistence.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MainController
{

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/add-event")
    public String addPage(final Model model)
    {
        model.addAttribute("event", new Event());
        return "add_event";
    }

    @PostMapping("/save")
    public String submit(@ModelAttribute final Event event)
    {
        eventRepository.save(event);
        return "redirect:/";
    }

    @GetMapping("/edit-event/{id}")
    public String editPage(@PathVariable("id") final int id, final Model model)
    {
        model.addAttribute("event", eventRepository.findById(id));
        return "add_event";
    }

    @GetMapping("/delete-event/{id}")
    public String delete(@PathVariable("id") final int id)
    {
        eventRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/")
    public String getAll(final Model model)
    {
        model.addAttribute("events", eventRepository.findAll());
        return "all";
    }
}
