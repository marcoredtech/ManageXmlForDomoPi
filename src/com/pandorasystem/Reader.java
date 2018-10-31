package com.pandorasystem;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;


public class Reader {
    String path;

    public Reader(String path){
        this.path = path;
    }

    public List ReaderOut() {

        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(path);

        try {

            Document document = builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List outList = rootNode.getChildren("Uscite");


            for(int i = 0; i < outList.size(); i++) {

                Element node = (Element) outList.get(i);

                System.out.println("Uscita :" + node.getChildText("OutName"));

            }

            return outList;


        } catch(IOException io) {
            System.out.println(io.getMessage());
            return null;
        } catch(JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
            return null;
        }
    }

    public List ReaderIn() {

        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(path);

        try {

            Document document = builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List outList = rootNode.getChildren("Ingressi");


            for(int i = 0; i < outList.size(); i++) {

                Element node = (Element) outList.get(i);

                System.out.println("Ingresso :" + node.getChildText("InName"));

            }

            return outList;


        } catch(IOException io) {
            System.out.println(io.getMessage());
            return null;
        } catch(JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
            return null;
        }
    }




}
