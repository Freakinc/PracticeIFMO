package com.freak.inc.helloserviceconsumer;

import com.freak.inc.helloservice.iHello;
import com.freak.inc.helloservice.HelloOSGi;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
public class Activator implements BundleActivator {
    private BundleContext context;
    private iHello service;
    public void start(BundleContext context) throws Exception {
        this.context = context;
        ServiceReference reference = context.getServiceReference(iHello.class.getName());
        service = (iHello) context.getService(reference);
        service.hello();
    }

    public void stop(BundleContext context) throws Exception {
        service.hello();
    }

}
