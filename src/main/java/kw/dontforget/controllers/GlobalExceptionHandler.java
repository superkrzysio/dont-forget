package kw.dontforget.controllers;

import kw.dontforget.services.EventNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(value = {EventNotFoundException.class})
    protected String handleEventNotFound(final EventNotFoundException ex, final Model model)
    {
        model.addAttribute("message", ex.getMessage());
        return "404";
    }
}
