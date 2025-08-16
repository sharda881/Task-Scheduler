package com.alpha.task_scheduler.ParkingLot.service.Impl;

import com.learning.graph.ParkingLot.enums.SlotType;
import com.learning.graph.ParkingLot.enums.VehicleType;
import com.learning.graph.ParkingLot.model.*;
import com.learning.graph.ParkingLot.service.ParkingStrategy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.groupingBy;

public class ParkingService {

    ParkingLot parkingLot = ParkingLot.getInstance();

    public ParkingService(ParkingLot parkingLot){
        this.parkingLot =  parkingLot;
    }

    ParkingStrategy parkingStrategy = new SmallestSlotFirstStrategy(parkingLot);
    public Ticket parkVehicle(Vehicle vehicle) {
       ParkingSlot parkingSlot = parkingStrategy.findSlot(vehicle);
       parkingLot.getParkingLevels().get(Integer.parseInt(parkingSlot.getParkingLevelId())-1).getParkingSlots().get(Integer.parseInt(parkingSlot.getSlotId())).setParkedVehicle(vehicle);
       parkingLot.getParkingLevels().get(Integer.parseInt(parkingSlot.getParkingLevelId())-1).getParkingSlots().get(Integer.parseInt(parkingSlot.getSlotId())).setOccupied(true);
       Ticket ticket = new Ticket(vehicle.getVehicleNumber(),vehicle.getVehicleNumber(),parkingSlot.getSlotType().toString(), LocalDateTime.now());
       Map<String,Ticket> vehicleVsTicket = parkingLot.getVehicleVsTicket();
       vehicleVsTicket.put(vehicle.getVehicleNumber(),ticket);
       System.out.println("vehicle Parked Succesfully At level: " + parkingSlot.getParkingLevelId() + " ,In parking SlotType :"+ parkingSlot.getSlotType().toString());
       return ticket;
    }

    public long exitVehicle(String vehicleNumber) {

        parkingLot.getParkingLevels().forEach(parkingLevel -> {
            String parkingSlotId= "";
            for(ParkingSlot parkingSlot : parkingLevel.getParkingSlots()){
                if(parkingSlot.getIsOccupied() && parkingSlot.getParkedVehicle().getVehicleNumber().equals(vehicleNumber)){
                    parkingSlotId = parkingSlot.getSlotId();
                }
            }
            parkingLevel.getParkingSlots().remove(Integer.parseInt(parkingSlotId));
        });
        Map<String,Ticket> vehicleVsTicket = parkingLot.getVehicleVsTicket();
        Ticket ticket = vehicleVsTicket.get(vehicleNumber);
        long parkingFee = calculateFee(ticket);
        return parkingFee;
    }

    private long calculateFee(Ticket ticket) {
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = ticket.getEntryTime();
        Duration duration = Duration.between(startTime, endTime);
        long hours = duration.toHours()+1;
        long price=0;
        if(ticket.getVehicleType().equals(VehicleType.CAR)){
            price  = hours*200;
        }else if(ticket.getVehicleType().equals(VehicleType.BUS)){
            price = hours*500;
        }else{
            price = hours*100;
        }
        return price;
    }

    public String addLevel(Integer level,Integer motoCycleslots,Integer carSlots, Integer busSlots){

        List<ParkingSlot> allSlotsInLevel = new ArrayList<>();


        for(int i=0;i<motoCycleslots;i++){
            ParkingSlot motorcycleparkingSlot = new ParkingSlot(SlotType.MOTORCYCLE_SLOT,false,String.valueOf(level));
            motorcycleparkingSlot.setSlotId(String.valueOf(allSlotsInLevel.size()+i));
            allSlotsInLevel.add(motorcycleparkingSlot);
        }
        for(int i=0;i<carSlots;i++){
            ParkingSlot carparkingSlot =new ParkingSlot(SlotType.CAR_SLOT,false,String.valueOf(level));
            carparkingSlot.setSlotId(String.valueOf(allSlotsInLevel.size()+i));
            allSlotsInLevel.add(carparkingSlot);
        }
        for(int i=0;i<busSlots;i++){
            ParkingSlot busparkingSlot = new ParkingSlot(SlotType.BUS_SLOT,false,String.valueOf(level));
            busparkingSlot.setSlotId(String.valueOf(allSlotsInLevel.size()+i));
            allSlotsInLevel.add(busparkingSlot);
        }
        ParkingLevel parkingLevel = new ParkingLevel();
        parkingLevel.setParkingSlots(allSlotsInLevel);
        parkingLevel.setParkingLevelId(String.valueOf(level));
        this.parkingLot.addLevel(parkingLevel);
        return "Level " +  level + " added with " + motoCycleslots + " motorcycle slots, " + carSlots + " car slots and " + busSlots + " bus slots";
    }

    public void addSlots(ParkingSlot parkingSlot, Integer slots){
          String levelId = parkingSlot.getParkingLevelId();
          int flag=0;
            for(ParkingLevel parkingLevel : parkingLot.getParkingLevels()){
                if(Objects.equals(parkingLevel.getParkingLevelId(), levelId)){
                    flag=1;
                    parkingLevel.addSlot(parkingSlot);
                }
            }
            if(flag==1){
                System.out.println("Added Successfully");
            }else{
                System.out.println("Level doesn't exist");
            }
    }

    public void viewStatus(){
        if(parkingLot == null){
            System.out.println("Currently we don't have any data as nothing is added");
            return;
        }

         for(ParkingLevel parkingLevel : parkingLot.getParkingLevels()) {
              System.out.print("Level " + parkingLevel.getParkingLevelId() + ": ");
             Map<SlotType, List<ParkingSlot>> slotTypeListMap = parkingLevel.getParkingSlots().stream().collect(groupingBy(ParkingSlot::getSlotType));
             for(Map.Entry<SlotType, List<ParkingSlot>> entry : slotTypeListMap.entrySet()) {
                 List<ParkingSlot> parkingSlots = entry.getValue();
                 int cnt=0;
                 for(ParkingSlot parkingSlot: parkingSlots){
                     if(parkingSlot.getIsOccupied())cnt++;
                 }
                 System.out.print(cnt + "/" + parkingSlots.size() + " "+ entry.getKey()+ " ");
             }
             System.out.println();
         }
    }

    public void removeSlots(ParkingSlot parkingSlot, Integer slots){
        for(int i=0;i<slots;i++) {
            parkingLot.getParkingLevels().get(Integer.parseInt(parkingSlot.getParkingLevelId()) - 1).getParkingSlots().remove(Integer.parseInt(parkingSlot.getSlotId()));
        }
        System.out.println(slots + " "+parkingSlot.getSlotType().toString() + " removed from Level " + parkingSlot.getParkingLevelId());
    }

}
