/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freak.inc.helloservice;

import com.freak.inc.helloservice.iHello;

/**
 *
 * 
 * @author vladb
 */
public class HelloOSGi implements iHello {
    @Override
    public void hello() {
      System.out.println("Hello OSGi World");
    }
    
}
