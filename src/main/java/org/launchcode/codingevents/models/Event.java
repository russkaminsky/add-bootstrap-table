package org.launchcode.codingevents.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class Event {


    @NotBlank(message = "Event Name Required")
    @Size(min = 3, max = 12, message = "Name must be between 3 and 12 characters")
    private String name;

    @NotBlank(message = "Please add a description")
    @Size(max = 50, message = "Description cannot be bigger than 50 characters")
    private String description;

    private String address;
    private String addressLink;

    @Email
    private String contactEmail;
    private Integer id;
    private static Integer nextId = 1;

    private EventType type;

    public Event(String name, String description, String address, String contactEmail, EventType type) {
        this();
        this.name = name;
        this.description = description;
        this.address = address;
        this.addressLink =  "https://google.com/search?q=" + address.replace(' ','+');
        this.contactEmail = contactEmail;
        this.type = type;

    }

    public Event() {
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[name] :" + name + "|[description] : " + description + "[address] : " + address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressLink() {
        return addressLink;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public void setAddressLink(String addressLink) {
        this.addressLink = addressLink;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }


    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event events = (Event) o;
        return id.equals(events.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
