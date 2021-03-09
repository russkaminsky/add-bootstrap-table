package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chris Bay
 * Modified by Russ Kaminsky
 */
@Controller
@RequestMapping("events")
public class EventController {


    //private ArrayList<Event> events = new ArrayList<>();
    private static EventData events;

    //listens to http://localhost:8080/events/
    @GetMapping
    public String displayAllEvents(Model model) {
        //Add values to the model, set title to All Events
        model.addAttribute("title", "All Events");
        //Add the events object to "events" attribute
        model.addAttribute("events", events.getAll());

        return "events/index";
    }



    //listens to http://localhost:8080/events/create
    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute("event", new Event());
        model.addAttribute("types", EventType.values());

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

        EventData.add(newEvent);
        return "redirect:";
    }

    //listens to http://localhost:8080/events/delete
    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {

        model.addAttribute("events", events.getAll());
        return "events/delete";

    }

    @PostMapping("delete")
    public String deleteEvent(@RequestParam(required = false) Integer[] eventIds)
    {

        for(int i = 0; i<eventIds.length;i++) {
            events.remove(eventIds[i]);
        }
        return "redirect:";
    }

}
