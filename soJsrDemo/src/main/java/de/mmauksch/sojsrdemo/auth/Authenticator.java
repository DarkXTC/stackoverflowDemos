/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mmauksch.sojsrdemo.auth;

import java.util.ArrayList;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author mmauksch
 */
public class Authenticator {
    private static final Logger log = LogManager.getLogger();
    
    public User authenticate(String header) {
        User userCredentials;
        try {
            userCredentials = new HttpBasicParser().parse(header);
        } catch (IllegalArgumentException ex) {
            log.error(ex);
            return User.emptyUser();
        }
        if("user".equals(userCredentials.getUsername())) 
            return new User(userCredentials.getUsername(), "", new ArrayList<>(Arrays.asList("user")));
        if("admin".equals(userCredentials.getUsername())) 
            return new User(userCredentials.getUsername(), "", new ArrayList<>(Arrays.asList("admin")));
        return User.emptyUser();
    }
}
