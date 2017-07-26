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
@Table(name = "vocabulary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vocabulary.findAll", query = "SELECT v FROM Vocabulary v")
    , @NamedQuery(name = "Vocabulary.findByVoId", query = "SELECT v FROM Vocabulary v WHERE v.voId = :voId")
    , @NamedQuery(name = "Vocabulary.findByVoEnglishValue", query = "SELECT v FROM Vocabulary v WHERE v.voEnglishValue = :voEnglishValue")
    , @NamedQuery(name = "Vocabulary.findByVoEnglishPronunciation", query = "SELECT v FROM Vocabulary v WHERE v.voEnglishPronunciation = :voEnglishPronunciation")
    , @NamedQuery(name = "Vocabulary.findByVoEnglishSound", query = "SELECT v FROM Vocabulary v WHERE v.voEnglishSound = :voEnglishSound")
    , @NamedQuery(name = "Vocabulary.findByVoSpanishValue", query = "SELECT v FROM Vocabulary v WHERE v.voSpanishValue = :voSpanishValue")
    , @NamedQuery(name = "Vocabulary.findByVoSpanishPronunciation", query = "SELECT v FROM Vocabulary v WHERE v.voSpanishPronunciation = :voSpanishPronunciation")
    , @NamedQuery(name = "Vocabulary.findByVoSpanishSound", query = "SELECT v FROM Vocabulary v WHERE v.voSpanishSound = :voSpanishSound")
    , @NamedQuery(name = "Vocabulary.findByVoOtherValue", query = "SELECT v FROM Vocabulary v WHERE v.voOtherValue = :voOtherValue")
    , @NamedQuery(name = "Vocabulary.findByVoImg", query = "SELECT v FROM Vocabulary v WHERE v.voImg = :voImg")
    , @NamedQuery(name = "Vocabulary.findByVoOrder", query = "SELECT v FROM Vocabulary v WHERE v.voOrder = :voOrder")
    , @NamedQuery(name = "Vocabulary.findVocabularyFromLesson", query = "SELECT v FROM Vocabulary v WHERE v.voIdLesson = :voIdLesson")})
public class Vocabulary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vo_id")
    private Integer voId;
    @Column(name = "vo_english_value")
    private String voEnglishValue;
    @Column(name = "vo_english_pronunciation")
    private String voEnglishPronunciation;
    @Column(name = "vo_english_sound")
    private String voEnglishSound;
    @Column(name = "vo_spanish_value")
    private String voSpanishValue;
    @Column(name = "vo_spanish_pronunciation")
    private String voSpanishPronunciation;
    @Column(name = "vo_spanish_sound")
    private String voSpanishSound;
    @Column(name = "vo_other_value")
    private String voOtherValue;
    @Column(name = "vo_img")
    private String voImg;
    @Column(name = "vo_order")
    private Integer voOrder;
    @JoinColumn(name = "vo_id_lesson", referencedColumnName = "le_id")
    @ManyToOne
    private Lesson voIdLesson;

    public Vocabulary() {
    }

    public Vocabulary(Integer voId) {
        this.voId = voId;
    }

    public Integer getVoId() {
        return voId;
    }

    public void setVoId(Integer voId) {
        this.voId = voId;
    }

    public String getVoEnglishValue() {
        return voEnglishValue;
    }

    public void setVoEnglishValue(String voEnglishValue) {
        this.voEnglishValue = voEnglishValue;
    }

    public String getVoEnglishPronunciation() {
        return voEnglishPronunciation;
    }

    public void setVoEnglishPronunciation(String voEnglishPronunciation) {
        this.voEnglishPronunciation = voEnglishPronunciation;
    }

    public String getVoEnglishSound() {
        return voEnglishSound;
    }

    public void setVoEnglishSound(String voEnglishSound) {
        this.voEnglishSound = voEnglishSound;
    }

    public String getVoSpanishValue() {
        return voSpanishValue;
    }

    public void setVoSpanishValue(String voSpanishValue) {
        this.voSpanishValue = voSpanishValue;
    }

    public String getVoSpanishPronunciation() {
        return voSpanishPronunciation;
    }

    public void setVoSpanishPronunciation(String voSpanishPronunciation) {
        this.voSpanishPronunciation = voSpanishPronunciation;
    }

    public String getVoSpanishSound() {
        return voSpanishSound;
    }

    public void setVoSpanishSound(String voSpanishSound) {
        this.voSpanishSound = voSpanishSound;
    }

    public String getVoOtherValue() {
        return voOtherValue;
    }

    public void setVoOtherValue(String voOtherValue) {
        this.voOtherValue = voOtherValue;
    }

    public String getVoImg() {
        return voImg;
    }

    public void setVoImg(String voImg) {
        this.voImg = voImg;
    }

    public Integer getVoOrder() {
        return voOrder;
    }

    public void setVoOrder(Integer voOrder) {
        this.voOrder = voOrder;
    }

    public Lesson getVoIdLesson() {
        return voIdLesson;
    }

    public void setVoIdLesson(Lesson voIdLesson) {
        this.voIdLesson = voIdLesson;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (voId != null ? voId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vocabulary)) {
            return false;
        }
        Vocabulary other = (Vocabulary) object;
        if ((this.voId == null && other.voId != null) || (this.voId != null && !this.voId.equals(other.voId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.powersoft.learningenglish.querymanager.entity.Vocabulary[ voId=" + voId + " ]";
    }
    
}
