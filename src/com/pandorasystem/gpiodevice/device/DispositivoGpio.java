package com.pandorasystem.gpiodevice.device;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by PC-Fisso on 01/11/2018.
 */
public class DispositivoGpio {
    private int id;
    private int numero;
    private String versoPin;
    private File file;


    public DispositivoGpio(int id, String versoPin,int numero,File file) {
        this.id = id;
        this.versoPin = versoPin;
        this.numero = numero;
        this.file = file;
    }


    public int getNumero() {
        return numero;
    }

    public int getId() {
        return id;
    }

    public String getVersoPin() {
        return versoPin;
    }

    public File getFile() {
        return file;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setVersoPin(String versoPin) {
        this.versoPin = versoPin;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void AddToConfiguration() throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(getFile());
        Element rootNode = document.getRootElement();

        Element elemento = new Element("gpioPin");
        elemento.setAttribute(new Attribute("id",String.valueOf(getId())));
        elemento.addContent(new Element("verso").setText(getVersoPin()));
        elemento.addContent(new Element("numero").setText(String.valueOf(getNumero())));

        document.getRootElement().addContent(elemento);

        // new XMLOutputter().output(doc, System.out);
        XMLOutputter xmlOutput = new XMLOutputter();

        // display nice nice
        xmlOutput.setFormat(Format.getPrettyFormat());
        String path = new File(".").getCanonicalPath();
        xmlOutput.output(document, new FileWriter(path + "\\GPIO_config.xml"));

        System.out.println("File Saved!");
    }

    public void RemoveToConfiguration() throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(getFile());
        Element rootNode = document.getRootElement();
        List<Element> elements =  rootNode.getChildren("gpioPin");

        for(int i = 0; i < elements.size(); i++) {

            Element node =  elements.get(i);


            //System.out.println("Uscita :" + node.getChildText("OutName"));

            try {
                System.out.println("Attributo: " + elements.get(i).getAttribute("id").getValue());
                System.out.println("Match: " + String.valueOf(getId()));
                //System.out.println(new Attribute("id",String.valueOf(getId())));

                if(node.getAttribute("id").getValue().equals(String.valueOf(getId())) ){

                    //node.removeChild("numero");
                    //node.removeChild("verso");
                    //node.removeAttribute("id");
                    //rootNode.removeChildren("gpioPin");
                    node.detach();




                }
            } catch(Exception e) {
                e.printStackTrace();
            }


        }


        // new XMLOutputter().output(doc, System.out);
        XMLOutputter xmlOutput = new XMLOutputter();

        // display nice nice
        xmlOutput.setFormat(Format.getPrettyFormat());
        String path = new File(".").getCanonicalPath();
        xmlOutput.output(document, new FileWriter(path + "\\GPIO_config.xml"));

        System.out.println("File Saved!");
    }

    public void ModifyConfiguration() throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(getFile());
        Element rootNode = document.getRootElement();
        List<Element> elements =  rootNode.getChildren("gpioPin");

        for(int i = 0; i < elements.size(); i++) {

            Element node =  elements.get(i);


            //System.out.println("Uscita :" + node.getChildText("OutName"));

            try {
                System.out.println("Attributo: " + elements.get(i).getAttribute("id").getValue());
                System.out.println("Match: " + String.valueOf(getId()));
                //System.out.println(new Attribute("id",String.valueOf(getId())));

                if(node.getAttribute("id").getValue().equals(String.valueOf(getId())) ){

                    node.getChild("numero").setText(String.valueOf(getNumero()));
                    node.getChild("verso").setText(getVersoPin());

                }
            } catch(Exception e) {
                e.printStackTrace();
            }


        }


        // new XMLOutputter().output(doc, System.out);
        XMLOutputter xmlOutput = new XMLOutputter();

        // display nice nice
        xmlOutput.setFormat(Format.getPrettyFormat());
        String path = new File(".").getCanonicalPath();
        xmlOutput.output(document, new FileWriter(path + "\\GPIO_config.xml"));

        System.out.println("File Saved!");
    }


}
