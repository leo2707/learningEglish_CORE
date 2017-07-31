/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.restprovider.controller;

import co.com.powersoft.learningenglish.bean.Question;
import co.com.powersoft.learningenglish.bean.Lesson;
import co.com.powersoft.learningenglish.bean.LessonType;
import co.com.powersoft.learningenglish.bean.QuestionMultichoice;
import co.com.powersoft.learningenglish.bean.Theme;
import co.com.powersoft.learningenglish.bean.Verb;
import co.com.powersoft.learningenglish.bean.Vocabulary;
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
import co.com.powersoft.learningenglish.querymanager.controller.LessonJpaController;
import co.com.powersoft.learningenglish.querymanager.controller.ThemeJpaController;
import co.com.powersoft.learningenglish.querymanager.controller.VerbJpaController;
import co.com.powersoft.learningenglish.querymanager.controller.VocabularyJpaController;
import co.com.powersoft.learningenglish.restprovider.constants.OperationConstants;
import co.com.powersoft.learningenglish.restprovider.service.ValidationUtil;
import co.com.powersoft.learningenglish.util.exam.ExamMultichoiceUtil;
import co.com.powersoft.learningenglish.util.exam.ExamWritingUtil;
import co.com.powersoft.learningenglish.util.exceptionmanager.exception.GeneralException;
import co.com.powersoft.learningenglish.util.logger.print.PrintLogger;
import co.com.powersoft.learningenglish.util.utilities.ColorUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Validator;

/**
 * Controlador de los metodos generales
 *
 * @author Leonardo Solano
 * @since 2017-04-22
 */
public class Controller {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("co.com.powersoft.learningenglish.queryJPA.PU");
    private static Controller instance;
    Gson gson = new GsonBuilder().setPrettyPrinting().create();    

    public Controller() {
    }

    /**
     * Devuelve la instancia de la clase
     *
     * @author Leonardo Solano
     * @return instancia de la clase
     */
    public static Controller getInstance() {
        if (null == instance) {
            System.out.println("INICIALIZO 1");
            instance = new Controller();
        } else{
            System.out.println("NO INICIALIZO 2");
        }
        
        return instance;
    }

    /**
     * Method for obtain the themes
     *
     * @autor Leonardo Solano
     * @since 2017-07-01
     * @param request (GetAllThemesRq)
     * @return response (GetAllThemesRs)
     * @throws GeneralException
     */
    public GetAllThemesRs getAllThemes(GetAllThemesRq request) throws GeneralException {

        //Nombre de la operación
        String OPERACION = OperationConstants.GET_ALL_THEMES;
        GetAllThemesRs response = new GetAllThemesRs();

        try {
            ThemeJpaController controller = new ThemeJpaController(emf);
            List<co.com.powersoft.learningenglish.querymanager.entity.Theme> list = controller.findThemeEntities();

            //Mapping
//              List<Theme> listNew = list.stream()
//                               .map(obj -> new Theme(obj.getThId(), obj.getThName(),
//                                       obj.getThDescription(), obj.getThKeywords(),
//                                       obj.getThIcon(), obj.getThState(), obj.getThOrder(),
//                                       obj.getLessonCollection().stream().map(obj2 -> new Lesson(obj2.getLeId(), 
//                                            obj2.getLeIdLessonType() != null ? new LessonType(obj2.getLeIdLessonType().getLtId(), obj2.getLeIdLessonType().getLtValue()) : null, 
//                                            obj2.getLeName(), obj2.getLeDescription(), obj2.getLeIcon(), obj2.getLeOrder())
//                                       ).collect(Collectors.toList())
//                                       )).collect(Collectors.toList());
//              
//              
//              list.forEach(obj -> 
//                        obj.getLessonCollection().forEach(obj2 -> 
//                            System.out.println(obj.getThId()+" - "+obj.getThName()+" - " +obj2.getLeId()+" - "+obj2.getLeName()))
//                      );
//              List<Theme> listNew2 = new ArrayList<>();
//              for (co.com.powersoft.learningenglish.querymanager.entity.Theme themeEntity : list) {
//                System.out.println(gson.toJson(themeEntity.getThId() + " - "+themeEntity.getThName()));
//                
//                Theme theme = new Theme(themeEntity.getThId(), themeEntity.getThName(),
//                                       themeEntity.getThDescription(), themeEntity.getThKeywords(),
//                                       themeEntity.getThIcon(), themeEntity.getThState(), themeEntity.getThOrder());
//                
//                System.out.println("--- LESSON ---");
//                
//                List<Lesson> listLessons = new ArrayList<>();
//                for (co.com.powersoft.learningenglish.querymanager.entity.Lesson lessonEntity : themeEntity.getLessonCollection()) {
//                    System.out.println(gson.toJson(lessonEntity.getLeId() + " - "+lessonEntity.getLeName()));
//                    Lesson lesson = new Lesson(lessonEntity.getLeId(), 
//                                            lessonEntity.getLeIdLessonType() != null ? new LessonType(lessonEntity.getLeIdLessonType().getLtId(), lessonEntity.getLeIdLessonType().getLtValue()) : null, 
//                                            lessonEntity.getLeName(), lessonEntity.getLeDescription(), lessonEntity.getLeIcon(), lessonEntity.getLeOrder());
//                    listLessons.add(lesson);
//                }
//                theme.setLessons(listLessons);
//                System.out.println("");
//                
//                listNew2.add(theme);
//            }
            List<Theme> themes = new ArrayList<>();
            for (co.com.powersoft.learningenglish.querymanager.entity.Theme themeEntity : list) {
                Theme theme = new Theme();
                theme.setId(themeEntity.getThId());
                theme.setName(themeEntity.getThName());
                theme.setDescription(themeEntity.getThDescription());
                theme.setKeywords(themeEntity.getThKeywords());
                theme.setIcon(themeEntity.getThIcon());
                theme.setState(themeEntity.getThState());
                theme.setOrder(themeEntity.getThOrder());

                List<Lesson> lessons = new ArrayList<>();
                int position = 1;
                for (co.com.powersoft.learningenglish.querymanager.entity.Lesson lessonEntity : themeEntity.getLessonCollection()) {
                    Lesson lesson = new Lesson();
                    lesson.setId(lessonEntity.getLeId());
                    lesson.setName(lessonEntity.getLeName());
                    lesson.setDescription(lessonEntity.getLeDescription());
                    lesson.setIcon(lessonEntity.getLeIcon());
                    lesson.setOrder(lessonEntity.getLeOrder());
                    lesson.setColor(ColorUtil.getColorPosition(position));
                    lessons.add(lesson);

                    position++;
                }
                theme.setLessons(lessons);
                themes.add(theme);
            }

            response.setThemes(themes);
        } catch (Exception e) {
            throw new GeneralException(GeneralException.EXCEPTION_TYPE_GENERIC, OPERACION, request.getRequestId(), e);
        }
        return response;
    }

