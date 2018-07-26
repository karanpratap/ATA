/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kps.ata.service;

import com.kps.ata.bean.DriverBean;
import com.kps.ata.bean.RouteBean;
import com.kps.ata.bean.VehicleBean;
import com.kps.ata.dao.DriverDAO;
import com.kps.ata.dao.RouteDAO;
import com.kps.ata.dao.SignDAO;
import com.kps.ata.dao.VehicleDAO;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kps
 */
public class AdminService {
    
    public static int addVehicle(VehicleBean vehicleBean){
        int succ=0;
        VehicleDAO vDAO=new VehicleDAO();
        if(vDAO.createVehicle(vehicleBean))
            if(vehicleBean.getType().equals("AC"))
                succ=1;
            else
                succ=2;
        
        return succ;
    } 
    
    public static boolean addDriver(DriverBean driverBean){
        boolean succ= false;
        DriverDAO dDAO=new DriverDAO();
        if(dDAO.createDriver(driverBean))
            succ=true;
        return succ;
    }
    
    public static boolean addRoute(RouteBean routeBean){
        boolean succ= false;
        RouteDAO rDAO=new RouteDAO();
        if(rDAO.createRoute(routeBean))
            succ=true;
        return succ;
    }
    
    public static VehicleBean confirmDeleteVehicle(String vehicleID){
        VehicleDAO vDAO=new VehicleDAO();
        try{
            VehicleBean vBean=vDAO.getVehicleDetails(vehicleID);
            return vBean;
        } catch(NullPointerException e){
            return null;   
        }
        
    }
    
    public static boolean deleteVehicle(String vehicleID){
        boolean succ=false;
        VehicleDAO vDAO=new VehicleDAO();
        try{
            succ=vDAO.deleteVehicle(vehicleID);
        } catch(NullPointerException e){
            succ=false;
        }
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
    
    public static DefaultTableModel getBookTableModel(){
        VehicleDAO vDAO=new VehicleDAO();
        DefaultTableModel model=new DefaultTableModel();
        try{
            model=vDAO.getVehicleListTableModel();
        } catch(NullPointerException e){
            System.out.println("Error Occured while reading model!");
        }
        return model;
    }
    
    public static VehicleBean getVehicleDetails(String vehicleID){
        VehicleDAO vDAO=new VehicleDAO();
        VehicleBean vBean=null;
        try{
            vBean=vDAO.getVehicleDetails(vehicleID);
        } catch(NullPointerException e){
            e.printStackTrace();
        }
        return vBean;
    }
    
    public static boolean updateVehicleDetails(VehicleBean vehicleBean){
        VehicleDAO vDAO=new VehicleDAO();
        boolean succ=false;
        try{
            succ=vDAO.updateVehicle(vehicleBean);
        } catch(Exception e){
            e.printStackTrace();
        }
        return succ;
    }
    
    public static DefaultTableModel getDriverTableModel(){
        DriverDAO dDAO=new DriverDAO();
        DefaultTableModel model=new DefaultTableModel();
        try{
            model=dDAO.getDriverListTableModel();
        } catch(NullPointerException e){
            System.out.println("Error Occured while reading model!");
        }
        return model;
    }
    
    public static boolean deleteDriver(String driverID){
        boolean succ=false;
        DriverDAO dDAO=new DriverDAO();
        try{
            succ=dDAO.deleteDriver(driverID);
        } catch(NullPointerException e){
            succ=false;
        }
        return succ;
    }
    
    public static boolean deleteRoute(String routeID){
        boolean succ=false;
        RouteDAO rDAO=new RouteDAO();
        try{
            succ=rDAO.deleteRoute(routeID);
        } catch(NullPointerException e){
            succ=false;
        }
        return succ;
    }
    
    public static DriverBean getDriverDetails(String driverID){
        DriverDAO dDAO=new DriverDAO();
        DriverBean dBean=null;
        try{
            dBean=dDAO.getDriverDetails(driverID);
        } catch(NullPointerException e){
            e.printStackTrace();
        }
        return dBean;
    }
    
    public static boolean updateDriverDetails(DriverBean driverBean){
        DriverDAO dDAO=new DriverDAO();
        boolean succ=false;
        try{
            succ=dDAO.updateDriver(driverBean);
        } catch(Exception e){
            e.printStackTrace();
        }
        return succ;
    }
    
    public static RouteBean getRouteDetails(String routeID){
        RouteDAO rDAO=new RouteDAO();
        RouteBean rBean=null;
        try{
            rBean=rDAO.getRouteDetails(routeID);
        } catch(NullPointerException e){
            e.printStackTrace();
        }
        return rBean;
    }
    
    public static boolean updateRouteDetails(RouteBean routeBean){
        RouteDAO rDAO=new RouteDAO();
        boolean succ=false;
        try{
            succ=rDAO.updateRoute(routeBean);
        } catch(Exception e){
            e.printStackTrace();
        }
        return succ;
    }
    
}
