package com.alpha.task_scheduler.ParkingLot;

import com.learning.graph.ParkingLot.controller.AdminController;
import com.learning.graph.ParkingLot.controller.ParkingController;
import com.learning.graph.ParkingLot.enums.SlotType;
import com.learning.graph.ParkingLot.enums.VehicleType;
import com.learning.graph.ParkingLot.model.ParkingLot;
import com.learning.graph.ParkingLot.model.ParkingSlot;
import com.learning.graph.ParkingLot.model.Ticket;
import com.learning.graph.ParkingLot.model.Vehicle;

import java.util.Scanner;

public class ParkingApplication {

    ParkingLot parkingLot = ParkingLot.getInstance();

    ParkingController parkingController = new ParkingController(parkingLot);
    AdminController adminController = new AdminController(parkingLot);

    public static void main(String[] args) {
        ParkingApplication parkingApplication = new ParkingApplication();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Parking Lot Application");
        System.out.println("Please Enter Your Choice Among the Following");
        System.out.println("1. PARK_VEHICLE");
        System.out.println("2. EXIT_VEHICLE");
        System.out.println("3. ADD_LEVEL");
        System.out.println("4. ADD_SLOTS");
        System.out.println("5. VIEW_STATUS");
        System.out.println("6. REMOVE_SLOTS");
        System.out.println("Or Enter EXIT to Exit the Application");

        while(true){
            String inputLine = scanner.nextLine();
            if(inputLine.equals("EXIT")){
                System.out.println("Thanks for using Parking Lot Application, BYE!!");
                break;
            }
            String[] parts = inputLine.split(" ");


            switch(parts[0]){
                case "PARK_VEHICLE":
                    String vehicleType = parts[1];
                    String vehicleNumber = parts[2];
                    Ticket ticket = parkingApplication.parkingController.parkVehicle(new Vehicle(vehicleNumber, VehicleType.valueOf(vehicleType)));
                    break;
                case "EXIT_VEHICLE":
                    String VehicleNumber = parts[1];
                    long parkingFee = parkingApplication.parkingController.exitVehicle(VehicleNumber);
                    System.out.println("vehice Exited with parking fee : "+ parkingFee);
                    break;
                case "ADD_LEVEL":
                    Integer level = Integer.parseInt(parts[1]);
                    Integer motoCycleslots = Integer.parseInt(parts[2]);
                    Integer carSlots = Integer.parseInt(parts[3]);
                    Integer busSlots = Integer.parseInt(parts[4]);
                    System.out.println(parkingApplication.adminController.addLevel(level, motoCycleslots, carSlots, busSlots));
                    break;
                case "ADD_SLOTS":
                    String levelNumber = parts[1];
                    String vehicleType1 = parts[2] + "_SLOT";
                    Integer slots = Integer.parseInt(parts[3]);
                    ParkingSlot parkingSlot = new ParkingSlot(SlotType.valueOf(vehicleType1), false,levelNumber);
                    parkingApplication.adminController.addSlots(parkingSlot,slots);
                    break;
                case "VIEW_STATUS":
                    parkingApplication.adminController.viewStatus();
                    break;
                case "REMOVE_SLOTS":
                    String removefromlevelNumber = parts[1];
                    String removevehicleType1 = parts[2];
                    Integer removeslots = Integer.parseInt(parts[3]);
                    ParkingSlot removeparkingSlot = new ParkingSlot(SlotType.valueOf(removevehicleType1), false,removefromlevelNumber);
                    parkingApplication.adminController.removeSlots(removeparkingSlot,removeslots);
                    break;
            }
        }

    }
}
