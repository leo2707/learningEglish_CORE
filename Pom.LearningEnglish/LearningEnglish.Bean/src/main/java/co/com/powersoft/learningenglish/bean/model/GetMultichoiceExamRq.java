/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.bean.model;

import co.com.powersoft.learningenglish.bean.ConfigExam;
import co.com.powersoft.learningenglish.util.bean.generic.GenericRequest;
import java.io.Serializable;

/**
 * Object Request of the method [Exam - getMultichoiceExam()]
 *
 * @author Leonardo Solano
 * @since 2017-07-09
 */
public class GetMultichoiceExamRq extends GenericRequest implements Serializable{
    
    private String lessonId;
    private String vocabularyType;
    private ConfigExam configExam;

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public String getVocabularyType() {
        return vocabularyType;
    }

    public void setVocabularyType(String vocabularyType) {
        this.vocabularyType = vocabularyType;
    }

    public ConfigExam getConfigExam() {
        return configExam;
    }

    public void setConfigExam(ConfigExam configExam) {
        this.configExam = configExam;
    }
    
    
    
    
}
