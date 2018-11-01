package com.pandorasystem.gpiodevice.deprecated;

import org.jdom.Element;
import java.util.List;

/**
 * Created by Marco on 01/11/2018.
 */
public class Deleter {

    public Deleter(){

    }

    public boolean Element(String node,List lista){

            try {
                for(int i = 0; i < lista.size(); i++)
                {
                    Element nodeE = (Element) lista.get(i);
                    System.out.println("Sto per cancellare :" + nodeE.getChildText(node));
                    nodeE.removeChild(node);
                }

            } catch(Exception e) {  e.printStackTrace(); return false; }

        return true;
    }
}
