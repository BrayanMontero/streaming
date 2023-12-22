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
public class Usuario {

    private String nombre;
    private String noTarjeta;
    private Integer saldo;
    
    @Override
    public String toString() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
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
     * @return the saldo
     */
    public Integer getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }
}
