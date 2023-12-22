/**
 * 
 */
package com.soa.doa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.soa.dto.Pelicula;
import com.soa.dto.Usuario;
import com.soa.dto.stream;

/**
 * Capa de acceso a datos.
 */
@Repository
public class PeliculaDao {


    /**
     * Objeto especializado en acceso a la BD.
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    

    /**
     * Consulta de usuarios basados en el login.
     * @param usuario Objeto que contiene el login a consultar.
     */
    public List<Pelicula> query(stream Stream) {
        List<Pelicula> resp = jdbcTemplate.query(
                "select titulo, duracion "
                + "from catalogo where titulo = '"
                + Stream.getTitulo()+"'", 
                new BeanPropertyRowMapper<Pelicula>(Pelicula.class));
        return resp;
    }
}
