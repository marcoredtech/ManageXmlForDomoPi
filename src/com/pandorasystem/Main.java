package com.pandorasystem;

import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.pandorasystem.gpiodevice.Controller;
import com.pandorasystem.gpiodevice.comandi.ComandoEliminazione;
import com.pandorasystem.gpiodevice.comandi.ComandoModifica;
import com.pandorasystem.gpiodevice.comandi.ComandoScrittura;
import com.pandorasystem.gpiodevice.device.DispositivoGpio;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class Main {

    public static void main(String[] args) throws IOException, JDOMException {

        // file di configurazione dispositivi gpio
        String configFileString = new File(".").getCanonicalFile() + "\\GPIO_config.xml";
        File configFileXml = new File(configFileString);


        // creo un nuovo dispositivo
        DispositivoGpio luceSala = new DispositivoGpio(123456789,"out",2,configFileXml);
        DispositivoGpio luceCucina = new DispositivoGpio(123456790,"out",3,configFileXml);
        DispositivoGpio luceCucina2 = new DispositivoGpio(123456790,"out",4,configFileXml);

        // Inizializzo il controllore
        Controller controller = new Controller();

        // Tento di aggiungere il nuovo device al file di configurazione.
        //controller.EseguiComandi(new ComandoScrittura(luceSala));
        //controller.EseguiComandi(new ComandoScrittura(luceCucina));

        // Tento di togliere
        //controller.EseguiComandi(new ComandoEliminazione(luceSala));


        // Modifico
        controller.EseguiComandi(new ComandoModifica(luceCucina2));



    }


}
