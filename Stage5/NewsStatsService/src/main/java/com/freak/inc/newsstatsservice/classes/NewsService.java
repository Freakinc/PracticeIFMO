/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freak.inc.newsstatsservice.classes;

import java.util.Scanner;
import org.osgi.framework.BundleContext;
/**
 *Includes news:stats command realization by calling getLenta(), getAIF()
 * methods for geting data from sources
 * 
 * 
 * @author vladb
 */

public class NewsService implements iNews{
    BundleContext bundleContext;
    private Parser parser;    
    public NewsService(BundleContext bundleContext, Parser parser){
        this.bundleContext = bundleContext;
        this.parser = parser;
    }    
    @Override
    public void stats(String Param) {
        if (Param.equals("https://lenta.ru/rss")){
            new LentaService().stats();
        } else if (Param.equals("https://www.aif.ru/rss/news.php")){
            new AIFService().stats();
        } else {
            System.out.println("Wrong input!" + "\n" + "Available sources:"
                    + "\n" + "1) https://lenta.ru/rss " + "\n" + "2) https://www.aif.ru/rss/news.php" +"\n");
        }
    }
    @Override
    public void stats() {       
        Scanner in = new Scanner(System.in);
        System.out.println("Enter '1' to get results from https://lenta.ru/rss");
        System.out.println("Enter '2' to get results from https://www.aif.ru/rss/news.php");
        System.out.println("Enter '3' to get both services");
        int p=in.nextInt();
        switch(p){
        case 1: 
            new LentaService().stats();
            break;
        case 2: 
            new AIFService().stats();
            break;   
        case 3: 
            new AIFService().stats();
            new LentaService().stats();
            break;          
        }
    }
}



