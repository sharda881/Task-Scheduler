package com.alpha.task_scheduler.ParkingLot.model;

import com.learning.graph.ParkingLot.enums.SlotType;

public class CarSlot extends ParkingSlot {

    public CarSlot(SlotType slotType, boolean isOccupied, String parkingLevelId) {
        super(slotType, isOccupied, parkingLevelId);
    }
}
