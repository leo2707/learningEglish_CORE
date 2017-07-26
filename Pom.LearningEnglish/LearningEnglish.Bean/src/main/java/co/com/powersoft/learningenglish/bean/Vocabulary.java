/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.bean;

import java.io.Serializable;

/**
 *
 * @author Leonardo
 */
public class Vocabulary implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private int id;
     private Lesson lesson;
     private String englishValue;
     private String englishPronunciation;
     private String englishSound;     
     private String spanishValue;
     private String spanishPronunciation;
     private String spanishSound;     
     private String otherValue;
     private String img;
     private Integer order;

    public Vocabulary() {
    }
    
    public Vocabulary(String englishValue, String englishPronunciation, String englishSound, String spanishValue, String spanishPronunciation, String spanishSound) {
        this.englishValue = englishValue;
        this.englishPronunciation = englishPronunciation;
        this.englishSound = englishSound;
        this.spanishValue = spanishValue;
        this.spanishPronunciation = spanishPronunciation;
        this.spanishSound = spanishSound;
    }

    public Vocabulary(int id, String englishValue, String englishPronunciation, String englishSound, String spanishValue, String spanishPronunciation, String spanishSound, String otherValue, String img, Integer order) {
        this.id = id;
        this.englishValue = englishValue;
        this.englishPronunciation = englishPronunciation;
        this.englishSound = englishSound;
        this.spanishValue = spanishValue;
        this.spanishPronunciation = spanishPronunciation;
        this.spanishSound = spanishSound;
        this.otherValue = otherValue;
        this.img = img;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public String getEnglishValue() {
        return englishValue;
    }

    public void setEnglishValue(String englishValue) {
        this.englishValue = englishValue;
    }

    public String getEnglishPronunciation() {
        return englishPronunciation;
    }

    public void setEnglishPronunciation(String englishPronunciation) {
        this.englishPronunciation = englishPronunciation;
    }

    public String getEnglishSound() {
        return englishSound;
    }

    public void setEnglishSound(String englishSound) {
        this.englishSound = englishSound;
    }

    public String getSpanishValue() {
        return spanishValue;
    }

    public void setSpanishValue(String spanishValue) {
        this.spanishValue = spanishValue;
    }

    public String getSpanishPronunciation() {
        return spanishPronunciation;
    }

    public void setSpanishPronunciation(String spanishPronunciation) {
        this.spanishPronunciation = spanishPronunciation;
    }

    public String getSpanishSound() {
        return spanishSound;
    }

    public void setSpanishSound(String spanishSound) {
        this.spanishSound = spanishSound;
    }

    public String getOtherValue() {
        return otherValue;
    }

    public void setOtherValue(String otherValue) {
        this.otherValue = otherValue;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
    
}