    /**
     * Method for obtain a lesson
     *
     * @autor Leonardo Solano
     * @since 2017-07-01
     * @param request (GetLessonRq)
     * @return response (GetLessonRs)
     * @throws GeneralException
     */
    public GetLessonRs getLesson(GetLessonRq request) throws GeneralException {

        //Nombre de la operación
        String OPERACION = OperationConstants.GET_LESSON;
        GetLessonRs response = new GetLessonRs();

        try {
            LessonJpaController controller = new LessonJpaController(emf);
            co.com.powersoft.learningenglish.querymanager.entity.Lesson lessonEntity = controller.findLesson(request.getLessonId());

            //Mapping
            if(lessonEntity != null){
            Lesson lesson = new Lesson();
                lesson.setId(lessonEntity.getLeId());
                lesson.setName(lessonEntity.getLeName());
                lesson.setDescription(lessonEntity.getLeDescription());
                lesson.setIcon(lessonEntity.getLeIcon());
                lesson.setOrder(lessonEntity.getLeOrder());
                lesson.setLessonType(lessonEntity.getLeIdLessonType() != null
                        ? new LessonType(lessonEntity.getLeIdLessonType().getLtId(), lessonEntity.getLeIdLessonType().getLtValue()) : null);

                response.setLesson(lesson);
            }
        } catch (Exception e) {
            throw new GeneralException(GeneralException.EXCEPTION_TYPE_GENERIC, OPERACION, request.getRequestId(), e);
        }
        return response;
    }

    /**
     * Method for obtain the vocabulary
     *
     * @autor Leonardo Solano
     * @since 2017-07-01
     * @param request (GetVocabularyRq)
     * @return response (GetVocabularyRs)
     * @throws GeneralException
     */
    public GetVocabularyRs getVocabulary(GetVocabularyRq request) throws GeneralException {

        //Nombre de la operación
        String OPERACION = OperationConstants.GET_VOCABULARY;
        GetVocabularyRs response = new GetVocabularyRs();

        try {
            VocabularyJpaController controller = new VocabularyJpaController(emf);
            List<co.com.powersoft.learningenglish.querymanager.entity.Vocabulary> list = controller.findVocabularyFromLesson(request.getLessonId());

            //Mapping
            List<Vocabulary> listNew = list.stream()
                    .map(obj -> new Vocabulary(obj.getVoId(),
                    obj.getVoEnglishValue(), obj.getVoEnglishPronunciation(), obj.getVoEnglishSound(),
                    obj.getVoSpanishValue(), obj.getVoSpanishPronunciation(), obj.getVoSpanishSound(),
                    obj.getVoOtherValue(), obj.getVoImg(), obj.getVoOrder()
            )).collect(Collectors.toList());

            response.setListVocabulary(listNew);
        } catch (Exception e) {
            throw new GeneralException(GeneralException.EXCEPTION_TYPE_GENERIC, OPERACION, request.getRequestId(), e);
        }
        return response;
    }

