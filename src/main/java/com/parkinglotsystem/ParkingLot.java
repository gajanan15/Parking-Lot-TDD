package com.parkinglotsystem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    public boolean isParkingFull = false;
    Map<String, CarInformation> parkingMap;
    List<CarInformation> carList;
    public static final int capacity = 100;

    public ParkingLot() {
        parkingMap = new HashMap<>();
        carList = new LinkedList<>();
    }

    public int getParkingSize() {
        return capacity;
    }

    public Boolean parkTheCar(String slotNumber, CarInformation carDetails) throws ParkingLotException {
        isParkingSpaceAvailable();
        if (carList.size() < capacity) {
            carList.add(carDetails);
            parkingMap.put(slotNumber, carDetails);
        }
        if (carList.size() >= capacity) {
            return isParkingFull = true;
        }
        return false;
    }

    public void isParkingSpaceAvailable() throws ParkingLotException {
        if (isParkingFull) {
            throw new ParkingLotException("No Parking Space Available!!!", ParkingLotException.ExceptionType.PARKING_FULL);
        }
    }

    public Boolean parkVehicle(String slotNumber, CarInformation carDetails) {
        if (parkingMap.size() < 100) {
            parkingMap.put(slotNumber, carDetails);
            return true;
        }
        return false;
    }

    public void unParkCar(String slotNumber) {
        parkingMap.remove(slotNumber);
    }

    public boolean searchVehicle(String slotNumber) {
        if(parkingMap.get(slotNumber)!=null)
            return false;
        return true;
    }
}
