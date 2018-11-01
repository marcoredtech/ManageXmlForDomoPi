package com.pandorasystem.gpiodevice;

import org.jdom.JDOMException;

import java.io.IOException;

/**
 * Created by PC-Fisso on 01/11/2018.
 */
public interface Comando {

    void execute() throws JDOMException, IOException;
}
