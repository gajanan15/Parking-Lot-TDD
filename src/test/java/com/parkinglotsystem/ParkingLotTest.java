package com.parkinglotsystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

public class ParkingLotTest {
    private static ParkingLot parkingLot;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot();
    }

    @Test
    public void givenAParkingLotCapacityIs100_WhenCorrect_ShouldReturnTrue() {
        int parkingSize = parkingLot.getParkingSize();
        Assert.assertEquals(100, parkingSize);
    }

    @Test
    public void givenOneCarDetail_IfParked_ReturnOneCarIsParked() throws ParkingLotException {
        CarInformation carInformation = new CarInformation("MH-04-GV-7397", "BMW", "WHITE");
        Map<String, ArrayList<CarInformation>> checkParking = parkingLot.parkTheCar("S01", carInformation);
        Assert.assertEquals(1, checkParking.size());
    }

    @Test
    public void givenCarDetail_IfUnParked_Return_True() {
        CarInformation carInformation1 = new CarInformation("MH-04-GV-7397", "BMW", "WHITE");
        parkingLot.parkTheCar("s01", carInformation1);
        boolean unparkedVehicle = parkingLot.unParkCar("s01");
        Assert.assertTrue(unparkedVehicle);
    }

    @Test
    public void givenAnParkingLotIsFull_ShouldThrowException() {
        CarInformation carInformation = new CarInformation("MH 04 GV 7397", "BMW", "Black");
        try {
            for (int i = 0; i < 100; i++) {
                parkingLot.parkTheCar("s01", carInformation);
            }
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ExceptionType.PARKING_FULL, e.type);
        }
    }

    @Test
    public void givenParkingLotCapacity_WhenSpaceAvailable_ShouldReturnTrue() {
        parkingLot.parkTheCar("s01", new CarInformation("MH-04-GV-7937", "BMW", "Black"));
        parkingLot.parkTheCar("s02", new CarInformation("MH-54-BH_-2145", "BMW", "Black"));
        parkingLot.parkTheCar("s03", new CarInformation("MH-02-JS_-2145", "NANO", "Black"));
        boolean removeCar = parkingLot.unParkCar("s02");
        Assert.assertTrue(removeCar);
    }
}
