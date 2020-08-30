package com.example.parkinglotdemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "parking_lot")
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String address;

    private int parkingSpaceCapacity;

    private int parkingSpaceRemainder;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getParkingSpaceCapacity() {
        return parkingSpaceCapacity;
    }

    public void setParkingSpaceCapacity(int parkingSpaceCapacity) {
        this.parkingSpaceCapacity = parkingSpaceCapacity;
    }

    public int getParkingSpaceRemainder() {
        return parkingSpaceRemainder;
    }

    public void setParkingSpaceRemainder(int parkingSpaceRemainder) {
        this.parkingSpaceRemainder = parkingSpaceRemainder;
    }
}
