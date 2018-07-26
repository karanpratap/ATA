/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kps.ata.util;

import com.kps.ata.bean.CredentialsBean;

/**
 *
 * @author kps
 */
public interface iAuthentication {
    
    boolean authenticate(CredentialsBean credentialsBean);
    String authorize(String userID);
    boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus);
    
}
