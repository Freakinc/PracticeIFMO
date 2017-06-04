/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freak.inc.helloprovider;

import com.freak.inc.helloprovider.iHello;
/**
 *
 * @author vladb
 * 
 * 
 * @scr.component
 * @scr.service
 * 
 */

public class HelloService implements iHello {
    
    public void hello() {
        System.out.println("Hello OSGi World!");        
    }
    
}
