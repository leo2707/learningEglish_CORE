/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.querymanager.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leonardo
 */
@Entity
@Table(name = "verb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Verb.findAll", query = "SELECT v FROM Verb v")
    , @NamedQuery(name = "Verb.findByVeId", query = "SELECT v FROM Verb v WHERE v.veId = :veId")
    , @NamedQuery(name = "Verb.findByVeTypeVerb", query = "SELECT v FROM Verb v WHERE v.veTypeVerb = :veTypeVerb")
    , @NamedQuery(name = "Verb.findByVeEnglishPresentValue", query = "SELECT v FROM Verb v WHERE v.veEnglishPresentValue = :veEnglishPresentValue")
    , @NamedQuery(name = "Verb.findByVeEnglishPresentPronunciation", query = "SELECT v FROM Verb v WHERE v.veEnglishPresentPronunciation = :veEnglishPresentPronunciation")
    , @NamedQuery(name = "Verb.findByVeEnglishPresentSound", query = "SELECT v FROM Verb v WHERE v.veEnglishPresentSound = :veEnglishPresentSound")
    , @NamedQuery(name = "Verb.findByVeEnglishPastValue", query = "SELECT v FROM Verb v WHERE v.veEnglishPastValue = :veEnglishPastValue")
    , @NamedQuery(name = "Verb.findByVeEnglishPastPronunciation", query = "SELECT v FROM Verb v WHERE v.veEnglishPastPronunciation = :veEnglishPastPronunciation")
    , @NamedQuery(name = "Verb.findByVeEnglishPastSound", query = "SELECT v FROM Verb v WHERE v.veEnglishPastSound = :veEnglishPastSound")
    , @NamedQuery(name = "Verb.findByVeEnglishPastParticipleValue", query = "SELECT v FROM Verb v WHERE v.veEnglishPastParticipleValue = :veEnglishPastParticipleValue")
    , @NamedQuery(name = "Verb.findByVeEnglishPastParticiplePronunciation", query = "SELECT v FROM Verb v WHERE v.veEnglishPastParticiplePronunciation = :veEnglishPastParticiplePronunciation")
    , @NamedQuery(name = "Verb.findByVeEnglishPastParticipleSound", query = "SELECT v FROM Verb v WHERE v.veEnglishPastParticipleSound = :veEnglishPastParticipleSound")
    , @NamedQuery(name = "Verb.findByVeSpanishValue", query = "SELECT v FROM Verb v WHERE v.veSpanishValue = :veSpanishValue")
    , @NamedQuery(name = "Verb.findByVeSpanishPronunciation", query = "SELECT v FROM Verb v WHERE v.veSpanishPronunciation = :veSpanishPronunciation")
    , @NamedQuery(name = "Verb.findByVeSpanishSound", query = "SELECT v FROM Verb v WHERE v.veSpanishSound = :veSpanishSound")
    , @NamedQuery(name = "Verb.findByVeOtherValue", query = "SELECT v FROM Verb v WHERE v.veOtherValue = :veOtherValue")
    , @NamedQuery(name = "Verb.findByVeOrder", query = "SELECT v FROM Verb v WHERE v.veOrder = :veOrder")})
