/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.bean.model;

import co.com.powersoft.learningenglish.util.bean.generic.GenericRequest;
import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 * Object Request of the method [Lesson - getTheme()]
 *
 * @author Leonardo Solano
 * @since 2017-01-07
 */
public class GetLessonRq extends GenericRequest implements Serializable{
    

    @NotNull()
    private String lessonId;

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }
    
    
}
