/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freak.inc.hellolistener;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 *
 * @author vladb
 */
public class Activator implements BundleActivator {
    
    public void start(BundleContext context) throws Exception {
        System.out.println("Hello, service activator"); 
    }
    
    public void stop(BundleContext context) throws Exception {
        System.out.println("Goodbye, service activator");
    }

}