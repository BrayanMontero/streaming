package com.soa.dto;

import java.util.List;

import com.google.gson.Gson;

/**
 * Clase que modela la informacion resumida de una persona.
 */
public class Respuesta {

    /** Mensaje de respuesta. */
    private String message;
    /** Lista usuario. */
    private List<Pelicula> peliculas;
    private List<Usuario> usuarios;
   


    @Override
    public String toString() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the peliculas
     */
    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    /**
     * @param peliculas the peliculas to set
     */
    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    /**
     * @return the usuarios
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


    
}
