package com.freak.inc.newsstatsservice.classes;

import com.freak.inc.newsstatsservice.classes.NewsService;
import java.util.Hashtable;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration registration;
    public void start(BundleContext bundleContext) throws Exception {
        //параметры регистрации сервиса
        Hashtable props = new Hashtable();
        props.put("osgi.command.scope", "news");
        props.put("osgi.command.function", new String[] {
            "stats" });
        //регистрация сервиса
        registration = bundleContext.registerService(
                 NewsService.class.getName(),
                new NewsService(bundleContext, new Parser(bundleContext)), props);
    }
    @Override
    public void stop(BundleContext bc) throws Exception {};
     
}

    

