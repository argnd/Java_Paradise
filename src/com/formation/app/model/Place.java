package com.formation.app.model;

public class Place {
    private Long ID;
    private String name;

    public Place(String name) {
        this.name = name;
    }


    public Place(long ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
