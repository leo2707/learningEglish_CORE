/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.util.exceptionmanager.exception;

import co.com.powersoft.learningenglish.util.exceptionmanager.util.ExceptionUtil;







/**
 * Clase que administra las excepciones
 *
 * @author Leonardo Solano
 * @since 2017-04-22
 */
public class GeneralException extends Exception {

    private static final long serialVersionUID = 1L;
    public static final String EXCEPTION_TYPE_GENERIC = "EXCEPTION-GENERIC-ERROR";
    public static final String EXCEPTION_TYPE_REST = "EXCEPTION-REST-ERROR";
    public static final String EXCEPTION_TYPE_DATABASE = "EXCEPTION-DATABASE-ERROR";
    public static final String EXCEPTION_TYPE_DATABASE_NEXT = "EXCEPTION-DATABASE-NEXT-ERROR";

    public GeneralException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public GeneralException(String exeptionType, String operacion, String infoAdicional, Throwable cause) {
        super(exeptionType + ": " + ExceptionUtil.getInstance().getExceptionData(operacion, infoAdicional), cause);
    }
    public GeneralException(String exeptionType, String operacion, String nextException, String infoAdicional, Throwable cause) {
        super(exeptionType + ": " + ExceptionUtil.getInstance().getExceptionData(operacion, nextException, infoAdicional), cause);
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

}
