package com.alpha.task_scheduler.ParkingLot.model;


import com.alpha.task_scheduler.ParkingLot.enums.SlotType;

public class ParkingSlot {
    private String slotId;
    private SlotType slotType;
    private boolean isOccupied;
    private String parkingLevelId;
    private Vehicle parkedVehicle;

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    public ParkingSlot() {
    }

    public ParkingSlot(SlotType slotType, boolean isOccupied, String parkingLevelId) {
        this.slotType = slotType;
        this.isOccupied = isOccupied;
        this.parkingLevelId = parkingLevelId;
    }



    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }



    public void setParkingLevelId(String parkingLevelId) {
        this.parkingLevelId = parkingLevelId;
    }

    public String getSlotId() {
        return slotId;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }


    public String getParkingLevelId() {
        return parkingLevelId;
    }




}
