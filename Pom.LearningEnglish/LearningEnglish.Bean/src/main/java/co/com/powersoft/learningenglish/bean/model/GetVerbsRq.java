/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.bean.model;

import co.com.powersoft.learningenglish.util.bean.generic.GenericRequest;
import java.io.Serializable;

/**
 * Object Request of the method [Verb - getVerbs()]
 *
 * @author Leonardo Solano
 * @since 2017-01-15
 */
public class GetVerbsRq extends GenericRequest implements Serializable{
    
    private String lessonId;

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }   
    
    
    
}
