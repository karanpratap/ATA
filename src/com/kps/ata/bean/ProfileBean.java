/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kps.ata.bean;

import java.util.Date;

public class ProfileBean {
    
    private String userID, firstName, lastName;
    private String street, location, city, state, pinCode;
    private String gender;
    private String mobileNo, emailID, password;
    private Date dateOfBirth;

    public ProfileBean(String userID, String firstName, String lastName, String street, String location, String city, String state, String pinCode, String gender, String mobileNo, String emailID, String password, Date dateOfBirth) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.location = location;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
        this.gender = gender;
        this.mobileNo = mobileNo;
        this.emailID = emailID;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public String getGender() {
        return gender;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getEmailID() {
        return emailID;
    }

    public String getPassword() {
        return password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    

}
