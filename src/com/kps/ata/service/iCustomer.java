/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kps.ata.service;

import com.kps.ata.bean.ReservationBean;
import com.kps.ata.bean.RouteBean;
import com.kps.ata.bean.VehicleBean;
import java.util.ArrayList;

/**
 *
 * @author kps
 */
public interface iCustomer {
    
    ArrayList<VehicleBean> viewVehiclesByType(String vehicleType);
    ArrayList<VehicleBean> viewVehicleBySeats(int noOfSeats);
    ArrayList<RouteBean> viewAllRoutes();
    String bookVehicle(ReservationBean reservationBean);
    boolean cancelBooking(String userID, String reservationID);
    ReservationBean viewBookingDetails(String reservationID);
    ReservationBean printBookingDetails(String reservationID);
    
}
