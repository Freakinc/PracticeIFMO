/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freak.inc.practicehello;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.apache.felix.service.command.Descriptor;
import org.osgi.framework.*;
/**
 *Класс hello включающий в себя метод реализации команды и конструктор
 * 
 * @author vladb
 */
public class PracticeHello implements iPracticeHello{
    BundleContext bundleContext;
    public PracticeHello(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }

    public void hello(String param) {
        System.out.println("Hello, " + param);
    }

}
