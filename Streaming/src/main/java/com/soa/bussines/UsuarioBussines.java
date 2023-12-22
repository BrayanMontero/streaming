/**
 * 
 */
package com.soa.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.soa.doa.UsuarioDao;
import com.soa.dto.Respuesta;
import com.soa.dto.Usuario;
import com.soa.dto.stream;


/**
 * Clase para concatenación de datos personales.
 */
@Component
public class UsuarioBussines {
    /** Objeto de acceso a datos. */
    @Autowired
    private UsuarioDao usuariosDao;

    /**
     * Forma el nombre completo de una persona.
     * @param persona Persona recibida.
     * @return Respuesta con el nombre completo.
     */
//    public Respuesta add(Pelicula usuario) {
//        Respuesta respuesta = new Respuesta();
//        try {
//            usuariosDao.insertar(usuario);
//            respuesta.setMessage("OK");
//        } catch (Exception e) {
//            e.printStackTrace();
//            respuesta.setMessage("Error en BD al insertar");
//        }
//        return respuesta;
//    }

    /**
     * Consulta usuarios por login.
     * @param usuario
     * @return
     */
    public Respuesta qryUsuario(stream Stream) {
        Respuesta respuesta = new Respuesta();
        try {
            List<Usuario> list = usuariosDao.queryUsuario(Stream);
            Usuario usuario = list.get(0);
            if(Stream.getCobro()<=usuario.getSaldo()){
                Stream.setValidarCobro(true);
            }else {
                Stream.setValidarCobro(false);
                respuesta.setMessage("Saldo insuficiente");
                System.err.println("Saldo insuficiente");
            }
            respuesta.setMessage("Usuario encontrado");
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setMessage("Error al buscar usuario");
        }
        return respuesta;
    }
   
}
