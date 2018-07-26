/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kps.ata.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author kps
 */
public class DBUtil {
    
    static{
		try {
                	Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
                        e.printStackTrace();
                }
	}
    
    public static Connection getConnection() {
		Connection conn = null;
		try {
			conn=DriverManager.getConnection("jdbc:mariadb://localhost:3306/ata", "kps", "1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
    
}
