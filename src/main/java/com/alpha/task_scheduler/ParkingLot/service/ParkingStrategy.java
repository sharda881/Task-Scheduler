package com.alpha.task_scheduler.ParkingLot.service;

import com.learning.graph.ParkingLot.model.ParkingSlot;
import com.learning.graph.ParkingLot.model.Vehicle;

public interface ParkingStrategy {
    ParkingSlot findSlot(Vehicle vehicle);
}
