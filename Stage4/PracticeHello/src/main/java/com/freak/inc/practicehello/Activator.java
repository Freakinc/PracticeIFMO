package com.freak.inc.practicehello;

import java.util.Hashtable;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration registration;
    public void start(BundleContext context) throws Exception {
        //установка параметров сервиса для создания команды
        Hashtable props = new Hashtable();
        props.put("osgi.command.scope", "practice");
        props.put("osgi.command.function", new String[] {
            "hello" });
        //регистрация сервиса
        registration=context.registerService(PracticeHello.class.getName(), new PracticeHello(context), props);
    }

    public void stop(BundleContext context) throws Exception {
       
    }

}
