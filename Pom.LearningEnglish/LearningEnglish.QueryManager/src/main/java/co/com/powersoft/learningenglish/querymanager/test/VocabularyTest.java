/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.querymanager.test;


import co.com.powersoft.learningenglish.querymanager.controller.ThemeJpaController;
import co.com.powersoft.learningenglish.querymanager.controller.VocabularyJpaController;
import co.com.powersoft.learningenglish.querymanager.entity.Lesson;
import co.com.powersoft.learningenglish.querymanager.entity.Theme;
import co.com.powersoft.learningenglish.querymanager.entity.Vocabulary;
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
public class VocabularyTest {
    
    
    public static void main(String[] args) {
        
//    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Gson gson = new Gson();
        
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("co.com.powersoft.learningenglish.queryJPA.PU");
            VocabularyJpaController controller = new VocabularyJpaController(emf);

            List<Vocabulary> list = controller.findVocabularyFromLesson2("1_1");
//            List<Vocabulary> list = controller.findVocabularyEntities();
            
            list.forEach(obj -> System.out.println(obj.getVoId()+" - "+obj.getVoEnglishValue()+" - "+obj.getVoSpanishValue()));            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
