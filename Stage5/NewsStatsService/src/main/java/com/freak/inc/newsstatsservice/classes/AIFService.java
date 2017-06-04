/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freak.inc.newsstatsservice.classes;

/**
 *
 * 
 * @author vladb
 */
public class AIFService implements iNews {
    @Override
    public void stats() {
        new Parser().Parse("http://www.aif.ru/rss/news.php");
    }
    @Override
    public void stats(String param) {};
}
