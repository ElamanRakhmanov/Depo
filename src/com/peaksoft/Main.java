package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path PATH_DRIVERS = Paths.get("./drivers.json");
    public static final Path PATH_TRUCKS = Paths.get("./trucks.json");
    public static void main(String[] args) {
        Truck[] trucks = {
                Truck.createTruck(1, "Renault Magnum", " ", State.BASE),
                Truck.createTruck(2, "Volvo", " ", State.BASE),
                Truck.createTruck(3, "Dump Truck", " ", State.BASE),
        };
        Driver[] drivers = {
                Driver.createDriver(1,"Bektur", " "),
                Driver.createDriver(2,"Almaz", " "),
                Driver.createDriver(3,"Talant", " "),

        };
        writeFile(GSON.toJson(trucks), PATH_TRUCKS);
        writeFile(GSON.toJson(drivers), PATH_DRIVERS);
        readFile(PATH_TRUCKS);
        readFile(PATH_DRIVERS);

        infoTruck(PATH_TRUCKS);
        infoDrivers(PATH_DRIVERS);
    }
    public static void infoTruck(Path path){
        System.out.println("\n\t\tINFO ABOUT TRUCKS\n" +
                "---------------------------------------------------\n" +
                "№   |   Truck         |    Driver   |   State     |\n" +
                "---------------------------------------------------");
        Truck[] trucks = GSON.fromJson(readFile(path), Truck[].class);
        for (Truck truck : trucks) {
            System.out.printf("%-1s   |", truck.getId());
            System.out.printf(" %-14s  |", truck.getName());
            System.out.printf(" %-10s  |", truck.getDriver());
            System.out.printf(" %-10s  |", truck.getStatus());
            System.out.println("\n---------------------------------------------------");
        }
    }
    public static void infoDrivers(Path path){
        System.out.println("\n\t\tINFO ABOUT DRIVERS\n" +
                "-------------------------------\n" +
                "№   |   Name    |    Truck    |\n" +
                "-------------------------------");
        Driver[] drivers = GSON.fromJson(readFile(path), Driver[].class);
        for (Driver driver : drivers) {
            System.out.printf("%-1s   |", driver.getId());
            System.out.printf(" %-8s  |", driver.getName());
            System.out.printf(" %-10s  |", driver.getTruck());
            System.out.println("\n-------------------------------");
        }
    }
    private static void writeFile(String object, Path path){
        try {
            Files.writeString(Paths.get(String.valueOf(path)), object,
                    StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        }catch(Exception e){
            e.getMessage();
        }
    }
    static String readFile(Path path){
        String json = "";
        try{
            FileReader reader = new FileReader(String.valueOf(path));
            int a;
            while((a = reader.read()) != -1){
                json += (char) a;
            }
        }catch(Exception e){
            e.getMessage();
        }
        return  json;
    }
}