public class Verb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ve_id")
    private Integer veId;
    @Column(name = "ve_type_verb")
    private String veTypeVerb;
    @Column(name = "ve_english_present_value")
    private String veEnglishPresentValue;
    @Column(name = "ve_english_present_pronunciation")
    private String veEnglishPresentPronunciation;
    @Column(name = "ve_english_present_sound")
    private String veEnglishPresentSound;
    @Column(name = "ve_english_past_value")
    private String veEnglishPastValue;
    @Column(name = "ve_english_past_pronunciation")
    private String veEnglishPastPronunciation;
    @Column(name = "ve_english_past_sound")
    private String veEnglishPastSound;
    @Column(name = "ve_english_past_participle_value")
    private String veEnglishPastParticipleValue;
    @Column(name = "ve_english_past_participle_pronunciation")
    private String veEnglishPastParticiplePronunciation;
    @Column(name = "ve_english_past_participle_sound")
    private String veEnglishPastParticipleSound;
    @Column(name = "ve_spanish_value")
    private String veSpanishValue;
    @Column(name = "ve_spanish_pronunciation")
    private String veSpanishPronunciation;
    @Column(name = "ve_spanish_sound")
    private String veSpanishSound;
    @Column(name = "ve_other_value")
    private String veOtherValue;
    @Column(name = "ve_order")
    private Integer veOrder;
    @JoinColumn(name = "ve_id_lesson", referencedColumnName = "le_id")
    @ManyToOne
    private Lesson veIdLesson;

    public Verb() {
    }

    public Verb(Integer veId) {
        this.veId = veId;
    }

    public Integer getVeId() {
        return veId;
    }

    public void setVeId(Integer veId) {
        this.veId = veId;
    }

    public String getVeTypeVerb() {
        return veTypeVerb;
    }

    public void setVeTypeVerb(String veTypeVerb) {
        this.veTypeVerb = veTypeVerb;
    }

    public String getVeEnglishPresentValue() {
        return veEnglishPresentValue;
    }

    public void setVeEnglishPresentValue(String veEnglishPresentValue) {
        this.veEnglishPresentValue = veEnglishPresentValue;
    }

    public String getVeEnglishPresentPronunciation() {
        return veEnglishPresentPronunciation;
    }

    public void setVeEnglishPresentPronunciation(String veEnglishPresentPronunciation) {
        this.veEnglishPresentPronunciation = veEnglishPresentPronunciation;
    }

    public String getVeEnglishPresentSound() {
        return veEnglishPresentSound;
    }

    public void setVeEnglishPresentSound(String veEnglishPresentSound) {
        this.veEnglishPresentSound = veEnglishPresentSound;
    }

    public String getVeEnglishPastValue() {
        return veEnglishPastValue;
    }

    public void setVeEnglishPastValue(String veEnglishPastValue) {
        this.veEnglishPastValue = veEnglishPastValue;
    }

    public String getVeEnglishPastPronunciation() {
        return veEnglishPastPronunciation;
    }

    public void setVeEnglishPastPronunciation(String veEnglishPastPronunciation) {
        this.veEnglishPastPronunciation = veEnglishPastPronunciation;
    }

    public String getVeEnglishPastSound() {
        return veEnglishPastSound;
    }

    public void setVeEnglishPastSound(String veEnglishPastSound) {
        this.veEnglishPastSound = veEnglishPastSound;
    }

    public String getVeEnglishPastParticipleValue() {
        return veEnglishPastParticipleValue;
    }

    public void setVeEnglishPastParticipleValue(String veEnglishPastParticipleValue) {
        this.veEnglishPastParticipleValue = veEnglishPastParticipleValue;
    }

    public String getVeEnglishPastParticiplePronunciation() {
        return veEnglishPastParticiplePronunciation;
    }

    public void setVeEnglishPastParticiplePronunciation(String veEnglishPastParticiplePronunciation) {
        this.veEnglishPastParticiplePronunciation = veEnglishPastParticiplePronunciation;
    }

    public String getVeEnglishPastParticipleSound() {
        return veEnglishPastParticipleSound;
    }

    public void setVeEnglishPastParticipleSound(String veEnglishPastParticipleSound) {
        this.veEnglishPastParticipleSound = veEnglishPastParticipleSound;
    }

    public String getVeSpanishValue() {
        return veSpanishValue;
    }

    public void setVeSpanishValue(String veSpanishValue) {
        this.veSpanishValue = veSpanishValue;
    }

    public String getVeSpanishPronunciation() {
        return veSpanishPronunciation;
    }

    public void setVeSpanishPronunciation(String veSpanishPronunciation) {
        this.veSpanishPronunciation = veSpanishPronunciation;
    }

    public String getVeSpanishSound() {
        return veSpanishSound;
    }

    public void setVeSpanishSound(String veSpanishSound) {
        this.veSpanishSound = veSpanishSound;
    }

    public String getVeOtherValue() {
        return veOtherValue;
    }

    public void setVeOtherValue(String veOtherValue) {
        this.veOtherValue = veOtherValue;
    }

    public Integer getVeOrder() {
        return veOrder;
    }

    public void setVeOrder(Integer veOrder) {
        this.veOrder = veOrder;
    }

    public Lesson getVeIdLesson() {
        return veIdLesson;
    }

    public void setVeIdLesson(Lesson veIdLesson) {
        this.veIdLesson = veIdLesson;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (veId != null ? veId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Verb)) {
            return false;
        }
        Verb other = (Verb) object;
        if ((this.veId == null && other.veId != null) || (this.veId != null && !this.veId.equals(other.veId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.powersoft.learningenglish.querymanager.entity.Verb[ veId=" + veId + " ]";
    }
    
}
