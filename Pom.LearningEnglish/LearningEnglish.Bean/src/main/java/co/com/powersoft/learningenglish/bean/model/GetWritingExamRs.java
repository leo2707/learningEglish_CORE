/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.bean.model;

import co.com.powersoft.learningenglish.bean.Question;
import co.com.powersoft.learningenglish.util.bean.generic.GenericResponse;
import java.io.Serializable;
import java.util.List;

/**
 * Object Response of the method [Exam - getWritingExam()]
 *
 * @author Leonardo Solano
 * @since 2017-07-09
 */
public class GetWritingExamRs extends GenericResponse implements Serializable{
    
    private List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    
    
}
