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
public class Verb implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private Lesson lesson;
    private String typeVerb;
    private String englishPresentValue;
    private String englishPresentPronunciation;
    private String englishPresentSound;
    private String englishPastValue;
    private String englishPastPronunciation;
    private String englishPastSound;
    private String englishPastParticipleValue;
    private String englishPastParticiplePronunciation;
    private String englishPastParticipleSound;
    private String spanishValue;
    private String spanishPronunciation;
    private String spanishSound;
    private String otherValue;
    private Integer order;

    public Verb() {
    }

    public Verb(int id, String typeVerb, String englishPresentValue, String englishPresentPronunciation, String englishPresentSound, String englishPastValue, String englishPastPronunciation, String englishPastSound, String englishPastParticipleValue, String englishPastParticiplePronunciation, String englishPastParticipleSound, String spanishValue, String spanishPronunciation, String spanishSound, String otherValue, Integer order) {
        this.id = id;
        this.typeVerb = typeVerb;
        this.englishPresentValue = englishPresentValue;
        this.englishPresentPronunciation = englishPresentPronunciation;
        this.englishPresentSound = englishPresentSound;
        this.englishPastValue = englishPastValue;
        this.englishPastPronunciation = englishPastPronunciation;
        this.englishPastSound = englishPastSound;
        this.englishPastParticipleValue = englishPastParticipleValue;
        this.englishPastParticiplePronunciation = englishPastParticiplePronunciation;
        this.englishPastParticipleSound = englishPastParticipleSound;
        this.spanishValue = spanishValue;
        this.spanishPronunciation = spanishPronunciation;
        this.spanishSound = spanishSound;
        this.otherValue = otherValue;
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

    public String getTypeVerb() {
        return typeVerb;
    }

    public void setTypeVerb(String typeVerb) {
        this.typeVerb = typeVerb;
    }

    public String getEnglishPresentValue() {
        return englishPresentValue;
    }

    public void setEnglishPresentValue(String englishPresentValue) {
        this.englishPresentValue = englishPresentValue;
    }

    public String getEnglishPresentPronunciation() {
        return englishPresentPronunciation;
    }

    public void setEnglishPresentPronunciation(String englishPresentPronunciation) {
        this.englishPresentPronunciation = englishPresentPronunciation;
    }

    public String getEnglishPresentSound() {
        return englishPresentSound;
    }

    public void setEnglishPresentSound(String englishPresentSound) {
        this.englishPresentSound = englishPresentSound;
    }

    public String getEnglishPastValue() {
        return englishPastValue;
    }

    public void setEnglishPastValue(String englishPastValue) {
        this.englishPastValue = englishPastValue;
    }

    public String getEnglishPastPronunciation() {
        return englishPastPronunciation;
    }

    public void setEnglishPastPronunciation(String englishPastPronunciation) {
        this.englishPastPronunciation = englishPastPronunciation;
    }

    public String getEnglishPastSound() {
        return englishPastSound;
    }

    public void setEnglishPastSound(String englishPastSound) {
        this.englishPastSound = englishPastSound;
    }

    public String getEnglishPastParticipleValue() {
        return englishPastParticipleValue;
    }

    public void setEnglishPastParticipleValue(String englishPastParticipleValue) {
        this.englishPastParticipleValue = englishPastParticipleValue;
    }

    public String getEnglishPastParticiplePronunciation() {
        return englishPastParticiplePronunciation;
    }

    public void setEnglishPastParticiplePronunciation(String englishPastParticiplePronunciation) {
        this.englishPastParticiplePronunciation = englishPastParticiplePronunciation;
    }

    public String getEnglishPastParticipleSound() {
        return englishPastParticipleSound;
    }

    public void setEnglishPastParticipleSound(String englishPastParticipleSound) {
        this.englishPastParticipleSound = englishPastParticipleSound;
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

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
    
}
