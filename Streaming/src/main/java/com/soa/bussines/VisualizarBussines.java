/**
 * 
 */
package com.soa.bussines;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soa.doa.BancoDao;
import com.soa.doa.UsuarioDao;
import com.soa.dto.Respuesta;
import com.soa.dto.Usuario;
import com.soa.dto.stream;


/**
 * Clase para concatenación de datos personales.
 */
@Component
public class VisualizarBussines {
    /** Objeto de acceso a datos. */
    

    public Respuesta visualizar(stream Stream) {
        Respuesta respuesta = new Respuesta();
        try {
            if(Stream.getCobroEcho()) {
                
                ScheduledExecutorService sigueViendoScheduler = Executors.newScheduledThreadPool(1);
                sigueViendoScheduler.scheduleAtFixedRate(() -> {
                    System.out.println("Sigues viendo: "+Stream.getTitulo().toString());
                }, 0, 10, TimeUnit.SECONDS);
                
                ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
                scheduler.schedule(() -> {
                    System.out.println("Emisión terminada");
                    respuesta.setMessage("Emisión terminada");
                }, Stream.getTiempo(), TimeUnit.SECONDS).get();

                
                sigueViendoScheduler.shutdown();
                scheduler.shutdown();
                
            }else {
                System.err.println("Error al visualizar");
            }
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setMessage("Error al visualizar");
        }
        return respuesta;
    }
   
}
