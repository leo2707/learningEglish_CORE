/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.querymanager.test;


import co.com.powersoft.learningenglish.querymanager.controller.LessonJpaController;
import co.com.powersoft.learningenglish.querymanager.controller.ThemeJpaController;
import co.com.powersoft.learningenglish.querymanager.entity.Lesson;
import co.com.powersoft.learningenglish.querymanager.entity.Theme;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Leonardo
 */
public class LessonTest {
    
    
    public static void main(String[] args) {
        
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("co.com.powersoft.learningenglish.queryJPA.PU");
            LessonJpaController controller = new LessonJpaController(emf);
            co.com.powersoft.learningenglish.querymanager.entity.Lesson lessonEntity = controller.findLesson("2_1");
            
            System.out.println(lessonEntity.getLeId() + " - "+lessonEntity.getLeName());
            if(lessonEntity.getLeIdLessonType() != null)
            System.out.println(lessonEntity.getLeIdLessonType().getLtId() + " - "+lessonEntity.getLeIdLessonType().getLtValue());
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
