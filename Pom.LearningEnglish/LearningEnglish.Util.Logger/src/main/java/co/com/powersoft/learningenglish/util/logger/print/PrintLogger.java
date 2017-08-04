/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.util.logger.print;

import co.com.powersoft.learningenglish.util.logger.bean.ErrorData;
import co.com.powersoft.logger.CustomLogger;
//import co.com.powersoft.logger.config.CustomLogger;
//import co.com.powersoft.learningenglish.util.logger.config.CustomLogger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



/**
 * Clase que permite imprimir los logs de una funcion
 * @author Leonardo Solano
 */
public class PrintLogger {
    
//    private CustomLogger logger = new CustomLogger(this.getClass());
    private static PrintLogger instance;
    
    public PrintLogger() {
    }
    
    /**
     * Devuelve la instancia de la clase
     *
     * @author Leonardo Solano
     * @return instancia de la clase
     */
    public static PrintLogger getInstance() {
        if (null == instance) {
            instance = new PrintLogger();
        }
        return instance;
    }
    
    /**
     * Metodo que permite convertir un objeto a json
     * 
     * @autor Leonardo Solano
     * @param object Objeto que convertiremos en JSON
     * @return String JSON
     */
    public static String convertObjectToJson(Object object) {
        
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();        
//            return gson.toJson(object).replace("\\n", "\n").replace("\\r", "\r");
            return gson.toJson(object).replace("\\r", "\r");
        } catch (Exception e) {
            return "";
        }
    }
    
    /**
     * Metodo que permite obtener el REQUEST de un objeto en json
     * 
     * @autor Leonardo Solano
     * @param nombreMetodo (String) nombre del metodo
     * @param object Objeto que convertiremos en JSON
     * @return String JSON
     */
    public static String getRequestJson(String nombreMetodo, Object object) {
        try {
            return "[REQUEST: "+nombreMetodo+"] "
                    + "[Data: " + convertObjectToJson(object) + "]";
        } catch (Exception e) {
            return "[REQUEST: "+nombreMetodo+"] "
                    + "[Data -> ERROR PRINT: " + e +"]";
        }
    }
    
    /**
     * Metodo que permite obtener el RESPONSE de un objeto en json
     * 
     * @autor Leonardo Solano
     * @param nombreMetodo (String) nombre del metodo
     * @param object Objeto que convertiremos en JSON
     * @return String JSON
     */
    public static String getResponseJson(String nombreMetodo, Object object) {
        try {
            return "[RESPONSE: "+nombreMetodo+"] "
                    + "[Data: " + convertObjectToJson(object) + "]";
        } catch (Exception e) {
            return "[RESPONSE: "+nombreMetodo+"] "
                    + "[Data -> ERROR PRINT: " + e +"]";
        }
    }
    
    /**
     * Metodo que permite imprimir un REQUEST de un objeto en json
     * 
     * @autor Leonardo Solano
     * @param logger (CustomLogger) Objeto logger
     * @param nombreMetodo (String) nombre del metodo
     * @param object Objeto que convertiremos en JSON
     */
    public void printRequest(CustomLogger logger, String nombreMetodo, Object object){
        System.out.println("SYSOUT LEO: "+getRequestJson(nombreMetodo, object));
        logger.info("LOG LEO: "+getRequestJson(nombreMetodo, object));
    }
    
    /**
     * Metodo que permite imprimir un RESPONSE de un objeto en json
     *
     * @autor Leonardo Solano
     * @param logger (CustomLogger) Objeto logger
     * @param nombreMetodo (String) nombre del metodo
     * @param object Objeto que convertiremos en JSON
     */
    public void printResponse(CustomLogger logger, String nombreMetodo, Object object){
        System.out.println("SYSOUT LEO: "+getResponseJson(nombreMetodo, object));
        logger.info("LOG LEO: "+getResponseJson(nombreMetodo, object));
    }
    
    /**
     * Metodo que permite imprimir un RESPONSE de un objeto en json
     *
     * @autor Leonardo Solano
     * @param logger (CustomLogger) Objeto logger
     * @param object Objeto que convertiremos en JSON
     */
    public void printError(CustomLogger logger, Object object){
        System.err.println("SYSOUT LEO: "+convertObjectToJson(object));
        logger.error(convertObjectToJson(object));
    }
    
    /**
     * Metodo que permite imprimir un RESPONSE de un objeto en json
     *
     * @autor Leonardo Solano
     * @param errorData (ErrorData) que convertiremos en JSON
     * @param exception (Exception) exception del Error
     */
    public void printError(ErrorData errorData, Exception exception){
        System.err.println(convertObjectToJson(errorData));
//        logger.error(errorData, exception);
    }
}
