package com.peaksoft;

import java.util.Scanner;

public class TruckService {
    public static void findTruck(Truck[] trucks, Driver[] drivers){
        Scanner scan = new Scanner(System.in);
        System.out.println("The program will exit when it receives the number 0");
        while(true){
            System.out.println("Choose truck number: 1, 2, 3");
            int truckNumber = scan.nextInt();
            if(truckNumber == 0){
                break;
            }
            Truck chooseTruck = new Truck();
            for(Truck truck : trucks){
                if(truck.getIdTruck() == truckNumber){
                    chooseTruck = truck;
                }
            }
            System.out.println(chooseTruck);
            System.out.println("""
                    Choose the action you want to do:
                    1 - Assign a driver or change the driver
                    2 - On the way
                    3 - Send for repair
                    0 - Exit from program
                    """);
            int actionNumber = scan.nextInt();
            if (actionNumber == 0){
                break;
            }
            switch(actionNumber){
                case 1 -> changeDriver(chooseTruck, drivers);
                case 2 -> startDriving(chooseTruck);
                case 3 -> startRepair(chooseTruck);
            }
            System.out.println(chooseTruck);
        }

    }
    public static void changeDriver(Truck truck, Driver[] drivers){
        if(truck.getStatus().equals(State.ROUTE)){
            System.out.println("Truck on the way, can't change driver");
        } else if (truck.getStatus().equals(State.REPAIR)) {
            System.out.println("Can't change driver");
        }else{
            for (Driver driver : drivers) {
                if(driver.getTruck().equals(" ")){
                    if(!truck.getDriver().equals(" ")){

                    }
                }
            }

        }
    }



}
