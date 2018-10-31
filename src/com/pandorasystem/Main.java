package com.pandorasystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class Main {

    public static void main(String[] args) throws IOException {

        // Check File
        String configFile = new File(".").getCanonicalFile() + "\\GPIO_config.xml";
        if(!(new File(configFile).exists())){
            Generator gen = new Generator();
        }

        // Read
        Reader lettore = new Reader(configFile);
        lettore.ReaderIn();
        lettore.ReaderOut();

        // Modify



    }


}
