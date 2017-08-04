/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.restprovider.service;


import co.com.powersoft.learningenglish.bean.model.GetAllThemesRq;
import co.com.powersoft.learningenglish.bean.model.GetAllThemesRs;
import co.com.powersoft.learningenglish.bean.model.GetLessonRq;
import co.com.powersoft.learningenglish.bean.model.GetLessonRs;
import co.com.powersoft.learningenglish.bean.model.GetMultichoiceExamRq;
import co.com.powersoft.learningenglish.bean.model.GetMultichoiceExamRs;
import co.com.powersoft.learningenglish.bean.model.GetVerbsRq;
import co.com.powersoft.learningenglish.bean.model.GetVerbsRs;
import co.com.powersoft.learningenglish.bean.model.GetVocabularyRq;
import co.com.powersoft.learningenglish.bean.model.GetVocabularyRs;
import co.com.powersoft.learningenglish.bean.model.GetWritingExamRq;
import co.com.powersoft.learningenglish.bean.model.GetWritingExamRs;
import co.com.powersoft.learningenglish.restprovider.constants.OperationConstants;
import co.com.powersoft.learningenglish.restprovider.controller.Controller;
import co.com.powersoft.learningenglish.util.bean.util.StatusUtil;
import co.com.powersoft.learningenglish.util.exceptionmanager.exception.GeneralException;
import co.com.powersoft.learningenglish.util.exceptionmanager.util.ErrorUtil;
import co.com.powersoft.learningenglish.util.logger.print.PrintLogger;
import co.com.powersoft.logger.CustomLogger;
import javax.annotation.Resource;

import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.infinispan.Cache;

/**
 *
 * @author Leonardo Solano
 */

