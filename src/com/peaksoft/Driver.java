package com.peaksoft;

import java.nio.file.Path;

import static com.peaksoft.Main.GSON;
import static com.peaksoft.Main.readFile;

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
    public static void infoDrivers(Path path){
        System.out.println("\n\t\tINFO ABOUT DRIVERS\n" +
                "-------------------------------\n" +
                "№   |   Name    |    Truck    |\n" +
                "-------------------------------");
        Driver[] drivers = GSON.fromJson(readFile(path), Driver[].class);
        for (Driver driver : drivers) {
            System.out.printf("%-1s   |", driver.getIdDriver());
            System.out.printf(" %-8s  |", driver.getNameDriver());
            System.out.printf(" %-10s  |", driver.getTruck());
            System.out.println("\n-------------------------------");
        }

    }

    @Override
    public String toString() {
        return idDriver + " | " + nameDriver + " | " + truck;
    }
}
