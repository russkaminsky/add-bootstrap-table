package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventCategory;
import org.launchcode.codingevents.models.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("eventCategory")
public class EventCategoryController {

        @Autowired
        private EventCategoryRepository eventCategoryRepository;


        //listens to http://localhost:8080/eventCategory/
        @GetMapping
        public String displayAllEvents(Model model) {

            //Add values to the model, set title to All Events
            model.addAttribute("title", "All Categories");
            //Add the events object to "events" attribute
            model.addAttribute("eventCategories", eventCategoryRepository.findAll());

            return "eventCategory/index";
        }
        @GetMapping("create")
        public String renderCreateEventCategoryForm(Model model){
            model.addAttribute("title", "Create Category");
            model.addAttribute("eventCategory", new EventCategory());


            return "eventCategory/create";
        }

        @PostMapping("create")
        public String processCreateEventCategoryForm(@ModelAttribute @Valid EventCategory newEventCategory,
                                                     Errors errors, Model model){
            if(errors.hasErrors()) {
                model.addAttribute("title", "Create Event");
                return "eventCategory/create";
            }

            eventCategoryRepository.save(newEventCategory);
            return "redirect:";
        }


}
