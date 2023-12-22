/**
 * 
 */
package com.soa.bussines;

import java.util.List;

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
public class BancoBussines {
    /** Objeto de acceso a datos. */
    @Autowired
    private BancoDao bancoDao;

    public Respuesta qryBanco(stream Stream) {
        Respuesta respuesta = new Respuesta();
        try {
            if(Stream.getValidarCobro()) {
                bancoDao.update(Stream);
                respuesta.setMessage("Pago exitoso");
                Stream.setCobroEcho(true);
            }else {
                System.err.println("Error en restar");
            }
        } catch (Exception e) {
            Stream.setCobroEcho(false);
            e.printStackTrace();
            respuesta.setMessage("Error en restar");
        }
        return respuesta;
    }
   
}
