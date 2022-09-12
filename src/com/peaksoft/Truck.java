package com.peaksoft;

import java.nio.file.Path;

import static com.peaksoft.Main.*;

public class Truck {
    private int idTruck;
    private String nameTruck;
    private String driver;
    private State status;

    public int getIdTruck() {
        return idTruck;
    }

    public void setIdTruck(int idTruck) {
        this.idTruck = idTruck;
    }

    public String getNameTruck() {
        return nameTruck;
    }

    public void setNameTruck(String nameTruck) {
        this.nameTruck = nameTruck;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public State getStatus() {
        return status;
    }

    public void setStatus(State status) {
        this.status = status;
    }

    public static Truck createTruck(int idTruck, String nameTruck, String driver, State status){
        Truck truck = new Truck();
        truck.idTruck = idTruck;
        truck.nameTruck = nameTruck;
        truck.driver = driver;
        truck.status = status;
        return truck;
    }

    public static void infoTruck(Path path){
        System.out.println("\n\t\tINFO ABOUT TRUCKS\n" +
                "---------------------------------------------------\n" +
                "№   |   Truck         |    Driver   |   State     |\n" +
                "---------------------------------------------------");
        Truck[] trucks = GSON.fromJson(readFile(path), Truck[].class);
        for (Truck truck : trucks) {
            System.out.printf("%-1s   |", truck.getIdTruck());
            System.out.printf(" %-14s  |", truck.getNameTruck());
            System.out.printf(" %-10s  |", truck.getDriver());
            System.out.printf(" %-10s  |", truck.getStatus());
            System.out.println("\n---------------------------------------------------");
        }
    }


    @Override
    public String toString() {
        return " " + idTruck + "|  " + nameTruck + "  |  " + driver + "         | " + status;
    }
}
enum State{
    BASE,
    ROUTE,
    REPAIR;
}
