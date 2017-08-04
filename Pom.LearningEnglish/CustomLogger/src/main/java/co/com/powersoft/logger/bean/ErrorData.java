/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.logger.bean;

/**
 * Clase que contiene la información de un error generado
 *
 * @author Leonardo Solano
 * @since 2016-02-19
 */
public class ErrorData {
    
    private String operacionId;
    private String operacion;
    private String requestId;
    private String infoAdicional;
    private String ipAddress;
    private String exception;

    public ErrorData() {
    }

    public String getOperacionId() {
        return operacionId;
    }

    public void setOperacionId(String operacionId) {
        this.operacionId = operacionId;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
    
}
