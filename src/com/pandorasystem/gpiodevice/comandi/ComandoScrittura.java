package com.pandorasystem.gpiodevice.comandi;

import com.pandorasystem.gpiodevice.Comando;
import com.pandorasystem.gpiodevice.device.DispositivoGpio;
import org.jdom.JDOMException;

import java.io.File;
import java.io.IOException;

/**
 * Created by PC-Fisso on 01/11/2018.
 */
public class ComandoScrittura implements Comando {

    private DispositivoGpio dispositivoGpio;


    public ComandoScrittura(DispositivoGpio dispositivoGpio) {
        this.dispositivoGpio = dispositivoGpio;

    }

    @Override
    public void execute() {
        try {
            this.dispositivoGpio.AddToConfiguration();
        } catch(JDOMException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
