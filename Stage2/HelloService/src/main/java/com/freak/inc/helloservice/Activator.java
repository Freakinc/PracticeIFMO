package com.freak.inc.helloservice;

import java.util.Properties;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import com.freak.inc.helloservice.iHello;
import com.freak.inc.helloservice.HelloOSGi;

public class Activator implements BundleActivator {
    private ServiceRegistration registration;    
    public void start(BundleContext bundleContext) throws Exception {
        registration = bundleContext.registerService(
            iHello.class.getName(),
            new HelloOSGi(),
            null);
        System.out.println("Hello is registered!");
    }

    public void stop(BundleContext context) throws Exception {
        registration.unregister();
    }

}

