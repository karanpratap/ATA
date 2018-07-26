/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kps.ata.dao;

import com.kps.ata.bean.RouteBean;
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
public class RouteDAO {
    
    public boolean createRoute(RouteBean routeBean){
        int rows=0;
        String routeID=null;
        boolean flag=false;
        try(Connection conn = DBUtil.getConnection();){
            String sql="select startwith from ATA_TBL_SEQUENCES where purpose='routeid'";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
                routeID=routeBean.getSource().substring(0, 1)+routeBean.getDestination().substring(0,1)+rs.getString(1);
            sql="insert into ATA_TBL_ROUTE values (?,?,?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1, routeID);
            ps.setString(2, routeBean.getSource());
            ps.setString(3, routeBean.getDestination());
            ps.setInt(4, routeBean.getDistance());
            ps.setInt(5, routeBean.getTravelDuration());
            rows=ps.executeUpdate();
            
            System.out.println("Route Added Successfully!");
            flag=rows>0;
            if(flag){
                sql="update ATA_TBL_SEQUENCES set startwith="+Integer.toString(rs.getInt(1)+1)+" where purpose='routeid'";
                ps=conn.prepareStatement(sql);
                rows=ps.executeUpdate();
            }
        } catch(SQLException e ){
            e.printStackTrace();
        }
        return flag;
    }
    
    public DefaultTableModel getRouteListTableModel(){
            String sql="select * from ATA_TBL_ROUTE";
            
            Vector<String> colNames = new Vector<>();
            colNames.add("Route ID");
            colNames.add("Source");
            colNames.add("Destination");
            colNames.add("Distance");
            colNames.add("Travel Duration");
            
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
                    row.add(Integer.toString(rs.getInt(4)));
                    row.add(Integer.toString(rs.getInt(5)));
                    data.add(row);
                }
                
            } catch(SQLException e){
                e.printStackTrace();
            }
            return new DefaultTableModel(data,colNames);
        }
    
    public boolean deleteRoute(String routeID){
        
        int rows=0;
        boolean flag=false;
        try(Connection conn = DBUtil.getConnection();){
            String sql="delete from ATA_TBL_ROUTE where routeID=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, routeID);
            rows=ps.executeUpdate();
           
            System.out.println("Route Deleted Successfully!");
            flag=rows>0;   
        } catch(SQLException e ){
            e.printStackTrace();
        }
        return flag;
    }
    
    public RouteBean getRouteDetails(String routeID){
        
        int rows=0;
        ResultSet rs;
        
        RouteBean routeBean=null;
        try(Connection conn = DBUtil.getConnection();){
            String sql="select * from ATA_TBL_ROUTE where routeID=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, routeID);
            rs=ps.executeQuery();
            if(rs.next())
                routeBean=new RouteBean(routeID, rs.getString(2), rs.getNString(3), Integer.parseInt(rs.getString(4)), Integer.parseInt(rs.getString(5)));
            System.out.println("Route Info Read Successfully!");
           
        } catch(SQLException e ){
            e.printStackTrace();
        }
        
        
        return routeBean;
    }
    
     public boolean updateRoute(RouteBean routeBean){
        
        int rows=0;
        boolean flag=false;
        try(Connection conn = DBUtil.getConnection();){
            String sql="update ATA_TBL_ROUTE set source=?,destination=?,distance=?,travelduration=? where routeID=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, routeBean.getSource());
            ps.setString(2, routeBean.getDestination());
            ps.setInt(3, routeBean.getDistance());
            ps.setInt(4, routeBean.getTravelDuration());
            ps.setString(5, routeBean.getRouteID());
            rows=ps.executeUpdate();
           
            System.out.println("Route Updated Successfully!");
            flag=rows>0;   
        } catch(SQLException e ){
            e.printStackTrace();
        }
        return flag;
    }
    
}
