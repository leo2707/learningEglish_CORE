/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.util.bean.generic;

import java.io.Serializable;


/**
 * Clase que contiene la informacion de salida
 *
 * @author Leonardo Solano
 * @since 2016-06-27
 */
public class GenericResponse implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Status status;
    private String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
}
