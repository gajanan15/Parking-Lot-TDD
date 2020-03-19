package com.parkinglotsystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
    private static ParkingLot parkingLot;
    @Before
    public void setUp() throws Exception {
         parkingLot =new ParkingLot();
    }

    @Test
    public void givenAParkingLotCapacityIs100_WhenCCorrect_ShouldReturnTrue() {
        int parkingSize = parkingLot.getParkingSize();
        Assert.assertEquals(100,parkingSize);
    }

    @Test
    public void givenAnEmptyParkingLot_ShouldReturn100AvailableSlots() {
        int availableSlots = parkingLot.getParkingSize();
        Assert.assertEquals(100,availableSlots);
    }
}
