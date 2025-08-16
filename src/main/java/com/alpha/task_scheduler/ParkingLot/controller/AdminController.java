package com.alpha.task_scheduler.ParkingLot.controller;


import com.alpha.task_scheduler.ParkingLot.model.ParkingLot;
import com.alpha.task_scheduler.ParkingLot.model.ParkingSlot;
import com.alpha.task_scheduler.ParkingLot.service.Impl.ParkingService;
import com.alpha.task_scheduler.ParkingLot.service.Impl.SmallestSlotFirstStrategy;
import com.alpha.task_scheduler.ParkingLot.service.ParkingStrategy;

public class AdminController {

    ParkingLot parkingLot = ParkingLot.getInstance();

    public AdminController(ParkingLot parkingLot ){
        this.parkingLot=parkingLot;
    }

    ParkingService parkingService = new ParkingService(parkingLot);
    ParkingStrategy parkingStrategy = new SmallestSlotFirstStrategy(parkingLot);


    public String addLevel(Integer level,Integer motoCycleslots,Integer carSlots, Integer busSlots){
        return parkingService.addLevel(level, motoCycleslots, carSlots, busSlots);
    }

    public void addSlots(ParkingSlot parkingSlot, Integer slots){
        parkingService.addSlots(parkingSlot,slots);
    }

    public void viewStatus(){
        parkingService.viewStatus();
    }

    public void removeSlots(ParkingSlot parkingSlot, Integer slots){
        parkingService.removeSlots(parkingSlot,slots);
    }
}
