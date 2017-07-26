/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.util.bean.util;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

/**
 * Clase encargada de las validaciones de los request
 * @author Leonardo
 */
public class ValidationUtil {

    private static ValidationUtil instance;

    public static ValidationUtil getInstance() {
        if (null == instance) {
            instance = new ValidationUtil();
        }
        return instance;
    }

    public static void validateRequest(Object request, Validator validator)
            throws ConstraintViolationException {
        // Se validan las reestricciones establecidas en el request
        Set<ConstraintViolation<Object>> violations = validator.validate(request);
        
        // Si exite alguna violacion de las reestricciones se genera una excepcion
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
        }
    }
    
    public static String getViolations(Set<ConstraintViolation<?>> violations){
        StringBuilder violationsString = new StringBuilder();
            violationsString.append("Invalid Request").append("\r\n");
            for (ConstraintViolation<?> violation : violations) {
                violationsString.append("Atribute: ").append(violation.getPropertyPath()).append(" -> ").append(violation.getMessage()).append("\r\n");
            }
            return violationsString.toString();
    }
    
}