    /**
     * Method for obtain the verbs of to lesson
     *
     * @autor Leonardo Solano
     * @since 2017-07-01
     * @param request (GetVerbsRq)
     * @return response (GetVerbsRs)
     * @throws GeneralException
     */
    public GetVerbsRs getVerbs(GetVerbsRq request) throws GeneralException {

        //Nombre de la operación
        String OPERACION = OperationConstants.GET_VERBS;
        GetVerbsRs response = new GetVerbsRs();

        try {
            VerbJpaController controller = new VerbJpaController(emf);
            List<co.com.powersoft.learningenglish.querymanager.entity.Verb> list = controller.findVerbsFromLesson(request.getLessonId());

            //Mapping
            List<Verb> listNew = list.stream()
                    .map(obj -> new Verb(obj.getVeId(), obj.getVeTypeVerb(),
                    obj.getVeEnglishPresentValue(), obj.getVeEnglishPresentPronunciation(), obj.getVeEnglishPresentSound(),
                    obj.getVeEnglishPastValue(), obj.getVeEnglishPastPronunciation(), obj.getVeEnglishPastSound(),
                    obj.getVeEnglishPastParticipleValue(), obj.getVeEnglishPastParticiplePronunciation(), obj.getVeEnglishPastParticipleSound(),
                    obj.getVeSpanishValue(), obj.getVeSpanishPronunciation(), obj.getVeSpanishSound(), obj.getVeOtherValue(), obj.getVeOrder()
            )).collect(Collectors.toList());

            response.setVerbs(listNew);
        } catch (Exception e) {
            throw new GeneralException(GeneralException.EXCEPTION_TYPE_GENERIC, OPERACION, request.getRequestId(), e);
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
     * @throws GeneralException
     */
    public GetWritingExamRs getWritingExam(GetWritingExamRq request) throws GeneralException {

        //Nombre de la operación
        String OPERACION = OperationConstants.GET_WRITING_EXAM;
        
        GetWritingExamRs response = new GetWritingExamRs();
        List<Vocabulary> vocabulary;

        try {
            if(request.getVocabularyType().equals("VOCABULARY")){
                vocabulary = new ArrayList<>();
            } else {
                //VERBS
                GetVerbsRq getVerbsRq = new GetVerbsRq();
                getVerbsRq.setLessonId(request.getLessonId());
                getVerbsRq.setRequestId(request.getRequestId());
                GetVerbsRs getVerbsRs = getVerbs(getVerbsRq);
                
                //Mapping
                vocabulary = getVerbsRs.getVerbs().stream()
                    .map(obj -> new Vocabulary(
                    obj.getEnglishPresentValue(), obj.getEnglishPresentPronunciation(), obj.getEnglishPresentSound(),
                    obj.getSpanishValue(), obj.getSpanishPronunciation(), obj.getSpanishSound()
                )).collect(Collectors.toList());
                
            }
            
            List<Question> questions = ExamWritingUtil.getExam(vocabulary,
                    request.getConfigExam().getNumberOfQuestion(), 
                    request.getConfigExam().getQuestionLanguaje(), 
                    request.getConfigExam().getOrderQuestions());

            response.setQuestions(questions);
        } catch (Exception e) {
            throw new GeneralException(GeneralException.EXCEPTION_TYPE_GENERIC, OPERACION, request.getRequestId(), e);
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
     * @throws GeneralException
     */
    public GetMultichoiceExamRs getMultichoiceExam(GetMultichoiceExamRq request) throws GeneralException {

        //Nombre de la operación
        String OPERACION = OperationConstants.GET_MULTICHOICE_EXAM;
        
        GetMultichoiceExamRs response = new GetMultichoiceExamRs();
        List<Vocabulary> vocabulary;

        try {
            if(request.getVocabularyType().equals("VOCABULARY")){
                vocabulary = new ArrayList<>();
            } else {
                //VERBS
                GetVerbsRq getVerbsRq = new GetVerbsRq();
                getVerbsRq.setLessonId(request.getLessonId());
                getVerbsRq.setRequestId(request.getRequestId());
                GetVerbsRs getVerbsRs = getVerbs(getVerbsRq);
                
                //Mapping
                vocabulary = getVerbsRs.getVerbs().stream()
                    .map(obj -> new Vocabulary(
                    obj.getEnglishPresentValue(), obj.getEnglishPresentPronunciation(), obj.getEnglishPresentSound(),
                    obj.getSpanishValue(), obj.getSpanishPronunciation(), obj.getSpanishSound()
                )).collect(Collectors.toList());
                
            }
            
            List<QuestionMultichoice> questions = ExamMultichoiceUtil.getExam(vocabulary,
                    request.getConfigExam().getNumberOfQuestion(), 
                    request.getConfigExam().getQuestionLanguaje(), 
                    request.getConfigExam().getOrderQuestions());

            response.setQuestions(questions);
        } catch (Exception e) {
            throw new GeneralException(GeneralException.EXCEPTION_TYPE_GENERIC, OPERACION, request.getRequestId(), e);
        }
        return response;
    }   

}
