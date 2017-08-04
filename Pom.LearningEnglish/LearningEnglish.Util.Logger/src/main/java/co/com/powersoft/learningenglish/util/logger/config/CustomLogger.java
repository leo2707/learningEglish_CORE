/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.util.logger.config;


import co.com.powersoft.learningenglish.util.logger.bean.ErrorData;
import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Clase encargada de proporcionar los métodos que permiten registran eventos de
 * diferentes niveles en el log de la aplicación
 *
 * @author Leonardo Solano
 * @since 2016-02-19
 * @version 1.0
 */
public class CustomLogger implements Serializable {

    private static final long serialVersionUID = 1L;
    private Logger logger;

    public CustomLogger(Class<? extends Object> claseConsumer) {
        try {
//            ConfigurationService.getInstance();
            this.logger = LogManager.getLogger((String) claseConsumer.getName());
        } catch (Exception e) {
            System.out.println("ERROR Logger: " + e);
        }
    }

    /**
     * Método que permite registrar un mensaje de TRACE en el log de la
     * aplicación
     *
     * INFO: Se utiliza para mostrar mensajes con un mayor nivel de detalle que
     * debug.
     *
     * @autor Leonardo Solano
     * @since 2016-02-19
     * @param msg (String) Mensaje a registrar en el log
     */
    public void trace(String msg) {
        if (logger.isTraceEnabled()) {
            this.logger.trace(msg);
        }
    }

    /**
     * Método que permite registrar un mensaje de DEBUG en el log de la
     * aplicación
     *
     * INFO: Se utiliza para escribir mensajes de depuración. Este nivel no debe
     * estar activado cuando la aplicación se encuentre en producción.
     *
     * @autor Leonardo Solano
     * @since 2016-02-19
     * @param msg (String) Mensaje a registrar en el log
     */
    public void debug(String msg) {
        if (logger.isDebugEnabled()) {
            this.logger.debug(msg);
        }
    }

    /**
     * Método que permite registrar un mensaje de INFO en el log de la
     * aplicación
     *
     * INFO: Se utiliza para mensajes similares al modo "verbose" en otras
     * aplicaciones.
     *
     * @autor Leonardo Solano
     * @since 2016-02-19
     * @param msg (String) Mensaje a registrar en el log
     */
    public void info(String msg) {
        if (logger.isInfoEnabled()) {
            this.logger.info(msg);
        }
    }

    /**
     * Método que permite registrar un mensaje de WARN en el log de la
     * aplicación
     *
     * INFO: Se utiliza para mensajes de alerta sobre eventos que se desea
     * mantener constancia, pero que no afectan al correcto funcionamiento del
     * programa.
     *
     * @autor Leonardo Solano
     * @since 2016-02-19
     * @param msg (String) Mensaje a registrar en el log
     */
    public void warn(String msg) {
        if (logger.isWarnEnabled()) {
            this.logger.warn(msg);
        }
    }

    /**
     * Método que permite registrar un mensaje de ERROR en el log de la
     * aplicación
     *
     * INFO: Se utiliza en mensajes de error de la aplicación que se desea
     * guardar, estos eventos afectan al programa pero lo dejan seguir
     * funcionando, como por ejemplo que algún parámetro de configuración no es
     * correcto y se carga el parámetro por defecto.
     *
     * @autor Leonardo Solano
     * @since 2016-02-19
     * @param msg (String) Mensaje a registrar en el log
     */
    public void error(String msg) {
        if (logger.isErrorEnabled()) {
            this.logger.error(msg);
        }
    }

    /**
     * Método que permite registrar un mensaje de FATAL en el log de la
     * aplicación
     *
     * INFO: Se utiliza para mensajes críticos del sistema, generalmente después
     * de guardar el mensaje el programa abortará.
     *
     * @autor Leonardo Solano
     * @since 2016-02-19
     * @param msg (String) Mensaje a registrar en el log
     */
    public void fatal(String msg) {
        if (logger.isFatalEnabled()) {
            this.logger.fatal(msg);
        }
    }

    /**
     * Método que permite registrar un mensaje de ERROR en el log de la
     * aplicación
     *
     * @author Leonardo
     * @since 2016-02-19
     *
     * @param errorData (ErrorData) objeto Error
     * @param exception (Exception) exception del Error
     */
    public void error(ErrorData errorData, Exception exception) {
        if (logger.isErrorEnabled()) {
            StringBuilder msj = new StringBuilder();
            msj.append("\n");
            msj.append("Operacion: ").append(errorData.getOperacion()).append("\n");
            msj.append("RequestId: ").append(errorData.getRequestId()).append("\n");
            msj.append("Ip Address: ").append(errorData.getIpAddress()).append("\n");
            msj.append("Info Adicional: ").append(errorData.getInfoAdicional()).append("\n");
            logger.error(msj.toString(), exception);
        }
    }

}
