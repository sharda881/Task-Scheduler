package com.alpha.task_scheduler.ParkingLot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private List<ParkingLevel> parkingLevels;

    private static ParkingLot instance = null;
    private ParkingLot() {
        this.parkingLevels = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    Map<String, Ticket> vehicleVsTicket;



    public void setParkingLevels(List<ParkingLevel> parkingLevels) {
        this.parkingLevels = parkingLevels;
    }

    public void setVehicleVsTicket(Map<String, Ticket> vehicleVsTicket) {
        this.vehicleVsTicket = vehicleVsTicket;
    }

    public List<ParkingLevel> getParkingLevels() {
        return parkingLevels;
    }

    public Map<String, Ticket> getVehicleVsTicket() {
        return vehicleVsTicket;
    }

    public void addLevel(ParkingLevel parkingLevel){

        if(this.getParkingLevels()!=null){
            this.getParkingLevels().add(parkingLevel);
        }else{
            this.setParkingLevels(new ArrayList<>(List.of(parkingLevel)));
        }

    }
}
