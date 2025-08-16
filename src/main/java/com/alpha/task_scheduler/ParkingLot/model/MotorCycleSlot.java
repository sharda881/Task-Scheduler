package com.alpha.task_scheduler.ParkingLot.model;

import com.learning.graph.ParkingLot.enums.SlotType;

public class MotorCycleSlot extends ParkingSlot{

    public MotorCycleSlot(SlotType slotType, boolean isOccupied, String parkingLevelId) {
        super(slotType, isOccupied, parkingLevelId);
    }
}
