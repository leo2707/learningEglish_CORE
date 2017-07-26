/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.util.exam;

import co.com.powersoft.learningenglish.bean.Question;
import co.com.powersoft.learningenglish.bean.QuestionMultichoice;
import co.com.powersoft.learningenglish.bean.Vocabulary;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Leonardo
 */
public class ExamMultichoiceUtil {
    
    //Question
    public static final String SPANISH = "SPANISH";
    public static final String ENGLISH = "ENGLISH";

    //Type Exam
    public static final String MULTICHOICE = "MULTICHOICE";

    //Order Questions
    public static final String RANDOM = "RANDOM";
    public static final String ASCENDING = "ASCENDING";
    public static final String DESCENDING = "DESCENDING";
    public static final String DEFAULT = "DEFAULT";

    /**
     * Get multi choice exam
     *
     * @autor Leonardo Solano
     * @since 2017-01-03
     * @param listVocabulary (List<Vocabulary>) vocabulary list
     * @param countQestions (int) Count of questions
     * @param question (String) Type of question
     * @param order (String) Type of order
     * @return list (List<QuestionMultichoice>)
     */
    public static List<QuestionMultichoice> getExam(List<Vocabulary> listVocabulary, int countQestions, String question, String order) {

        List<QuestionMultichoice> listExamMultichoice;

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
                
                listExamMultichoice = getMultichoiceSpanishEnglish(listVocabulary, countQestions);                
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
                
                listExamMultichoice = getMultichoiceEnglishSpanish(listVocabulary, countQestions);
                break;
            default:
                listExamMultichoice = null;
        }

        return listExamMultichoice;
    }

    /**
     * Get multi choice exam in spanish to english
     *
     * @autor Leonardo Solano
     * @since 2017-01-03
     * @param listVocabulary (List<Vocabulary>) vocabulary list
     * @param countQestions (int) Count of questions
     * @return list (List<QuestionMultichoice>)
     */
    public static List<QuestionMultichoice> getMultichoiceSpanishEnglish(List<Vocabulary> listVocabulary, int countQestions) {

        List<QuestionMultichoice> listExamMultichoice = new ArrayList<>();

        //Create List 2
        List<Vocabulary> listVocabulary2 = new ArrayList<>();
        listVocabulary2.addAll(listVocabulary);
        String[] vecLetters = {"a", "b", "c", "d"};

        int numQuestion = 1;
        for (Vocabulary vocabulary : listVocabulary) {
            if (numQuestion <= countQestions) {

                QuestionMultichoice questionMultichoice = new QuestionMultichoice();
                Question exam = new Question();

                Collections.shuffle(listVocabulary2);
                int numRandom = (int) (Math.random() * 4);
                exam.setIdQuestion(numQuestion);
                exam.setQuestion(vocabulary.getSpanishValue());

                int answer = 0;
                boolean sw = false;
                Map<String, String> mapOption = new HashMap<>();

                for (Vocabulary vocabulary2 : listVocabulary) {
                    if (answer < 4) {
                        if (sw == false && answer == numRandom) {
                            exam.setAnswer(vecLetters[answer]);
                            mapOption.put(vecLetters[answer], vocabulary.getEnglishValue());
//                            listOptions.add(vecLetters[answer] + ") " + vocabulary.getEnglishValue());
                            sw = true;
                            answer++;
                        } else {
                            if (!vocabulary.getEnglishValue().equals(vocabulary2.getEnglishValue())) {
                                mapOption.put(vecLetters[answer], vocabulary2.getEnglishValue());
//                                listOptions.add(vecLetters[answer] + ") " + vocabulary2.getEnglishValue());
                                answer++;
                            }
                        }
                        questionMultichoice.setOptions(mapOption);
                    } else {
                        break;
                    }
                }

                numQuestion++;
                questionMultichoice.setExam(exam);
                listExamMultichoice.add(questionMultichoice);
            } else {
                break;
            }
        }
        return listExamMultichoice;
    }

    /**
     * Get multi choice exam in english to spanish
     *
     * @autor Leonardo Solano
     * @since 2017-01-03
     * @param listVocabulary (List<Vocabulary>) vocabulary list
     * @param countQestions (int) Count of questions
     * @return list (List<QuestionMultichoice>)
     */
    public static List<QuestionMultichoice> getMultichoiceEnglishSpanish(List<Vocabulary> listVocabulary, int countQestions) {

        List<QuestionMultichoice> listExamMultichoice = new ArrayList<>();

        //Create List 2
        List<Vocabulary> listVocabulary2 = new ArrayList<>();
        listVocabulary2.addAll(listVocabulary);

//        //Shuffle vocabulary
//        Collections.shuffle(listVocabulary);
        String[] vecLetters = {"a", "b", "c", "d"};

        int numQuestion = 1;
        for (Vocabulary vocabulary : listVocabulary) {
            if (numQuestion <= countQestions) {

                QuestionMultichoice questionMultichoice = new QuestionMultichoice();
                Question exam = new Question();

                Collections.shuffle(listVocabulary2);
                int numRandom = (int) (Math.random() * 4);
                exam.setIdQuestion(numQuestion);
                exam.setQuestion(vocabulary.getEnglishValue());

                int answer = 0;
                boolean sw = false;
                Map<String, String> mapOption = new HashMap<>();

                for (Vocabulary vocabulary2 : listVocabulary) {
                    if (answer < 4) {
                        if (sw == false && answer == numRandom) {
                            exam.setAnswer(vecLetters[answer]);
                            mapOption.put(vecLetters[answer], vocabulary.getSpanishValue());
//                            listOptions.add(vecLetters[answer] + ") " + vocabulary.getSpanishValue());
                            sw = true;
                            answer++;
                        } else {
                            if (!vocabulary.getEnglishValue().equals(vocabulary2.getEnglishValue())) {
                                mapOption.put(vecLetters[answer], vocabulary2.getSpanishValue());
//                                listOptions.add(vecLetters[answer] + ") " + vocabulary2.getSpanishValue());
                                answer++;
                            }
                        }
                        questionMultichoice.setOptions(mapOption);
                    } else {
                        break;
                    }
                }

                numQuestion++;
                questionMultichoice.setExam(exam);
                listExamMultichoice.add(questionMultichoice);
            } else {
                break;
            }
        }
        return listExamMultichoice;
    }
    
}
