/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.querymanager.test;


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
public class ThemeTest {
    
    
    public static void main(String[] args) {
        
//    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Gson gson = new Gson();
        
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("co.com.powersoft.learningenglish.queryJPA.PU");
            ThemeJpaController controller = new ThemeJpaController(emf);

            List<Theme> list = controller.findThemeEntities();
            
            System.out.println(gson.toJson("THEME -> "+list));
            list.forEach(obj -> System.out.println(obj.getThId()+" - "+obj.getThName()+" - "+obj.getLessonCollection()));
            
            for (Theme theme : list) {
                System.out.println(gson.toJson(theme.getThId() + " - "+theme.getThName()));
                System.out.println("--- LESSON ---");
                for (Lesson lesson : theme.getLessonCollection()) {
                    System.out.println(gson.toJson(lesson.getLeId() + " - "+lesson.getLeName()));
                }
                System.out.println("");
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
