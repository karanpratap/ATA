/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kps.ata.dao;

import com.kps.ata.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kps
 */
public class ReservationDAO {
    
    public DefaultTableModel getReservationListTableModel(){
            String sql="select * from ATA_TBL_RESERVATION";
            
            Vector<String> colNames = new Vector<>();
            colNames.add("Reservation ID");
            colNames.add("User ID");
            colNames.add("Vehicle ID");
            colNames.add("Route ID");
            colNames.add("Booking Date");
            colNames.add("Jorney Date");
            colNames.add("Driver ID");
            colNames.add("Booking Status");
            colNames.add("Total Fare");
            colNames.add("Boarding Point");
            colNames.add("Drop Point");
                        
            Vector<Vector<String>> data = new Vector<Vector<String>>();
            
            try(Connection conn = DBUtil.getConnection()){
                
                PreparedStatement ps = conn.prepareStatement(sql);
                
                ResultSet rs=ps.executeQuery();
                Vector<String> row=null;
                java.util.Date uDate=null;
                while(rs!=null && rs.next()){
                    row=new Vector<>();
                    row.add(rs.getString(1));
                    row.add(rs.getString(2));
                    row.add(rs.getString(3));
                    row.add(rs.getString(4));
                    uDate=rs.getTimestamp(5);
                    row.add(uDate.toString());
                    uDate=rs.getTimestamp(6);
                    row.add(uDate.toString());
                    row.add(rs.getString(7));
                    row.add(rs.getString(8));
                    row.add(Integer.toString(rs.getInt(9)));
                    row.add(rs.getString(10));
                    row.add(rs.getString(11));
                    data.add(row);
                }
                
            } catch(SQLException e){
                e.printStackTrace();
            }
            return new DefaultTableModel(data,colNames);
        }
    
    public boolean deleteReservation(String reservationID){
        
        int rows=0;
        boolean flag=false;
        try(Connection conn = DBUtil.getConnection();){
            String sql="delete from ATA_TBL_RESERVATION where reservationID=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, reservationID);
            rows=ps.executeUpdate();
           
            System.out.println("Booking Deleted Successfully!");
            flag=rows>0;   
        } catch(SQLException e ){
            e.printStackTrace();
        }
        return flag;
    }
    
}
