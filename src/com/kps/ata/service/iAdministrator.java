/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kps.ata.service;

import com.kps.ata.bean.DriverBean;
import com.kps.ata.bean.ReservationBean;
import com.kps.ata.bean.RouteBean;
import com.kps.ata.bean.VehicleBean;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kps
 */
public interface iAdministrator {
    
    String addVehicle(VehicleBean vehicleBean);
    int deleteVehicle(String vehicleID);
    VehicleBean viewVehicle(String vehicleID);
    boolean modifyVehicle(VehicleBean vehicleBean);
    String addDriver(DriverBean driverBean);
    int deleteDriver(String driverID);
    boolean allotDriver(String reservationID, String driverID);
    boolean modifyDriver(DriverBean driverBean);
    String addRoute(RouteBean routeBean);
    int deleteRoute(String routeID);
    RouteBean viewRoute(String routeID);
    boolean modifyRoute(RouteBean routeBean);
    ArrayList<ReservationBean> viewBookingDetails(Date journeyDate,String source, String destination);
    
}
