/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kps.ata.service;

import com.kps.ata.bean.CredentialsBean;
import com.kps.ata.bean.ProfileBean;
import com.kps.ata.dao.ReservationDAO;
import com.kps.ata.dao.RouteDAO;
import com.kps.ata.dao.SignDAO;
import com.kps.ata.dao.VehicleDAO;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kps
 */
public class CustomerService {
    
    public static int authenticate(String userid,String password){
        int succ=0;
        SignDAO sDAO=new SignDAO();
        if((userid.toLowerCase().equals("admin")) && password.equals("adminpassword"))
            succ=1;
        else if(sDAO.authenticate(userid, password))
            succ=2;
        
        return succ;
    } 
    
    public static boolean CreateCustomer(CredentialsBean credentialsBean,ProfileBean profileBean){
        boolean succ;
        SignDAO sDAO=new SignDAO();
        succ=sDAO.createCustomer(credentialsBean,profileBean);
        return succ;
    }
    
    
    public static DefaultTableModel getVehicleTableModel(){
        VehicleDAO vDAO=new VehicleDAO();
        DefaultTableModel model=new DefaultTableModel();
        try{
            model=vDAO.getVehicleListTableModel();
        } catch(NullPointerException e){
            System.out.println("Error Occured while reading model!");
        }
        return model;
    }
    
    public static DefaultTableModel getRouteTableModel(){
        RouteDAO rDAO=new RouteDAO();
        DefaultTableModel model=new DefaultTableModel();
        try{
            model=rDAO.getRouteListTableModel();
        } catch(NullPointerException e){
            System.out.println("Error Occured while reading model!");
        }
        return model;
    }
    
    public static DefaultTableModel getBookingTableModel(){
        ReservationDAO rDAO=new ReservationDAO();
        DefaultTableModel model=new DefaultTableModel();
        try{
            model=rDAO.getReservationListTableModel();
        } catch(NullPointerException e){
            System.out.println("Error Occured while reading model!");
        }
        return model;
    }
    
    public static boolean deleteReservation(String reservationID){
        boolean succ=false;
        ReservationDAO rDAO=new ReservationDAO();
        try{
            succ=rDAO.deleteReservation(reservationID);
        } catch(NullPointerException e){
            succ=false;
        }
        return succ;
    }
    
}
