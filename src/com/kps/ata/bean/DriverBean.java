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
public class DriverBean {
    
    private String driverID, name;
    private String street, location, city, state, pinCode, mobileNo, licenseNumber;

    public DriverBean(String driverID, String name, String street, String location, String city, String state, String pinCode, String mobileNo, String licenseNumber) {
        this.driverID = driverID;
        this.name = name;
        this.street = street;
        this.location = location;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.mobileNo = mobileNo;
        this.licenseNumber = licenseNumber;
    }

    public String getDriverID() {
        return driverID;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getLocation() {
        return location;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    
    
    
}
