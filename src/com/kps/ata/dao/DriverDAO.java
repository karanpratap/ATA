/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kps.ata.dao;

import com.kps.ata.bean.DriverBean;
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
public class DriverDAO {
    
    public boolean createDriver(DriverBean driverBean){
        int rows=0;
        String driverID=null;
        boolean flag=false;
        try(Connection conn = DBUtil.getConnection();){
            String sql="select startwith from ATA_TBL_SEQUENCES where purpose='driverid'";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
                driverID=driverBean.getName().substring(0, 2)+rs.getString(1);
            sql="insert into ATA_TBL_DRIVER values (?,?,?,?,?,?,?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1, driverID);
            ps.setString(2, driverBean.getName());
            ps.setString(3, driverBean.getStreet());
            ps.setString(4, driverBean.getLocation());
            ps.setString(5, driverBean.getCity());
            ps.setString(6, driverBean.getState());
            ps.setString(7, driverBean.getPinCode());
            ps.setString(8, driverBean.getMobileNo());
            ps.setString(9, driverBean.getLicenseNumber());
            
            rows=ps.executeUpdate();
            
            System.out.println("Driver Added Successfully!");
            flag=rows>0;
            if(flag){
                sql="update ATA_TBL_SEQUENCES set startwith="+Integer.toString(rs.getInt(1)+1)+" where purpose='driverid'";
                ps=conn.prepareStatement(sql);
                rows=ps.executeUpdate();
            }
        } catch(SQLException e ){
            e.printStackTrace();
        }
        return flag;
    }
    
    public DefaultTableModel getDriverListTableModel(){
            String sql="select * from ATA_TBL_DRIVER";
            
            Vector<String> colNames = new Vector<>();
            colNames.add("Driver ID");
            colNames.add("Name");
            colNames.add("Street");
            colNames.add("Location");
            colNames.add("City");
            colNames.add("State");
            colNames.add("Pin Code");
            colNames.add("Mobile No");
            colNames.add("License No");
            
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
                    row.add(rs.getString(5));
                    row.add(rs.getString(6));
                    row.add(rs.getString(7));
                    row.add(rs.getString(8));
                    row.add(rs.getString(9));
                    data.add(row);
                }
                
            } catch(SQLException e){
                e.printStackTrace();
            }
            return new DefaultTableModel(data,colNames);
        }
    
    public boolean deleteDriver(String driverID){
        
        int rows=0;
        boolean flag=false;
        try(Connection conn = DBUtil.getConnection();){
            String sql="delete from ATA_TBL_DRIVER where driverID=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, driverID);
            rows=ps.executeUpdate();
           
            System.out.println("Driver Deleted Successfully!");
            flag=rows>0;   
        } catch(SQLException e ){
            e.printStackTrace();
        }
        return flag;
    }
    
    public DriverBean getDriverDetails(String driverID){
        
        int rows=0;
        ResultSet rs;
        
        DriverBean driverBean=null;
        try(Connection conn = DBUtil.getConnection();){
            String sql="select * from ATA_TBL_DRIVER where driverID=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, driverID);
            rs=ps.executeQuery();
            if(rs.next())
                driverBean=new DriverBean(driverID, rs.getString(2), rs.getNString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            System.out.println("Driver Info Read Successfully!");
           
        } catch(SQLException e ){
            e.printStackTrace();
        }
        
        
        return driverBean;
    }
    
    public boolean updateDriver(DriverBean driverBean){
        
        int rows=0;
        boolean flag=false;
        try(Connection conn = DBUtil.getConnection();){
            String sql="update ATA_TBL_DRIVER set name=?,street=?,location=?,city=?,state=?,pincode=?,mobileno=? where driverID=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, driverBean.getName());
            ps.setString(2, driverBean.getStreet());
            ps.setString(3, driverBean.getLocation());
            ps.setString(4, driverBean.getCity());
            ps.setString(5, driverBean.getState());
            ps.setString(6, driverBean.getPinCode());
            ps.setString(7, driverBean.getMobileNo());
            ps.setString(8, driverBean.getDriverID());
            
            rows=ps.executeUpdate();
           
            System.out.println("Driver Updated Successfully!");
            flag=rows>0;   
        } catch(SQLException e ){
            e.printStackTrace();
        }
        return flag;
    }
    
}
