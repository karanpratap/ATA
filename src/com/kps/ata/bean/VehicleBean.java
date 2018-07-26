/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kps.ata.bean;

/**
 *
 * @author kps
 */
public class VehicleBean {
    
    String vehicleID;
    String name, type;
    String registrationNumber;
    int seatingCapacity;
    double farePerKM;

    public VehicleBean(String vehicleID, String name, String type, String registrationNumber, int seatingCapacity, double farePerKM) {
        this.vehicleID = vehicleID;
        this.name = name;
        this.type = type;
        this.registrationNumber = registrationNumber;
        this.seatingCapacity = seatingCapacity;
        this.farePerKM = farePerKM;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public double getFarePerKM() {
        return farePerKM;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public void setFarePerKM(double farePerKM) {
        this.farePerKM = farePerKM;
    }
    
}
