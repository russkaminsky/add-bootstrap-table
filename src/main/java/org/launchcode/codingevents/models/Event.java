package org.launchcode.codingevents.models;

import java.util.Objects;

public class Event {

    private String name;
    private String description;
    private String address;
    private String addressLink;
    private Integer id;
    private static Integer nextId = 1;

    public Event(String name, String description, String address) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.addressLink =  "https://google.com/search?q=" + address.replace(' ','+');
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

    public void setAddressLink(String addressLink) {
        this.addressLink = addressLink;
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
