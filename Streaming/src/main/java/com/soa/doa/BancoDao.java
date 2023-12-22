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

import com.soa.dto.Usuario;
import com.soa.dto.stream;

/**
 * Capa de acceso a datos.
 */
@Repository
public class BancoDao {


    /**
     * Objeto especializado en acceso a la BD.
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    

    public void update(stream Stream) {
        jdbcTemplate.execute("update banco set saldo = saldo - "+ Stream.getCobro() + " where noTarjeta = '" + Stream.getNoTarjeta() + "'");
    }
}
