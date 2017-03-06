/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mmauksch.sojsrdemo;

import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

/**
 *
 * @author mmauksch
 */
public class App {
    public static void main(String[] args) {
        Defaultconfig config = new Defaultconfig();
        config.register(RolesAllowedDynamicFeature.class);
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create("http://localhost:9000"), config);
    }
}
