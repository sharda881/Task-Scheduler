package com.alpha.task_scheduler.ParkingLot.model;

import com.learning.graph.ParkingLot.enums.SlotType;

public class BusSlot extends ParkingSlot{

    public BusSlot(SlotType slotType, boolean isOccupied, String parkingLevelId) {
        super(slotType, isOccupied, parkingLevelId);
    }
}
