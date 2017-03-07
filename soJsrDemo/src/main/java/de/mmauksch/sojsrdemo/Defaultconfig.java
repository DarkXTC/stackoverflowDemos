/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mmauksch.sojsrdemo;

import de.mmauksch.sojsrdemo.auth.Authenticator;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author mmauksch
 */
public class Defaultconfig extends ResourceConfig {

    public Defaultconfig() {
        packages("de.mmauksch.sojsrdemo.services");
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(Authenticator.class).to(Authenticator.class);
            }
        });
        //configure hk2 defaultbindings and other things
    }
}
