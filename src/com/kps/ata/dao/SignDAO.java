/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kps.ata.dao;

import com.kps.ata.bean.CredentialsBean;
import com.kps.ata.bean.ProfileBean;
import com.kps.ata.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kps
 */
public class SignDAO {
    
    public boolean authenticate(String userid,String password){
        
        int rows=0;
        boolean flag=false;
        try(Connection conn = DBUtil.getConnection();){
            
            String sql="select password from ATA_TBL_USER_CREDENTIALS where userid=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, userid);
            
            rows=ps.executeUpdate();
            
           
            String test=null;
            ResultSet rs=ps.executeQuery();
            if(rs.next())
                test=rs.getString(1);
            System.out.println(test);
            try{
                if(password.equals(test))
                flag=true;
            } catch(NullPointerException e){
                flag=false;
       }
        
    }   catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
        
    public boolean createCustomer(CredentialsBean credentialsBean,ProfileBean profileBean){
        int rows=0,rows2=0;
		
		try(Connection conn = DBUtil.getConnection();){
			String userid=null;
                        String sql="select startwith from ATA_TBL_SEQUENCES where purpose='userid'";
                        PreparedStatement ps=conn.prepareStatement(sql);
                        ResultSet rs=ps.executeQuery();
                        if(rs.next())
                        userid=profileBean.getFirstName().substring(0, 2)+rs.getString(1);
			sql="Insert into ATA_TBL_USER_CREDENTIALS values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			
                       
			ps.setString(1,userid);
			ps.setString(2,credentialsBean.getPassword());
			ps.setString(3,"C");
                        ps.setInt(4, 0);
                        
                        java.sql.Date sDate=new java.sql.Date(profileBean.getDateOfBirth().getTime());
			
                        rows=ps.executeUpdate();
			
                        sql="Insert into ATA_TBL_USER_PROFILE values(?,?,?,?,?,?,?,?,?,?,?,?)";
                        ps=conn.prepareStatement(sql);
                        
                        ps.setString(1, userid);
                        ps.setString(2, profileBean.getFirstName());
                        ps.setString(3, profileBean.getLastName());
                        ps.setDate(4, sDate);
                        ps.setString(5, profileBean.getGender());
                        ps.setString(6, profileBean.getStreet());
                        ps.setString(7, profileBean.getLocation());
                        ps.setString(8, profileBean.getCity());
                        ps.setString(9, profileBean.getState());
                        ps.setString(10, profileBean.getPinCode());
                        ps.setString(11, profileBean.getMobileNo());
                        ps.setString(12, profileBean.getEmailID());
                        
                        rows2=ps.executeUpdate();
                        
                        
                        System.out.println("Customer Created successfully");
                        sql="update ATA_TBL_SEQUENCES set startwith="+Integer.toString(rs.getInt(1)+1)+" where purpose='userid'";
                        ps=conn.prepareStatement(sql);
                        rows=ps.executeUpdate();
			
		} catch (SQLException e) {
			if(e.getMessage().contains("Duplicate")) {
				System.out.println("DUPLICATE ENTRY FOR CUSTOMER");
			}
			else {
				e.printStackTrace();
			}
		}
		return (rows>0 && rows2>0);

    }
    
}
