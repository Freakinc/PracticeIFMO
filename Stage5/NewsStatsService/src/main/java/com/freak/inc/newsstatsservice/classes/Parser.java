/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freak.inc.newsstatsservice.classes;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.osgi.framework.BundleContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author vladb
 */
public class Parser {
    static final String[] Preps= new String[]{"в", "на", "о", "с", "за", "и", "по",
    "об", "из-за", "для", "к", "из", "у" , "от", "со", "под", "без", "среди",
    "при", "во", "не", "что", "-"};
    private static HashMap<String, Integer> words;
    private BundleContext bundleContext;
    public void Parse(String Param) {
        String command[] = Param.split(" ");
        String urlCommand[] = new String[command.length];
        boolean showDesc = Boolean.parseBoolean(command[command.length - 1]);
        System.arraycopy(command, 0, urlCommand, 0, command.length);
        for (int i = 0; i < urlCommand.length; i++) {
            try {
                getRSS(new URL(urlCommand[i]), showDesc);
            } catch (MalformedURLException e) {
                if (urlCommand[i].equalsIgnoreCase("true") || urlCommand[i].equalsIgnoreCase("false") ) {
                } else {
                    System.out.println("The Url " + urlCommand[i]
                        + " is Not Valid ");
                  }
               }

        }
    }

    public static void getRSS(URL url, boolean showDescription) {
        HttpURLConnection httpConnection = null;
        try {
            httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.connect();

            InputStream inputStream = httpConnection.getInputStream();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(inputStream);

            doc.getDocumentElement().normalize();
            Element root = doc.getDocumentElement();
            NodeList RSSItems = root.getElementsByTagName("item");
            words = new HashMap<>();
            for (int i = 0; i < RSSItems.getLength(); i++) {
                
                Element item = (Element) RSSItems.item(i).getChildNodes();

                try {
                    String itemTitle = item.getElementsByTagName("title")
                            .item(0).getTextContent().toLowerCase();
                    String [] res = itemTitle.split("[ ,;:.!?\\s]+");
                    for(String word : res) {
                        Integer count = words.get(word);
                        if(!Arrays.asList(Preps).contains(word)) {
                            words.put(word, count == null ? 1 : count + 1);
                    }
                }
                    }
                    catch (NullPointerException e) {
                }
            }
            httpConnection.disconnect();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
          } 
          catch (ParserConfigurationException ex) {
            System.out.println(ex.getMessage());
          } 
          catch (SAXException ex) {
           System.out.println(ex.getMessage());
          }
               
        ArrayList list = new ArrayList(words.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
        for(int i = 0; i<10; i++){
            System.out.println(list.get(i));
        }     
    }    
    public Parser(BundleContext bundleContext){
        this.bundleContext = bundleContext;
    }    
    public Parser(){};    
}
