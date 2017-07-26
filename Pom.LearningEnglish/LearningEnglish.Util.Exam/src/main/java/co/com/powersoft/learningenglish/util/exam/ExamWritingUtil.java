/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.util.exam;

import co.com.powersoft.learningenglish.bean.Question;
import co.com.powersoft.learningenglish.bean.Vocabulary;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class ExamWritingUtil {
    
    //Question
    public static final String SPANISH = "SPANISH";
    public static final String ENGLISH = "ENGLISH";

    //Type Exam
    public static final String WRITING = "WRITING";

    //Order Questions
    public static final String RANDOM = "RANDOM";
    public static final String ASCENDING = "ASCENDING";
    public static final String DESCENDING = "DESCENDING";

    /**
     * Get writing exam
     *
     * @autor Leonardo Solano
     * @since 2017-01-05
     * @param listVocabulary (List<Vocabulary>) vocabulary list
     * @param countQestions (int) Count of questions
     * @param question (String) Type of question
     * @param order (String) Type of order
     * @return list (List<Exam>)
     */
    public static List<Question> getExam(List<Vocabulary> listVocabulary, int countQestions, String question, String order) {

        List<Question> listExamWriting;

        switch (question) {
            case SPANISH:
                
                //Sort list
                if(order.equals(RANDOM)){
                    Collections.shuffle(listVocabulary);
                } else if(order.equals(ASCENDING)){
                    listVocabulary.sort((p1, p2) -> p1.getSpanishValue().compareTo(p2.getSpanishValue()));
                } if(order.equals(DESCENDING)){
                    Comparator<Vocabulary> comparator = Comparator.comparing(Vocabulary::getSpanishValue);
                    Collections.sort(listVocabulary, comparator.reversed());
                }
                
                listExamWriting = getWritingSpanishEnglish(listVocabulary, countQestions);               
                break;
            case ENGLISH:
                
                //Sort list
                if(order.equals(RANDOM)){
                    Collections.shuffle(listVocabulary);
                } else if(order.equals(ASCENDING)){
                    listVocabulary.sort((p1, p2) -> p1.getEnglishValue().compareTo(p2.getEnglishValue()));
                } if(order.equals(DESCENDING)){
                    Comparator<Vocabulary> comparator = Comparator.comparing(Vocabulary::getEnglishValue);
                    Collections.sort(listVocabulary, comparator.reversed());
                }
                
                listExamWriting = getWritingEnglishSpanish(listVocabulary, countQestions);
                break;
            default:
                listExamWriting = null;
        }

        return listExamWriting;
    }

    /**
     * Get writing exam in spanish to english
     *
     * @autor Leonardo Solano
     * @since 2017-01-05
     * @param listVocabulary (List<Vocabulary>) vocabulary list
     * @param countQestions (int) Count of questions
     * @return list (List<Exam>)
     */
    public static List<Question> getWritingSpanishEnglish(List<Vocabulary> listVocabulary, int countQestions) {

        List<Question> listExamWriting = new ArrayList<>();

        int numQuestion = 1;
        for (Vocabulary vocabulary : listVocabulary) {
            if (numQuestion <= countQestions) {
                Question exam = new Question();
                
                exam.setIdQuestion(numQuestion);
                exam.setQuestion(vocabulary.getSpanishValue());
                exam.setAnswer(vocabulary.getEnglishValue());
                
                listExamWriting.add(exam);
                numQuestion++;
            } else {
                break;
            }
        }
        return listExamWriting;
    }

    /**
     * Get writing exam in spanish to english
     *
     * @autor Leonardo Solano
     * @since 2017-01-05
     * @param listVocabulary (List<Vocabulary>) vocabulary list
     * @param countQestions (int) Count of questions
     * @return list (List<ExamWriting>)
     */
    public static List<Question> getWritingEnglishSpanish(List<Vocabulary> listVocabulary, int countQestions) {

        List<Question> listExamWriting = new ArrayList<>();

        int numQuestion = 1;
        for (Vocabulary vocabulary : listVocabulary) {
            if (numQuestion <= countQestions) {
                Question exam = new Question();
                
                exam.setIdQuestion(numQuestion);
                exam.setQuestion(vocabulary.getEnglishValue());
                exam.setAnswer(vocabulary.getSpanishValue());
                
                listExamWriting.add(exam);
                numQuestion++;
            } else {
                break;
            }
        }
        return listExamWriting;
    }
    
}
