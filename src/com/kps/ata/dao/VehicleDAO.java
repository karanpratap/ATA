/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kps.ata.dao;

import com.kps.ata.bean.VehicleBean;
import com.kps.ata.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author kps
 */
public class VehicleDAO {
    
    public boolean createVehicle(VehicleBean vehicleBean){
        int rows=0;
        String vehicleID=null;
        boolean flag=false;
        try(Connection conn = DBUtil.getConnection();){
            String sql="select startwith from ATA_TBL_SEQUENCES where purpose='vehicleid'";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
                vehicleID=vehicleBean.getName().substring(0, 2)+rs.getString(1);
            sql="insert into ATA_TBL_VEHICLE values (?,?,?,?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1, vehicleID);
            ps.setString(2, vehicleBean.getName());
            ps.setString(3, vehicleBean.getType());
            ps.setString(4, rs.getString(1));
            ps.setInt(5, vehicleBean.getSeatingCapacity());
            ps.setInt(6, (int)vehicleBean.getFarePerKM());
            
            rows=ps.executeUpdate();
            
            System.out.println("Vehicle Added Successfully!");
            flag=rows>0;
            if(flag){
                sql="update ATA_TBL_SEQUENCES set startwith="+Integer.toString(rs.getInt(1)+1)+" where purpose='vehicleid'";
                ps=conn.prepareStatement(sql);
                rows=ps.executeUpdate();
            }
        } catch(SQLException e ){
            e.printStackTrace();
        }
        return flag;
    }
    
    public VehicleBean getVehicleDetails(String vehicleID){
        
        int rows=0;
        ResultSet rs;
        
        VehicleBean vehicleBean=null;
        try(Connection conn = DBUtil.getConnection();){
            String sql="select * from ATA_TBL_VEHICLE where vehicleID=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, vehicleID);
            rs=ps.executeQuery();
            if(rs.next())
                vehicleBean=new VehicleBean(vehicleID, rs.getString(2), rs.getNString(3), rs.getString(4), Integer.parseInt(rs.getString(5)), Double.parseDouble(rs.getString(6)));
            System.out.println("Vehicle Info Read Successfully!");
           
        } catch(SQLException e ){
            e.printStackTrace();
        }
        
        
        return vehicleBean;
    }
    
    public boolean deleteVehicle(String vehicleID){
        
        int rows=0;
        boolean flag=false;
        try(Connection conn = DBUtil.getConnection();){
            String sql="delete from ATA_TBL_VEHICLE where vehicleID=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, vehicleID);
            rows=ps.executeUpdate();
           
            System.out.println("Vehicle Deleted Successfully!");
            flag=rows>0;   
        } catch(SQLException e ){
            e.printStackTrace();
        }
        return flag;
    }
    
    public DefaultTableModel getVehicleListTableModel(){
            String sql="select * from ATA_TBL_VEHICLE";
            
            Vector<String> colNames = new Vector<>();
            colNames.add("Vehicle ID");
            colNames.add("Vehicle Name");
            colNames.add("Vehicle Type");
            colNames.add("Reg No");
            colNames.add("Capacity");
            colNames.add("Fare per KM");
            
            Vector<Vector<String>> data = new Vector<Vector<String>>();
            
            try(Connection conn = DBUtil.getConnection()){
                
                PreparedStatement ps = conn.prepareStatement(sql);
                
                ResultSet rs=ps.executeQuery();
                Vector<String> row=null;
                
                while(rs!=null && rs.next()){
                    row=new Vector<>();
                    row.add(rs.getString(1));
                    row.add(rs.getString(2));
                    row.add(rs.getString(3));
                    row.add(rs.getString(4));
                    row.add(Integer.toString(rs.getInt(5)));
                    row.add(Integer.toString(rs.getInt(6)));
                    data.add(row);
                }
                
            } catch(SQLException e){
                e.printStackTrace();
            }
            return new DefaultTableModel(data,colNames);
        }
    
    public boolean updateVehicle(VehicleBean vehicleBean){
        
        int rows=0;
        boolean flag=false;
        try(Connection conn = DBUtil.getConnection();){
            String sql="update ATA_TBL_VEHICLE set name=?,type=?,seatingcapacity=?,fareperkm=? where vehicleID=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, vehicleBean.getName());
            ps.setString(2, vehicleBean.getType());
            ps.setInt(3, vehicleBean.getSeatingCapacity());
            ps.setInt(4, (int) vehicleBean.getFarePerKM());
            ps.setString(5, vehicleBean.getVehicleID());
            rows=ps.executeUpdate();
           
            System.out.println("Vehicle Updated Successfully!");
            flag=rows>0;   
        } catch(SQLException e ){
            e.printStackTrace();
        }
        return flag;
    }
    
}
