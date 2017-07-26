/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.bean.model;

import co.com.powersoft.learningenglish.bean.Lesson;
import co.com.powersoft.learningenglish.util.bean.generic.GenericResponse;
import java.io.Serializable;

/**
 * Object Response of the method [Lesson - getLesson()]
 *
 * @author Leonardo Solano
 * @since 2017-01-07
 */
public class GetLessonRs extends GenericResponse implements Serializable{
    
    private Lesson lesson;

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
    
}
