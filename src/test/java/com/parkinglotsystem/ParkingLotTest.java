package com.parkinglotsystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
    private static ParkingLot parkingLot;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot();
    }

    @Test
    public void givenAParkingLotCapacityIs100_WhenCorrect_ShouldReturnTrue() throws ParkingLotException {
        CarInformation carInformation = new CarInformation("jhbfv", "hbgrfr", "black");
        Boolean car = parkingLot.parkTheCar("s01", carInformation);
        int parkingSize = parkingLot.getParkingSize();
        Assert.assertEquals(100, parkingSize);
    }

    @Test
    public void givenAnEmptyParkingLot_ShouldReturn100AvailableSlots() throws ParkingLotException {
        CarInformation carInformation = new CarInformation("jhbfv", "hbgrfr", "black");
        Boolean car = parkingLot.parkTheCar("s01", carInformation);
        int parkingSize = parkingLot.getParkingSize();
        Assert.assertEquals(100, parkingSize);
    }

    @Test
    public void givenCarDetail_IfParked_Return_True() throws ParkingLotException {
        CarInformation carInformation = new CarInformation("MH-04-GV-7397", "BMW", "WHITE");
        Boolean checkParking = parkingLot.parkVehicle("S01", carInformation);
        Assert.assertTrue(checkParking);
    }

    @Test
    public void givenAnParkingLotIsNotEmpty_ShouldThrowException() {
        CarInformation carInformation = new CarInformation("MH 04 GV 7397", "BMW", "Black");
        try {
            for (int i = 0; i < 100; i++) {
                parkingLot.parkTheCar("s01", carInformation);
            }
            parkingLot.parkTheCar("s01", carInformation);
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ExceptionType.PARKING_FULL, e.type);
        }
    }

    @Test
    public  void givenCarDetail_IfUnParked_Return_True() {
        parkingLot.unParkCar("s01");
        boolean checkForVehicle = parkingLot.searchVehicle("s01");
        Assert.assertTrue(checkForVehicle);
    }
}
