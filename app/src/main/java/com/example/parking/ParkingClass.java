package com.example.parking;

public class ParkingClass {
    private String id,name,zone;

    public ParkingClass() {
    }

    public ParkingClass(String id, String name, String zone) {
        this.id = id;
        this.name = name;
        this.zone = zone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
}
