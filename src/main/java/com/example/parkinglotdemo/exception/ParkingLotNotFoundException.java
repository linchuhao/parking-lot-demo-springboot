package com.example.parkinglotdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ParkingLotNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "ParkingLotNotFoundException";
    }
}