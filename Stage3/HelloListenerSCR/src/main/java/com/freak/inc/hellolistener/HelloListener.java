/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freak.inc.hellolistener;

import com.freak.inc.helloprovider.iHello;
import com.freak.inc.helloprovider.HelloService;
/**
 *
 * @author vladb
 */
public class HelloListener {
    private iHello service;
    public void hello(){
        service.hello();
    }    
    
    public synchronized void setHello(iHello service) {
        System.out.println("Service has been set");
        this.service = service;
        service.hello();
    }
       
    public synchronized void unsetHello(iHello service) {
        System.out.println("Service has been unset");
        if (this.service == service) {
            this.service = null;
        }
    }
    
}
