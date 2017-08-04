/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.util.utilities;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * Clase que implementa metodos utilitarios generales
 * @author lsolano
 */
public class Utilities {
    
    /**
     * Método que permite capturar la IP
     *
     * @author leonardo.solano
     * @since 2015-09-07
     * @return String IP
     */
    public static String getLocalIpAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return "";
        }
    }
    
    /**
     * Método que genera un identificador unico 
     * para una solicitud
     *
     * @author leonardo.solano
     * @since 2016-08-27
     * @return String identificador unico
     */
    public static String generateRequestID() {
        int numrandom = (int) Math.floor(Math.random()*100);
        return String.valueOf(new Date().getTime()) + numrandom;
    }
    
}
