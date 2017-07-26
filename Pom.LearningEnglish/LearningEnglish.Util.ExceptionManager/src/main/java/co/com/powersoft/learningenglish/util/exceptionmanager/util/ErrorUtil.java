/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.util.exceptionmanager.util;



import co.com.powersoft.learningenglish.util.exceptionmanager.bean.ErrorData;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Clase que permite configurar las utilidades del Error
 * @author Leonardo
 * @since 2016-02-19
 */
public class ErrorUtil {

    private static ErrorUtil instance;

    private ErrorUtil() {
    }

    /**
     * Devuelve la instancia de la clase
     *
     * @author Leonardo Solano
     * @since 2016-02-19
     * @return instancia de la clase
     */
    public static ErrorUtil getInstance() {
        if (instance == null) {
            instance = new ErrorUtil();
        }
        return instance;
    }

    /**
     * Método que permite construir un objeto de Error
     *
     * @autor Leonardo Solano
     * @since 2016-02-19
     * @param exception (Exception) excepcion asociada al error
     * @param operacion (String) nombre de la operacion
     * @param infoAdicional (String) informacion adicional
     * @return ErrorData objeto de error
     */
    public ErrorData getErrorData(Exception exception, String operacion, String infoAdicional) {

        ErrorData errorData = new ErrorData();

        errorData.setOperacion(operacion);
        errorData.setIpAddress(getIpAddress());
        errorData.setInfoAdicional(infoAdicional);

        if (exception != null) {
            StringWriter sw = new StringWriter();
            exception.printStackTrace(new PrintWriter(sw));
            errorData.setException(sw.toString());
        }

        return errorData;
    }

    /**
     * Método que permite construir un objeto de Error
     *
     * @autor Leonardo Solano
     * @since 2016-02-19
     * @param exception (Exception) excepcion asociada al error
     * @param operacion (String) nombre de la operacion
     * @param requestId (String) identificador unico del RQ
     * @param infoAdicional (String) informacion adicional
     * @return ErrorData objeto de error
     */
    public ErrorData getErrorData(Exception exception, String operacion, String requestId, String infoAdicional) {

        ErrorData errorData = new ErrorData();

        errorData.setOperacion(operacion);
        errorData.setRequestId(requestId);
        errorData.setIpAddress(getIpAddress());
        errorData.setInfoAdicional(infoAdicional);

        if (exception != null) {
            StringWriter sw = new StringWriter();
            exception.printStackTrace(new PrintWriter(sw));
            errorData.setException(sw.toString());
        }

        return errorData;
    }

    private String getIpAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return "";
        }
    }
}
