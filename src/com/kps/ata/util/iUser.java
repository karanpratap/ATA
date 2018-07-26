/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kps.ata.util;

import com.kps.ata.bean.CredentialsBean;
import com.kps.ata.bean.ProfileBean;

/**
 *
 * @author kps
 */
public interface iUser {
    
    String login(CredentialsBean credentialsBean);
    boolean logout(String userId);
    String changePassword(CredentialsBean credentialsBean, String newPassword);
    String register(ProfileBean profileBean);
    
}
