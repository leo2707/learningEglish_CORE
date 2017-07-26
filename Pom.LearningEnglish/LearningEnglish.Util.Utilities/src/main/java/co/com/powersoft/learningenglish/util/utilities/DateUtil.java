/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.util.utilities;

import java.util.Calendar;
import java.util.Date;

/**
 * Clase que contiene las utilidades para fechas
 * @author Leonardo Solano
 * @since 2017-04-16
 */
public class DateUtil {
    
    /**
     * Suma minutos a una fecha
     * 
     * @author Leonardo Solano     *
     * @param fecha (Date) fecha a la que se le sumaran los minutos
     * @param minutos (int) minutos a sumar
     * @return Date
     */
    public static Date sumarMinutosFecha(Date fecha, int minutos) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.MINUTE, minutos);
        return calendar.getTime();
    }
    
}
