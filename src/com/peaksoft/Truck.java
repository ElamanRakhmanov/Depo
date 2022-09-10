package com.peaksoft;

public class Truck {
    private int id;
    private String name;
    private Driver driver;
    private State status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public com.peaksoft.State getStatus() {
        return status;
    }

    public void setStatus(State status) {
        this.status = status;
    }

    public static Truck createTruck(int id, String name, Driver driver, State status){
        Truck truck = new Truck();
        truck.id = id;
        truck.name = name;
        truck.driver = driver;
        truck.status = status;
        return truck;
    }

    @Override
    public String toString() {
        return " " + id +
                "|  " + name +
                "  |  " + driver +
                "         | " + status;
    }
}
enum State{
    BASE,
    ROUTE,
    REPAIR;
}
