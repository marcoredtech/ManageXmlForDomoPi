package com.pandorasystem.gpiodevice;

import com.pandorasystem.gpiodevice.device.DispositivoGpio;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC-Fisso on 01/11/2018.
 */
public class Controller {
    private List<DispositivoGpio> listaGPIO = new ArrayList<DispositivoGpio>();
    private String configFileString;
    private File configFileXml;


    public Controller() throws JDOMException, IOException {

        // Check File ------------------------------------------------------------------------------------------##
        try {

            this.configFileString = new File(".").getCanonicalFile() + "\\GPIO_config.xml";
            this.configFileXml = new File(configFileString);
            if(!configFileXml.exists()){
                NewFileXml();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        // ---------------------------------------------------------------------------------------------------- ##



        // Load objects ----------------------------------------------------------------------------------------##

        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(configFileXml);
        Element rootNode = document.getRootElement();
        List gpioList = rootNode.getChildren("gpio");

        for(int i = 0; i < gpioList.size(); i++) {

            Element node = (Element) gpioList.get(i);

            DispositivoGpio dg = new DispositivoGpio(
                Integer.valueOf( node.getAttribute("Id").getValue() ),
                node.getChildText("verso"),
                Integer.valueOf( node.getChildText("numero")  ),
                configFileXml
            );


            System.out.println("gpio caricate :" + node.getChildText("verso"));

            listaGPIO.add(dg);

        }


    }

    public void EseguiComandi(Comando comando){
        try {
            comando.execute();
        } catch(JDOMException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


    public void NewFileXml(){
        try {

            Element gpioElement = new Element("GPIO");
            Document doc = new Document(gpioElement);
            doc.setRootElement(gpioElement);

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
