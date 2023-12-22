/**
 * 
 */
package com.soa.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.soa.bussines.BancoBussines;
import com.soa.bussines.PeliculaBussines;
import com.soa.bussines.UsuarioBussines;
import com.soa.dto.Respuesta;
import com.soa.dto.stream;

/**
 * 
 */
@Component
public class CotizacionBancoListener {
    @Autowired
    private BancoBussines business;

    @Autowired
    private JmsSende sender;
    

    /** Nombre de la cola de respuesta del microservicio. */
    @Value("r.validacion.out")
    private String outQueueName;

    @JmsListener(destination = "u.validacion.out")
    public void receive(String message) {
        System.out.println(String.format("Received message: %s", message));
        Gson gson = new Gson();
        stream streamData = gson.fromJson(message, stream.class);
        
        Respuesta respuesta = business.qryBanco(streamData);
        System.out.println(respuesta);
        
        try {
            sender.sendMessage(streamData.toString(), outQueueName);
            System.out.println(String.format("Mensaje enviado: %s", 
                    streamData.toString()));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
