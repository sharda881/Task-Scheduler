package com.alpha.task_scheduler.ParkingLot.model;

import java.time.LocalDateTime;

public class Ticket {

    private String ticketId;
    private String vehicleNumber;
    private String vehicleType;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public Ticket(String ticketId, String vehicleNumber, String vehicleType, LocalDateTime entryTime) {
        this.ticketId = ticketId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.entryTime = entryTime;

    }

}
