/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freak.inc.newsstatsservice.classes;

/**
 *Implements INews interface and gets data from Lenta RSS
 * 
 * @author vladb
 */
public class LentaService implements iNews{
    @Override
    public void stats() {
        new Parser().Parse("https://lenta.ru/rss");
    }
    @Override
    public void stats(String Param) {};

}
