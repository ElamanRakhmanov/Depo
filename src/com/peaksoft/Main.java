package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson gson = BUILDER.setPrettyPrinting().create();
    public static final Path PATH_DRIVERS = Paths.get("./drivers.json");
    public static final Path PATH_TRUCKS = Paths.get("./trucks.json");
    public static void main(String[] args) {
        Truck[] trucks = {
                Truck.createTruck(1, "Volvo", " ", State.BASE),
        };




    }
}
