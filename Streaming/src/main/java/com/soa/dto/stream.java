/**
 * 
 */
package com.soa.dto;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

/**
 * 
 */
@Component
public class stream {
    private String titulo;
    private Integer tiempo;
    private String nombre;
    private String noTarjeta;
    private Integer cobro; 
    private Boolean validarCobro;
    private Boolean cobroEcho;
    
    @Override
    public String toString() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    /**
     * @return the tiempo
     */
    public Integer getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    /**
     * @return the noTarjeta
     */
    public String getNoTarjeta() {
        return noTarjeta;
    }

    /**
     * @param noTarjeta the noTarjeta to set
     */
    public void setNoTarjeta(String noTarjeta) {
        this.noTarjeta = noTarjeta;
    }

    /**
     * @return the cobro
     */
    public Integer getCobro() {
        return cobro;
    }

    /**
     * @param cobro the cobro to set
     */
    public void setCobro(Integer cobro) {
        this.cobro = cobro;
    }

    /**
     * @return the validarCobro
     */
    public Boolean getValidarCobro() {
        return validarCobro;
    }

    /**
     * @param validarCobro the validarCobro to set
     */
    public void setValidarCobro(Boolean validarCobro) {
        this.validarCobro = validarCobro;
    }

    /**
     * @return the cobroEcho
     */
    public Boolean getCobroEcho() {
        return cobroEcho;
    }

    /**
     * @param cobroEcho the cobroEcho to set
     */
    public void setCobroEcho(Boolean cobroEcho) {
        this.cobroEcho = cobroEcho;
    }

 


}
