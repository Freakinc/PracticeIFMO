package com.freak.inc.helloprovider;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 *
 * @author vladb
 * 
 * 
 * @scr.component
 * @scr.service
 * 
 */
public class Activator implements BundleActivator {
    
    public void start(BundleContext context) throws Exception {
        System.out.println("Hello, service activator");
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Goodbye, service activator");
    }

}
