/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.util.bean.generic;

import java.io.Serializable;

/**
 * Clase que contiene la informacion del estado
 * de la respuesta
 *
 * @author Leonardo Solano
 */
public class Status implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String code;
    private String mesage;
    private String description;

    public Status() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
        
}
