/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.util.exceptionmanager.util;

/**
 * Clase que permite configurar las utilidades de las Exceptions
 * @author Leonardo
 * @since 2016-02-19
 */
public class ExceptionUtil {

    private static ExceptionUtil instance;

    private ExceptionUtil() {
    }

    /**
     * Devuelve la instancia de la clase
     *
     * @author Leonardo Solano
     * @since 2016-02-19
     * @return instancia de la clase
     */
    public static ExceptionUtil getInstance() {
        if (instance == null) {
            instance = new ExceptionUtil();
        }
        return instance;
    }

    /**
     * Método que permite construir un objeto de Exception
     *
     * @autor Leonardo Solano
     * @since 2016-02-19
     * @param operacion (String) nombre de la operacion
     * @param infoAdicional (String) informacion adicional
     * @return excepcion en en forma de String
     */
    public String getExceptionData(String operacion, String infoAdicional) {
        
        StringBuilder msj = new StringBuilder();
        msj.append("\n");        
        msj.append("Operacion: ").append(operacion).append("\n");
        msj.append("Info Adicional: ").append(infoAdicional).append("\n");

        return msj.toString();
    }

    /**
     * Método que permite construir un objeto de Exception
     *
     * @autor Leonardo Solano
     * @since 2016-02-19
     * @param operacion (String) nombre de la operacion
     * @param nextException (String) otras exceptiones
     * @param infoAdicional (String) informacion adicional
     * @return excepcion en en forma de String
     */
    public String getExceptionData(String operacion, String nextException, String infoAdicional) {
        
        StringBuilder msj = new StringBuilder();
        msj.append("\n");        
        msj.append("Operacion: ").append(operacion).append("\n");
        msj.append("NextException: ").append(nextException).append("\n");
        msj.append("Info Adicional: ").append(infoAdicional).append("\n");

        return msj.toString();
    }
}
