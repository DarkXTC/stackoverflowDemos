/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mmauksch.sojsrdemo.auth;

import java.io.IOException;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * references:
 * https://github.com/jersey/jersey/blob/master/examples/https-clientserver-grizzly/src/main/java/org/glassfish/jersey/examples/httpsclientservergrizzly/SecurityFilter.java
 * http://stackoverflow.com/questions/42373642/how-to-authenticate-users-in-jersey
 *
 * @author mmauksch
 */
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {
    private static final Logger log = LogManager.getLogger();

    private final Authenticator authenticator;

    @Inject
    public AuthenticationFilter(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    @Override
    public void filter(ContainerRequestContext context) throws IOException {
        User user = authenticator.authenticate(context.getHeaderString(HttpHeaders.AUTHORIZATION));
        context.setSecurityContext(new BasicSecurityContext(user, context.getSecurityContext().isSecure()));
    }

}
