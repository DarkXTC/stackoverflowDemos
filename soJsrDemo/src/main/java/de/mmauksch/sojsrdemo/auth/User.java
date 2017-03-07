/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mmauksch.sojsrdemo.auth;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author mmauksch
 */
public class User {
    private final String username;
    private final String password;
    private final List<String> roles;

    public User(String username, String password, List<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User(String username, String password) {
        this(username, password, Collections.emptyList());
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public boolean hasRole(String role) {
        return roles.contains(role);
    }
    
    public static User emptyUser() {
        return new User("", "");
    }
}
