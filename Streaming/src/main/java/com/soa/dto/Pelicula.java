package com.soa.dto;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

/**
 * Clase que modela la informacion de un usuario.
 * {
    "pelicula": "avatar",
    }
 */
@Component
public class Pelicula {
//    /** Id del usuario. */
//    private Integer peliculaID;

    private String titulo;

    private Integer duracion;
    

    @Override
    public String toString() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

//    /**
//     * @return the peliculaID
//     */
//    public Integer getPeliculaID() {
//        return peliculaID;
//    }
//
//    /**
//     * @param peliculaID the peliculaID to set
//     */
//    public void setPeliculaID(Integer peliculaID) {
//        this.peliculaID = peliculaID;
//    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the duracion
     */
    public Integer getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

  
    
}
