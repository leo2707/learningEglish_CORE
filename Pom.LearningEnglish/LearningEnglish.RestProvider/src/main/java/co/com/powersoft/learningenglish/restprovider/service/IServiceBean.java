/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.restprovider.service;

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

/**
 *
 * @author Leonardo
 */
public interface IServiceBean {
    
    public GetAllThemesRs getAllThemes(GetAllThemesRq request);
    public GetLessonRs getLesson(GetLessonRq request);
    public GetVocabularyRs getVocabulary(GetVocabularyRq request);
    public GetVerbsRs getVerbs(GetVerbsRq request);
    public GetWritingExamRs getWritingExam(GetWritingExamRq request);
    public GetMultichoiceExamRs getMultichoiceExam(GetMultichoiceExamRq request);
    
}
