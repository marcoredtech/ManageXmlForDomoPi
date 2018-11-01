package com.pandorasystem.gpiodevice.comandi;

import com.pandorasystem.gpiodevice.Comando;
import com.pandorasystem.gpiodevice.device.DispositivoGpio;
import org.jdom.JDOMException;

import java.io.IOException;

/**
 * Created by PC-Fisso on 01/11/2018.
 */
public class ComandoEliminazione implements Comando{
    private DispositivoGpio dispositivoGpio;

    public ComandoEliminazione(DispositivoGpio dispositivoGpio) {
        this.dispositivoGpio = dispositivoGpio;


    }

    @Override
    public void execute() {
        try {
            dispositivoGpio.RemoveToConfiguration();
        } catch(JDOMException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
