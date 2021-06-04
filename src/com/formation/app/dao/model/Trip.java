package com.formation.app.model;

public class Trip {

    private Long ID;
    private String name;
    private Long dpt_id;
    private long arrival_id;

    public Trip(String name, Place dpt, Place arrival) {
        this.name = name;
        this.dpt_id = dpt.getID();
        this.arrival_id = arrival.getID();
    }

    public Trip(Long ID, String name, Place dpt, Place arrival) {
        this.ID = ID;
        this.name = name;
        this.dpt_id = dpt.getID();
        this.arrival_id = arrival.getID();
    }

    public Trip(String name, Long dpt, Long arrival) {
        this.name = name;
        this.dpt_id = dpt;
        this.arrival_id = arrival;
    }

    public Trip(Long ID, String name, Long dpt, Long arrival) {
        this.ID = ID;
        this.name = name;
        this.dpt_id = dpt;
        this.arrival_id = arrival;
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Long getDpt_id() {
        return dpt_id;
    }

    public void setDpt_id(Long dpt_id) {
        this.dpt_id = dpt_id;
    }

    public long getArrival_id() {
        return arrival_id;
    }

    public void setArrival_id(long arrival_id) {
        this.arrival_id = arrival_id;
    }
}
