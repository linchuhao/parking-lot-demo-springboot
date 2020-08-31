package com.example.parkinglotdemo.advice;

import com.example.parkinglotdemo.exception.ParkingLotNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class GlobalControllerExceptionHandle {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ParkingLotNotFoundException.class)
  public String ParkingLotNotFoundException(ParkingLotNotFoundException exception) {
    return exception.getMessage();
  }
}
