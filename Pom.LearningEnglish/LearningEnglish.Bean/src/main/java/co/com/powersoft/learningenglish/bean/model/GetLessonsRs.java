/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.bean.model;

import co.com.powersoft.learningenglish.bean.Lesson;
import co.com.powersoft.learningenglish.util.bean.generic.GenericResponse;
import java.io.Serializable;
import java.util.Map;

/**
 * Object Response of the method [Lesson - getLessons()]
 *
 * @author Leonardo Solano
 * @since 2017-01-12
 */
public class GetLessonsRs extends GenericResponse implements Serializable{
    
    private Map<String, Lesson> lessons;

    public Map<String, Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Map<String, Lesson> lessons) {
        this.lessons = lessons;
    }
    
}
