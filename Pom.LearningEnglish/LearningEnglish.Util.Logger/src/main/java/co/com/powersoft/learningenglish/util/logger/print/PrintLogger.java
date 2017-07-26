/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.util.logger.print;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



/**
 * Clase que permite imprimir los logs de una funcion
 * @author Leonardo Solano
 */
public class PrintLogger {
    
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
     * @param nombreMetodo (String) nombre del metodo
     * @param object Objeto que convertiremos en JSON
     */
    public static void printRequest(String nombreMetodo, Object object){
        System.out.println(getRequestJson(nombreMetodo, object));
    }
    
    /**
     * Metodo que permite imprimir un RESPONSE de un objeto en json
     *
     * @autor Leonardo Solano
     * @param nombreMetodo (String) nombre del metodo
     * @param object Objeto que convertiremos en JSON
     */
    public static void printResponse(String nombreMetodo, Object object){
        System.out.println(getResponseJson(nombreMetodo, object));
    }
    
    /**
     * Metodo que permite imprimir un RESPONSE de un objeto en json
     *
     * @autor Leonardo Solano
     * @param object Objeto que convertiremos en JSON
     */
    public static void printError(Object object){
        System.err.println(convertObjectToJson(object));
    }
}
