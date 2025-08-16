package com.alpha.task_scheduler.ParkingLot.model;

import com.learning.graph.ParkingLot.enums.VehicleType;

public class Vehicle {

    private String VehicleNumber;
    private VehicleType vehicleType;
    private ParkingSlot parkingSlot;

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public Vehicle(String vehicleNumber, VehicleType vehicleType) {
        VehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }


}
