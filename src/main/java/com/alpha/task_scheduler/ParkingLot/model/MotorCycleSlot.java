package com.alpha.task_scheduler.ParkingLot.model;


import com.alpha.task_scheduler.ParkingLot.enums.SlotType;

public class MotorCycleSlot extends ParkingSlot{

    public MotorCycleSlot(SlotType slotType, boolean isOccupied, String parkingLevelId) {
        super(slotType, isOccupied, parkingLevelId);
    }
}
