package com.parkinglotsystem;

import java.util.*;

public class ParkingLot {
    public boolean isParkingFull = false;
    Map<String, ArrayList<CarInformation>> parkingMap;
    ArrayList<CarInformation> carList = new ArrayList<>();
    public static final int capacity = 100;
    int initialSlotCapacity = 25;

    public ParkingLot() {
        parkingMap = new HashMap<String, ArrayList<CarInformation>>();
    }

    public int getParkingSize() {
        return capacity;
    }

    public Map<String, ArrayList<CarInformation>> parkTheCar(String slotNumber, CarInformation... carDetails) {
        if (carDetails != null) {
            parkingMap.put(slotNumber, carList);
            for (CarInformation details : carDetails) {
                if (carList.size() != initialSlotCapacity) {
                    parkingMap.get(slotNumber).add(details);
                } else {
                    throw new ParkingLotException("No Empty Sloat", ParkingLotException.ExceptionType.PARKING_FULL);
                }
            }
            return parkingMap;
        }
        return null;
    }

    public void isParkingSpaceAvailable() {
        if (isParkingFull) {
            throw new ParkingLotException("No Parking Space Available!!!", ParkingLotException.ExceptionType.PARKING_FULL);
        }
    }

    public boolean unParkCar(String slotNumber) {
        Iterator<Map.Entry<String, ArrayList<CarInformation>>> iterator = parkingMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList<CarInformation>> entry = iterator.next();
            if (slotNumber == entry.getKey()) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
