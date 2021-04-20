package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
//import java.util.HashMap;


/**
 * Created by Chris Bay
 * Modified by Russ Kaminsky
 */
    @Controller
    @RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    //listens to http://localhost:8080/events/
    @GetMapping
    public String displayAllEvents(Model model) {
        //Add values to the model, set title to All Events
        model.addAttribute("title", "All Events");
        //Add the events object to "events" attribute
        model.addAttribute("events", eventRepository.findAll());



        return "events/index";
    }



    //listens to http://localhost:8080/events/create
    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute("event", new Event());
        model.addAttribute("eventCategories", eventCategoryRepository.findAll());

        return "events/create";

    }

    /*
    //listens for post to events/create
    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName,
                                         @RequestParam String eventDescription,
                                         @RequestParam String eventAddress) {
        events.add(new Event(eventName,eventDescription,eventAddress));
        return "redirect:";
    }
*/
    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model) {
                if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            return "events/create";
        }

        eventRepository.save(newEvent);
        return "redirect:";
    }

    //listens to http://localhost:8080/events/delete
    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {

        model.addAttribute("events", eventRepository.findAll());
        return "events/delete";

    }

    @PostMapping("delete")
    public String deleteEvent(@RequestParam(required = false) Integer[] eventIds)
    {

        for(int i = 0; i<eventIds.length;i++) {
            eventRepository.deleteById(eventIds[i]);
        }
        return "redirect:";
    }

}
