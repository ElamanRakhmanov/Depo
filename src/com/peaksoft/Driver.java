package com.peaksoft;

import java.nio.file.Path;

public class Driver {
    private int idDriver;
    private String nameDriver;
    private String truck;

    public Driver(){

    }

    public Driver(int idDriver, String nameDriver, String truck) {
        this.idDriver = idDriver;
        this.nameDriver = nameDriver;
        this.truck = truck;
    }

    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    public String getNameDriver() {
        return nameDriver;
    }

    public void setNameDriver(String nameDriver) {
        this.nameDriver = nameDriver;
    }

    public String getTruck() {
        return truck;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }

    public static Driver createDriver(int idDriver, String nameDriver, String truck){
        Driver driver = new Driver();
        driver.idDriver = idDriver;
        driver.nameDriver = nameDriver;
        driver.truck = truck;
        return driver;
    }

    @Override
    public String toString() {
        return idDriver + " | " + nameDriver + " | " + truck;
    }
}
