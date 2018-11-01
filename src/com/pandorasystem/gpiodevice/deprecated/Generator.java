package com.pandorasystem.gpiodevice.deprecated;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Marco on 31/10/2018.
 */
public class Generator {


    public Generator() {
        NuovoXmlFile();
    }


    private void NuovoXmlFile(){
        try {


            Element company = new Element("GPIO");
            Document doc = new Document(company);
            doc.setRootElement(company);

            Element gpioOut = new Element("Uscite");
            //gpioOut.setAttribute(new Attribute("id", "1"));
            gpioOut.addContent(new Element("OutName").setText("Uscita_0"));


            doc.getRootElement().addContent(gpioOut);

            Element gpioIn = new Element("Ingressi");
            //gpioIn.setAttribute(new Attribute("id", "2"));
            gpioIn.addContent(new Element("InName").setText("Ingresso_1"));


            doc.getRootElement().addContent(gpioIn);

            Element gpioOut2 = new Element("Uscite");
            //gpioOut2.setAttribute(new Attribute("id", "3"));
            gpioOut2.addContent(new Element("OutName").setText("Uscita_2"));


            doc.getRootElement().addContent(gpioOut2);

            // new XMLOutputter().output(doc, System.out);
            XMLOutputter xmlOutput = new XMLOutputter();

            // display nice nice
            xmlOutput.setFormat(Format.getPrettyFormat());
            String path = new File(".").getCanonicalPath();
            xmlOutput.output(doc, new FileWriter(path + "\\GPIO_config.xml"));

            System.out.println("File Saved!");
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }
}
