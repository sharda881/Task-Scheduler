package com.alpha.task_scheduler.ParkingLot.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingLevel {
    private String parkingLevelId;
    private List<ParkingSlot> parkingSlots;

    public void setParkingLevelId(String parkingLevelId) {
        this.parkingLevelId = parkingLevelId;
    }


    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public String getParkingLevelId() {
        return parkingLevelId;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public ParkingLevel() {

    }

    public void addSlot(ParkingSlot parkingSlot){
        if(this.getParkingSlots()!=null){
            this.getParkingSlots().add(parkingSlot);
        }else{
            this.setParkingSlots(new ArrayList<>(List.of(parkingSlot)));
        }
    }

}
