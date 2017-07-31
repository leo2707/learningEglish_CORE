/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.test;

import co.com.powersoft.learningenglish.bean.ConfigExam;
import co.com.powersoft.learningenglish.bean.model.GetAllThemesRq;
import co.com.powersoft.learningenglish.bean.model.GetAllThemesRs;
import co.com.powersoft.learningenglish.bean.model.GetLessonRq;
import co.com.powersoft.learningenglish.bean.model.GetLessonRs;
import co.com.powersoft.learningenglish.bean.model.GetMultichoiceExamRq;
import co.com.powersoft.learningenglish.bean.model.GetMultichoiceExamRs;
import co.com.powersoft.learningenglish.bean.model.GetWritingExamRq;
import co.com.powersoft.learningenglish.bean.model.GetWritingExamRs;
import co.com.powersoft.learningenglish.util.UtilRest;
import co.com.powersoft.learningenglish.util.logger.print.PrintLogger;
import co.com.powersoft.learningenglish.util.utilities.Utilities;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Leonardo
 */
public class TestRest {
    
    private static final String ENDPOINT = "http://localhost:8080/RestProvider/rest/learningEnglish/";
    private static final String SLASH = "/";
    
    public TestRest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    //@Test
     public void getAllThemes() {

        //Nombre de la operaciÃ³n
        String OPERACION = "GET_THEMES";
        String endpoint = ENDPOINT + "getAllThemes";

        try {
            GetAllThemesRq request = new GetAllThemesRq();
            request.setRequestDate(new Date());
            request.setRequestId("123456789");
            request.setUserId("lsolano");

            //Logger REQUEST
            PrintLogger.getInstance().printRequest(OPERACION, request);

            GetAllThemesRs response = (GetAllThemesRs) UtilRest.getResponse(endpoint, request, GetAllThemesRs.class);

            //Logger RESPONSE
            PrintLogger.getInstance().printResponse(OPERACION, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     
     @Test
     public void getLesson() {

        //Nombre de la operaciÃ³n
        String OPERACION = "GET_LESSON";
        String endpoint = ENDPOINT + "getLesson";

        try {
            GetLessonRq request = new GetLessonRq();
            request.setRequestDate(new Date());
            request.setRequestId(Utilities.generateRequestID());
            request.setAppOrigin("App Test");
            request.setIpOrigin(Utilities.getLocalIpAddress());
            request.setUserId("lsolano");
            request.setLessonId("1_1");

            //Logger REQUEST
            PrintLogger.getInstance().printRequest(OPERACION, request);

            GetLessonRs response = (GetLessonRs) UtilRest.getResponse(endpoint, request, GetLessonRs.class);

            //Logger RESPONSE
            PrintLogger.getInstance().printResponse(OPERACION, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     
//     @Test
     public void getWritingExam() {

        //Nombre de la operaciÃ³n
        String OPERACION = "GET_WRITING_EXAM";
        String endpoint = ENDPOINT + "getWritingExam";

        try {
            GetWritingExamRq request = new GetWritingExamRq();
            request.setRequestDate(new Date());
            request.setRequestId("123456789");
            request.setUserId("lsolano");
            
            request.setLessonId("13_2");
            request.setVocabularyType("VERB");
            ConfigExam configExam = new ConfigExam();
//            configExam.setQuestionLanguaje("SPANISH");
            configExam.setQuestionLanguaje("ENGLISH");
            configExam.setTypeQuestion("WRITING");
            configExam.setOrderQuestions("RANDOM");
            configExam.setNumberOfQuestion(5);
            request.setConfigExam(configExam);

            //Logger REQUEST
            PrintLogger.getInstance().printRequest(OPERACION, request);

            GetWritingExamRs response = (GetWritingExamRs) UtilRest.getResponse(endpoint, request, GetWritingExamRs.class);

            //Logger RESPONSE
            PrintLogger.getInstance().printResponse(OPERACION, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     
     //@Test
     public void getMultichoiceExam() {

        //Nombre de la operaciÃ³n
        String OPERACION = "GET_MULTICHOICE_EXAM";
        String endpoint = ENDPOINT + "getMultichoiceExam";

        try {
            GetMultichoiceExamRq request = new GetMultichoiceExamRq();
            request.setRequestDate(new Date());
            request.setRequestId("123456789");
            request.setUserId("lsolano");
            
            request.setLessonId("13_2");
            request.setVocabularyType("VERB");
            ConfigExam configExam = new ConfigExam();
//            configExam.setQuestionLanguaje("SPANISH");
            configExam.setQuestionLanguaje("ENGLISH");
            configExam.setTypeQuestion("MULTICHOICE");
            configExam.setOrderQuestions("RANDOM");
            configExam.setNumberOfQuestion(5);
            request.setConfigExam(configExam);

            //Logger REQUEST
            PrintLogger.getInstance().printRequest(OPERACION, request);

            GetMultichoiceExamRs response = (GetMultichoiceExamRs) UtilRest.getResponse(endpoint, request, GetMultichoiceExamRs.class);

            //Logger RESPONSE
            PrintLogger.getInstance().printResponse(OPERACION, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
