package com.alpha.task_scheduler.ParkingLot.controller;


import com.alpha.task_scheduler.ParkingLot.model.ParkingLot;
import com.alpha.task_scheduler.ParkingLot.model.Ticket;
import com.alpha.task_scheduler.ParkingLot.model.Vehicle;
import com.alpha.task_scheduler.ParkingLot.service.Impl.ParkingService;
import com.alpha.task_scheduler.ParkingLot.service.Impl.SmallestSlotFirstStrategy;
import com.alpha.task_scheduler.ParkingLot.service.ParkingStrategy;

public class ParkingController {

    ParkingLot parkingLot = ParkingLot.getInstance();


    public ParkingController(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }
    ParkingService parkingService = new ParkingService(parkingLot);
    ParkingStrategy parkingStrategy = new SmallestSlotFirstStrategy(parkingLot);

    public Ticket parkVehicle(Vehicle vehicle){
       return parkingService.parkVehicle(vehicle);
    }

    public long exitVehicle(String VehicleNumber){
       return parkingService.exitVehicle(VehicleNumber);
    }


}
