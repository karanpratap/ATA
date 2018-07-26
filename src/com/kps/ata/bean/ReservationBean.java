/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kps.ata.bean;

import java.util.Date;

/**
 *
 * @author kps
 */
public class ReservationBean {
    
    String reservationID, userID, routeID;
    Date bookingDate, journeyDate;
    String vehicleID, driverID;
    String bookingStatus;
    double totalFare;
    String boardingPoint, dropPoint;

    public ReservationBean(String reservationID, String userID, String routeID, Date bookingDate, Date journeyDate, String vehicleID, String driverID, String bookingStatus, double totalFare, String boardingPoint, String dropPoint) {
        this.reservationID = reservationID;
        this.userID = userID;
        this.routeID = routeID;
        this.bookingDate = bookingDate;
        this.journeyDate = journeyDate;
        this.vehicleID = vehicleID;
        this.driverID = driverID;
        this.bookingStatus = bookingStatus;
        this.totalFare = totalFare;
        this.boardingPoint = boardingPoint;
        this.dropPoint = dropPoint;
    }

    public String getReservationID() {
        return reservationID;
    }

    public String getUserID() {
        return userID;
    }

    public String getRouteID() {
        return routeID;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public Date getJourneyDate() {
        return journeyDate;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public String getDriverID() {
        return driverID;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public String getBoardingPoint() {
        return boardingPoint;
    }

    public String getDropPoint() {
        return dropPoint;
    }

    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }

    public void setBoardingPoint(String boardingPoint) {
        this.boardingPoint = boardingPoint;
    }

    public void setDropPoint(String dropPoint) {
        this.dropPoint = dropPoint;
    }
    
}
