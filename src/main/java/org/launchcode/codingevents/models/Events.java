package org.launchcode.codingevents.models;

public class Events {

    private String name;
    private String description;
    private String address;
    private String addressLink;

    public Events(String name, String description, String address) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.addressLink = "";
    }

    public Events(String name, String description, String address, String addressLink) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.addressLink = addressLink;
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
}