@Path("/learningEnglish")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServiceBean implements IServiceBean{
    
    @Resource(lookup = "java:jboss/infinispan/cache/monitor/default")
    private Cache<String, String> cache;
    
    private static ServiceBean instance;
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();   
    CustomLogger logger = new CustomLogger(this.getClass());
//    private PrintLogger logger = new PrintLogger(this.getClass());
    
    
    /**
     * Devuelve la instancia de la clase
     *
     * @author Leonardo Solano
     * @return instancia de la clase
     */
    public static ServiceBean getInstance() {
        if (null == instance) {
            instance = new ServiceBean();            
        }
        return instance;
    }
    
    @GET
    @Path("/prueba")
    public void prueba(){        
            System.out.println("HOLA ENTRO AL REST");
            System.out.println("Value in the cache:" + cache);
            cache.put("1", "leo"); // Add a entry
    }
    
    /**
     * Method for obtaining the themes
     *
     * @autor Leonardo Solano
     * @since 2017-07-01
     * @param request (GetAllThemesRq)
     * @return response (GetAllThemesRs)
     */    
    @POST
    @Path("/getAllThemes")
    @Override    
    public GetAllThemesRs getAllThemes(GetAllThemesRq request){
        
        

        //Nombre de la operación
        String OPERACION = OperationConstants.GET_ALL_THEMES;
        GetAllThemesRs response = new GetAllThemesRs();
        
        //Logger REQUEST
        PrintLogger.getInstance().printRequest(logger, OPERACION, request);

        try {
            response = Controller.getInstance().getAllThemes(request);
            response.setStatus(StatusUtil.getStatusSuccess());
        } catch (GeneralException e) {
            response.setStatus(StatusUtil.getStatusError());
            PrintLogger.getInstance().printError(logger, ErrorUtil.getInstance().getErrorData(e, OPERACION, request.getRequestId(), null));
         } catch (Exception e) {
            response.setStatus(StatusUtil.getStatusError());
            PrintLogger.getInstance().printError(logger, ErrorUtil.getInstance().getErrorData(e, OPERACION, request.getRequestId(), null));
        } finally {
            //Mapeamos las variables generales
            response.setRequestId(request.getRequestId());
            //Logger RESPONSE
            PrintLogger.getInstance().printResponse(logger, OPERACION, response);
        }
        return response;
    }
    
    /**
     * Method for obtaining a lesson
     *
     * @autor Leonardo Solano
     * @since 2017-07-01
     * @param request (GetLessonRq)
     * @return response (GetLessonRs)
     */    
    @POST
    @Path("/getLesson")
    @Override    
    public GetLessonRs getLesson(GetLessonRq request){
        
        //Nombre de la operación
        String OPERACION = OperationConstants.GET_LESSON;
        GetLessonRs response = new GetLessonRs();
        
        //Logger REQUEST
        PrintLogger.getInstance().printRequest(logger, OPERACION, request);

        try {
            //Validate request
            ValidationUtil.validateRequest(request, validator);
            
            response = Controller.getInstance().getLesson(request);
            response.setStatus(StatusUtil.getStatusSuccess());
        } catch (ConstraintViolationException e) {
            response.setStatus(StatusUtil.getStatusErrorInvalidRequest());
            PrintLogger.getInstance().printError(logger, ErrorUtil.getInstance().getErrorData(e, OPERACION, request.getRequestId(), ValidationUtil.getViolations(e.getConstraintViolations())));
        } catch (GeneralException e) {
            response.setStatus(StatusUtil.getStatusError());
            PrintLogger.getInstance().printError(logger, ErrorUtil.getInstance().getErrorData(e, OPERACION, request.getRequestId(), null));
         } catch (Exception e) {
            response.setStatus(StatusUtil.getStatusError());
            PrintLogger.getInstance().printError(logger, ErrorUtil.getInstance().getErrorData(e, OPERACION, request.getRequestId(), null));
        } finally {
            //Mapeamos las variables generales
            response.setRequestId(request.getRequestId());
            //Logger RESPONSE
            PrintLogger.getInstance().printResponse(logger, OPERACION, response);
        }
        return response;
    }
    
    /**
     * Method for obtaining the vocabulary
     *
     * @autor Leonardo Solano
     * @since 2017-07-01
     * @param request (GetVocabularyRq)
     * @return response (GetVocabularyRs)
     */    
    @POST
    @Path("/getVocabulary")
    @Override    
    public GetVocabularyRs getVocabulary(GetVocabularyRq request){

        //Nombre de la operación
        String OPERACION = OperationConstants.GET_VOCABULARY;
        GetVocabularyRs response = new GetVocabularyRs();
        
        //Logger REQUEST
        PrintLogger.getInstance().printRequest(logger, OPERACION, request);

        try {
            response = Controller.getInstance().getVocabulary(request);
            response.setStatus(StatusUtil.getStatusSuccess());
        } catch (GeneralException e) {
            response.setStatus(StatusUtil.getStatusError());
            PrintLogger.getInstance().printError(logger, ErrorUtil.getInstance().getErrorData(e, OPERACION, request.getRequestId(), null));
         } catch (Exception e) {
            response.setStatus(StatusUtil.getStatusError());
            PrintLogger.getInstance().printError(logger, ErrorUtil.getInstance().getErrorData(e, OPERACION, request.getRequestId(), null));
        } finally {
            //Mapeamos las variables generales
            response.setRequestId(request.getRequestId());
            //Logger RESPONSE
            PrintLogger.getInstance().printResponse(logger, OPERACION, response);
        }
        return response;
    }
    
    /**
     * Method for obtaining the verbs of to lesson
     *
     * @autor Leonardo Solano
     * @since 2017-07-01
     * @param request (GetVerbsRq)
     * @return response (GetVerbsRs)
     */    
    @POST
    @Path("/getVerbs")
    @Override    
    public GetVerbsRs getVerbs(GetVerbsRq request){

        //Nombre de la operación
        String OPERACION = OperationConstants.GET_VERBS;
        GetVerbsRs response = new GetVerbsRs();
        
        //Logger REQUEST
        PrintLogger.getInstance().printRequest(logger, OPERACION, request);

        try {
            response = Controller.getInstance().getVerbs(request);
            response.setStatus(StatusUtil.getStatusSuccess());
        } catch (GeneralException e) {
            response.setStatus(StatusUtil.getStatusError());
            PrintLogger.getInstance().printError(logger, ErrorUtil.getInstance().getErrorData(e, OPERACION, request.getRequestId(), null));
         } catch (Exception e) {
            response.setStatus(StatusUtil.getStatusError());
            PrintLogger.getInstance().printError(logger, ErrorUtil.getInstance().getErrorData(e, OPERACION, request.getRequestId(), null));
        } finally {
            //Mapeamos las variables generales
            response.setRequestId(request.getRequestId());
            //Logger RESPONSE
            PrintLogger.getInstance().printResponse(logger, OPERACION, response);
        }
        return response;
    }
    
    /**
     * Method for obtain the writing exam
     *
     * @autor Leonardo Solano
     * @since 2017-07-01
     * @param request (GetWritingExamRq)
     * @return response (GetWritingExamRs)
     */    
    @POST
    @Path("/getWritingExam")
    @Override    
    public GetWritingExamRs getWritingExam(GetWritingExamRq request){

        //Nombre de la operación
        String OPERACION = OperationConstants.GET_WRITING_EXAM;
        GetWritingExamRs response = new GetWritingExamRs();
        
        //Logger REQUEST
        PrintLogger.getInstance().printRequest(logger, OPERACION, request);

        try {
            response = Controller.getInstance().getWritingExam(request);
            response.setStatus(StatusUtil.getStatusSuccess());
        } catch (GeneralException e) {
            response.setStatus(StatusUtil.getStatusError());
            PrintLogger.getInstance().printError(logger, ErrorUtil.getInstance().getErrorData(e, OPERACION, request.getRequestId(), null));
         } catch (Exception e) {
            response.setStatus(StatusUtil.getStatusError());
            PrintLogger.getInstance().printError(logger, ErrorUtil.getInstance().getErrorData(e, OPERACION, request.getRequestId(), null));
        } finally {
            //Mapeamos las variables generales
            response.setRequestId(request.getRequestId());
            //Logger RESPONSE
            PrintLogger.getInstance().printResponse(logger, OPERACION, response);
        }
        return response;
    }
    
    /**
     * Method for obtain the multichoice exam
     *
     * @autor Leonardo Solano
     * @since 2017-07-01
     * @param request (GetMultichoiceExamRq)
     * @return response (GetMultichoiceExamRs)
     */    
    @POST
    @Path("/getMultichoiceExam")
    @Override    
    public GetMultichoiceExamRs getMultichoiceExam(GetMultichoiceExamRq request){

        //Nombre de la operación
        String OPERACION = OperationConstants.GET_MULTICHOICE_EXAM;
        GetMultichoiceExamRs response = new GetMultichoiceExamRs();
        
        //Logger REQUEST
        PrintLogger.getInstance().printRequest(logger, OPERACION, request);

        try {
            response = Controller.getInstance().getMultichoiceExam(request);
            response.setStatus(StatusUtil.getStatusSuccess());
        } catch (GeneralException e) {
            response.setStatus(StatusUtil.getStatusError());
            PrintLogger.getInstance().printError(logger, ErrorUtil.getInstance().getErrorData(e, OPERACION, request.getRequestId(), null));
         } catch (Exception e) {
            response.setStatus(StatusUtil.getStatusError());
            PrintLogger.getInstance().printError(logger, ErrorUtil.getInstance().getErrorData(e, OPERACION, request.getRequestId(), null));
        } finally {
            //Mapeamos las variables generales
            response.setRequestId(request.getRequestId());
            //Logger RESPONSE
            PrintLogger.getInstance().printResponse(logger, OPERACION, response);
        }
        return response;
    }
    
}
