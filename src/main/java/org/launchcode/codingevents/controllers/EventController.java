package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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


    private static HashMap<String, List<String>> events = new HashMap<>();
    //private static ArrayList<String > eventAddress = new ArrayList<>();

    //listens to http://localhost:8080/events/
    @GetMapping
    public String displayAllEvents(Model model) {

        model.addAttribute("title", "All Events");
        model.addAttribute("events", events);
        //model.addAttribute("eventAddress",eventAddress);

        //HashMap foreach example
        //for (Map.Entry<String, String> event : events.entrySet()) {
        //   model.addAttribute("events", event.getKey() + " " + event.getValue());
        //}

        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName,
                                         @RequestParam String eventDescription,
                                         @RequestParam String eventAddress) {
        List<String> eventInfo = new ArrayList<>();
        eventInfo.add(eventDescription);
        eventInfo.add(eventAddress);

        String addressSearch = "https://google.com/search?q=" + eventAddress.replace(' ','+');
        eventInfo.add(addressSearch);

        events.put(eventName, eventInfo);

        //eventInfo.get(0) //event description
        //eventInfo.get(1) //event address plain text
        //eventInfo.get(2) //google search event address for link
        return "redirect:";
    }

}
