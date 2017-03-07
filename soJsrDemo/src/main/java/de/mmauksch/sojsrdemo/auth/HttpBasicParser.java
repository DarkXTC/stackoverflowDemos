/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.mmauksch.sojsrdemo.auth;

import java.nio.charset.Charset;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author mmauksch
 */
public class HttpBasicParser {

    public User parse(String authentication) {
        if(authentication == null || authentication.isEmpty())
            throw new IllegalArgumentException();
        authentication = authentication.substring("Basic ".length());
        String[] values = new String(DatatypeConverter.parseBase64Binary(authentication), Charset.forName("ASCII")).split(":");
        if(values.length != 2 || values[0] == null || values[1] == null)
            throw new IllegalArgumentException();
        return new User(values[0], values[1]);
    }
}
