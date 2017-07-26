/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.util.bean.util;


import co.com.powersoft.learningenglish.util.bean.generic.Status;
import com.google.gson.JsonObject;

/**
 *
 * @author Leonardo
 */
public class StatusUtil {

    public static final String SUCCESS = "SUCCESS";
    public static final String ERROR = "ERROR";
    public static final String INVALID_REQUEST = "INVALID_REQUEST";
    public static final String DUPLICATE = "DUPLICATE";
    public static final String MSJ_ERROR_GENERAL = "Ocurrió un error al realizar la acción, por favor inténtelo nuevamente";

    /**
     * Metodo que genera un estado de error estandar
     *
     * @autor Leonardo Solano
     * @since 2016-06-27
     * @return Status estado de ERROR
     */
    public static Status getStatusError() {
        Status status = new Status();
        status.setCode(ERROR);
        status.setMesage(MSJ_ERROR_GENERAL);
        return status;
    }
    
    /**
     * Metodo que genera un estado de error
     * cuando el request es invalido
     *
     * @autor Leonardo Solano
     * @since 2016-06-27
     * @return Status estado de ERROR
     */
    public static Status getStatusErrorInvalidRequest() {
        Status status = new Status();
        status.setCode(ERROR);
        status.setMesage(INVALID_REQUEST);
        return status;
    }

    /**
     * Metodo que genera un estado de error estandar
     *
     * @autor Leonardo Solano
     * @since 2016-06-27
     * @param exception (Exception) con la cual se genera el error
     * @return Status estado de ERROR
     */
    public static Status getStatusError(Exception exception) {
        Status status = new Status();
        status.setCode(ERROR);
        status.setDescription(exception.getMessage());
        return status;
    }

    /**
     * Metodo que genera un estado de error estandar
     *
     * @autor Leonardo Solano
     * @since 2016-06-27
     * @param mensaje (String) Mensaje de error
     * @return Status estado de ERROR
     */
    public static Status getStatusError(String mensaje) {
        Status status = new Status();
        status.setCode(ERROR);
        status.setMesage(mensaje);
        return status;
    }

    /**
     * Metodo que genera un estado de error estandar
     *
     * @autor Leonardo Solano
     * @since 2016-06-27
     * @param exception (Exception) con la cual se genera el error
     * @param mensaje (String) Mensaje de error
     * @return Status estado de ERROR
     */
    public static Status getStatusError(Exception exception, String mensaje) {
        Status status = new Status();
        status.setCode(ERROR);
        status.setMesage(mensaje);
        status.setDescription(exception.getMessage());
        return status;
    }

    /**
     * Metodo que genera un estado de Success estandar
     *
     * @autor Leonardo Solano
     * @since 2016-06-27
     * @return Status estado de SUCCESS
     */
    public static Status getStatusSuccess() {
        Status status = new Status();
        status.setCode(SUCCESS);
        return status;
    }

    /**
     * Metodo que genera un estado de Success estandar
     *
     * @autor Leonardo Solano
     * @since 2016-06-27
     * @param mensaje (String) Mensaje de error
     * @return Status estado de SUCCESS
     */
    public static Status getStatusSuccess(String mensaje) {
        Status status = new Status();
        status.setCode(SUCCESS);
        status.setMesage(mensaje);
        return status;
    }

    /**
     * Metodo que genera un estado de Success para AGREGAR
     *
     * @autor Leonardo Solano
     * @since 2016-06-28
     * @param jsonObject (JsonObject) objeto JSON de mensajes
     * @return Status estado de SUCCESS
     */
    public static Status getStatusSuccessAgregar(JsonObject jsonObject) {
        Status status = new Status();
        try {
            String mensaje = jsonObject.get("SUCCESS_AGREGAR").getAsString();
            status.setCode(SUCCESS);
            status.setMesage(mensaje);
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return status;
    }

    /**
     * Metodo que genera un estado de Success para MODIFICAR
     *
     * @autor Leonardo Solano
     * @since 2016-06-28
     * @param jsonObject (JsonObject) objeto JSON de mensajes
     * @return Status estado de SUCCESS
     */
    public static Status getStatusSuccessModificar(JsonObject jsonObject) {
        Status status = new Status();
        status.setCode(SUCCESS);
        status.setMesage(jsonObject.get("SUCCESS_MODIFICAR").getAsString());
        return status;
    }

    /**
     * Metodo que genera un estado de Success para ELIMINAR
     *
     * @autor Leonardo Solano
     * @since 2016-06-28
     * @param jsonObject (JsonObject) objeto JSON de mensajes
     * @return Status estado de SUCCESS
     */
    public static Status getStatusSuccessEliminar(JsonObject jsonObject) {
        Status status = new Status();
        status.setCode(SUCCESS);
        status.setMesage(jsonObject.get("SUCCESS_ELIMINAR").getAsString());
        return status;
    }

}
