/**
 * 
 */
package com.soa.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soa.doa.PeliculaDao;
import com.soa.dto.Respuesta;
import com.soa.dto.Usuario;
import com.soa.dto.stream;
import com.soa.dto.Pelicula;

/**
 * Clase para concatenación de datos personales.
 */
@Component
public class PeliculaBussines {
    /** Objeto de acceso a datos. */
    @Autowired
    private PeliculaDao peliculaDao;

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
    public Respuesta qry(stream Stream) {
        Respuesta respuesta = new Respuesta();
        try {
            List<Pelicula> list = peliculaDao.query(Stream);
           Pelicula pelicula = list.get(0);
            if(Stream.getTiempo() <= pelicula.getDuracion()) {
                Stream.setCobro(Stream.getTiempo()*10);
            }else {
                respuesta.setMessage("No puedes comprar mas tiempo que de la duracion de la pelicula");
                System.err.println("No puedes comprar mas tiempo que de la duracion de la pelicula");
            }
            respuesta.setMessage("Pelicula encontrada");
            respuesta.setPeliculas(list);
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setMessage("Error no se encuentra pelicula");
        }
        return respuesta;
    }
   
}
