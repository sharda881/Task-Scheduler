package com.alpha.task_scheduler.ParkingLot.service;


import com.alpha.task_scheduler.ParkingLot.model.ParkingSlot;
import com.alpha.task_scheduler.ParkingLot.model.Vehicle;

public interface ParkingStrategy {
    ParkingSlot findSlot(Vehicle vehicle);
}
