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
    public  void givenCarDetail_IfUnParked_Return_True() {
        CarInformation carInformation1 = new CarInformation("MH-04-GV-7397", "BMW", "WHITE");
        CarInformation carInformation2= new CarInformation("MH-04-XY-5268", "Toyota", "RED");
        parkingLot.parkTheCar("s01.1",carInformation1);
        parkingLot.parkTheCar("s01.2",carInformation2);
        boolean unparkedVehicle = parkingLot.unParkCar("s01.1");
        Assert.assertTrue(unparkedVehicle);
    }

    @Test
    public void givenAnParkingLotIsNotEmpty_ShouldThrowException() {
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
    public void givenParkingLotCapacity_WhenFull_Informssecuritystaff() {
        try {
            parkingLot.parkTheCar("s01",new CarInformation("MH-04-GH_-2145","Toyota","Black")
                    , new CarInformation("MH-54-BH_-2145","BMW","Black")
                    , new CarInformation("MH-02-JS_-2145","NANO","Black")
                    , new CarInformation("MH-04-GR_-2145","NANO","Black")
                    ,new CarInformation("MH-21-VG_-2145","Toyota","Black")
                    ,new CarInformation("MH-46-AS_-2145","MARUTI","Black")
                    ,new CarInformation("MH-14-KJ_-2145","BMW","Black")
                    ,new CarInformation("MH-25-PO_-2145","Toyota","Black"));
        } catch (ParkingLotException e) {
            Assert.assertEquals(ParkingLotException.ExceptionType.PARKING_FULL, e.type);
        }
    }
}
