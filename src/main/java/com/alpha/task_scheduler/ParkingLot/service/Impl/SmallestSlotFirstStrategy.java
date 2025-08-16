package com.alpha.task_scheduler.ParkingLot.service.Impl;


import com.alpha.task_scheduler.ParkingLot.enums.SlotType;
import com.alpha.task_scheduler.ParkingLot.enums.VehicleType;
import com.alpha.task_scheduler.ParkingLot.model.ParkingLevel;
import com.alpha.task_scheduler.ParkingLot.model.ParkingLot;
import com.alpha.task_scheduler.ParkingLot.model.ParkingSlot;
import com.alpha.task_scheduler.ParkingLot.model.Vehicle;
import com.alpha.task_scheduler.ParkingLot.service.ParkingStrategy;

import java.util.List;
import java.util.Optional;

public class SmallestSlotFirstStrategy implements ParkingStrategy {
    ParkingLot parkingLot = ParkingLot.getInstance();
    public SmallestSlotFirstStrategy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }


    @Override
    public ParkingSlot findSlot(Vehicle vehicle) {
        VehicleType vehicleType = vehicle.getVehicleType();
        List<ParkingLevel> levelsWithFreeSlots = parkingLot.getParkingLevels().stream()
                .filter(level -> level.getParkingSlots().stream()
                        .anyMatch(slot -> !slot.getIsOccupied()))
                .toList();
        ParkingSlot parkingSlot = new ParkingSlot();

        switch (vehicleType.toString()) {
            case "CAR":
                System.out.println("The vehicle is a Car.");
                for(ParkingLevel level : levelsWithFreeSlots) {
                    Optional<ParkingSlot> carSpot = findAvailableSlotsByType(level, SlotType.CAR_SLOT);
                    if (carSpot.isPresent()) {
                        parkingSlot = carSpot.get();
                        break;
                    }
                    Optional<ParkingSlot> busSpotForCar = findAvailableSlotsByType(level, SlotType.BUS_SLOT);
                    if (busSpotForCar.isPresent()) {
                        parkingSlot = busSpotForCar.get();
                    }
                }
                break;
            case "BUS":
                System.out.println("The vehicle is a Bus.");
                for(ParkingLevel level : levelsWithFreeSlots) {
                    Optional<ParkingSlot> busSpot = findAvailableSlotsByType(level, SlotType.BUS_SLOT);
                    if (busSpot.isPresent()) {
                        parkingSlot = busSpot.get();
                    }
                }
                break;
            case "MOTORCYCLE":
                System.out.println("The vehicle is a Motorcycle.");
                for(ParkingLevel level : levelsWithFreeSlots) {
                    Optional<ParkingSlot> motorcycleSpot = findAvailableSlotsByType(level, SlotType.MOTORCYCLE_SLOT);
                    if (motorcycleSpot.isPresent()) {
                        parkingSlot = motorcycleSpot.get();
                        break;
                    }
                    Optional<ParkingSlot> carSpotForMc = findAvailableSlotsByType(level, SlotType.CAR_SLOT);
                    if (carSpotForMc.isPresent()) {
                        parkingSlot = carSpotForMc.get();
                        break;
                    }
                    Optional<ParkingSlot> busSpotForMc = findAvailableSlotsByType(level, SlotType.BUS_SLOT);
                    if (busSpotForMc.isPresent()) {
                        parkingSlot = busSpotForMc.get();
                    }
                }
                break;
        }
        return parkingSlot;
    }

    private Optional<ParkingSlot> findAvailableSlotsByType(ParkingLevel level, SlotType slotType){
        return level.getParkingSlots().stream().filter(parkingSlot -> parkingSlot.getSlotType()==slotType).findFirst();
    }
}
