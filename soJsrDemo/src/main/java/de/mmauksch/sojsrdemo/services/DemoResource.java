/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mmauksch.sojsrdemo.services;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author mmauksch
 */
@Path("demo")
public class DemoResource {
    
    @GET
    @RolesAllowed("user")
    @Path("/auth")
    public Response auth() {
        return Response.ok("doing authorized stuff").build();
    }
    
    @GET
    public Response demo() {
        return Response.ok("doing important stuff").build();
    }
}
