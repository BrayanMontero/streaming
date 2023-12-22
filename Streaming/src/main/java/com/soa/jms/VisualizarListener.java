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
import com.soa.bussines.VisualizarBussines;
import com.soa.dto.Respuesta;
import com.soa.dto.stream;

/**
 * 
 */
@Component
public class VisualizarListener {
    @Autowired
    private VisualizarBussines business;

    @Autowired
    private JmsSende sender;
    

    /** Nombre de la cola de respuesta del microservicio. */
    @Value("v.validacion.out")
    private String outQueueName;

    @JmsListener(destination = "r.validacion.out")
    public void receive(String message) {
        System.out.println(String.format("Received message: %s", message));
        Gson gson = new Gson();
        stream streamData = gson.fromJson(message, stream.class);
        Respuesta respuesta = business.visualizar(streamData);
        
        try {
            sender.sendMessage(respuesta.toString(), outQueueName);
            System.out.println(String.format("Mensaje enviado: %s", respuesta.toString()));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
