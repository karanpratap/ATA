/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kps.ata.bean;

public class CredentialsBean {
    
    private String userID, password, userType;
    private int loginStatus;

    public CredentialsBean(String userID, String password, String userType) {
        this.userID = userID;
        this.password = password;
        this.userType = userType;
        loginStatus=0;
    }

    /**
     *
     * @param loginStatus
     */
    public void setLoginStatus(int loginStatus){
        this.loginStatus=loginStatus;
    }
    
    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    public int getLoginStatus() {
        return loginStatus;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    
    
}
