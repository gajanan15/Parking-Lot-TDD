package com.parkinglotsystem;

public class ParkingLotException extends Exception {
    public ExceptionType type;

    public enum ExceptionType {
        PARKING_FULL
    }

    public ParkingLotException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}
