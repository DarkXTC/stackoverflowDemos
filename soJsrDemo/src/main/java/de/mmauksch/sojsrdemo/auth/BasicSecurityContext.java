/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mmauksch.sojsrdemo.auth;

import java.security.Principal;
import javax.ws.rs.core.SecurityContext;

/**
 *
 * @author mmauksch
 */
public class BasicSecurityContext implements SecurityContext {

    private final User user;
    private final boolean secure;

    public BasicSecurityContext(User user, boolean secure) {
        this.user = user;
        this.secure = secure;
    }
    
    @Override
    public Principal getUserPrincipal() {
        return () -> user.getUsername();
    }

    @Override
    public boolean isUserInRole(String string) {
        return user.hasRole(string);
    }

    @Override
    public boolean isSecure() {
        return secure;
    }

    @Override
    public String getAuthenticationScheme() {
        return SecurityContext.BASIC_AUTH;
    }
    
}
