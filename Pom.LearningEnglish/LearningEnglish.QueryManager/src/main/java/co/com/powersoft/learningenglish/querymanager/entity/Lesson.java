/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.querymanager.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Leonardo
 */
@Entity
@Table(name = "lesson")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lesson.findAll", query = "SELECT l FROM Lesson l")
    , @NamedQuery(name = "Lesson.findByLeId", query = "SELECT l FROM Lesson l WHERE l.leId = :leId")
    , @NamedQuery(name = "Lesson.findByLeName", query = "SELECT l FROM Lesson l WHERE l.leName = :leName")
    , @NamedQuery(name = "Lesson.findByLeDescription", query = "SELECT l FROM Lesson l WHERE l.leDescription = :leDescription")
    , @NamedQuery(name = "Lesson.findByLeIcon", query = "SELECT l FROM Lesson l WHERE l.leIcon = :leIcon")
    , @NamedQuery(name = "Lesson.findByLeState", query = "SELECT l FROM Lesson l WHERE l.leState = :leState")
    , @NamedQuery(name = "Lesson.findByLeOrder", query = "SELECT l FROM Lesson l WHERE l.leOrder = :leOrder")})
public class Lesson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "le_id")
    private String leId;
    @Column(name = "le_name")
    private String leName;
    @Column(name = "le_description")
    private String leDescription;
    @Column(name = "le_icon")
    private String leIcon;
    @Basic(optional = false)
    @Column(name = "le_state")
    private boolean leState;
    @Column(name = "le_order")
    private Integer leOrder;
    @OneToMany(mappedBy = "voIdLesson")
    private Collection<Vocabulary> vocabularyCollection;
    @JoinColumn(name = "le_id_lesson_type", referencedColumnName = "lt_id")
    @ManyToOne
    private LessonType leIdLessonType;
    @JoinColumn(name = "le_id_theme", referencedColumnName = "th_id")
    @ManyToOne
    private Theme leIdTheme;
    @OneToMany(mappedBy = "veIdLesson")
    private Collection<Verb> verbCollection;

    public Lesson() {
    }

    public Lesson(String leId) {
        this.leId = leId;
    }

    public Lesson(String leId, boolean leState) {
        this.leId = leId;
        this.leState = leState;
    }

    public String getLeId() {
        return leId;
    }

    public void setLeId(String leId) {
        this.leId = leId;
    }

    public String getLeName() {
        return leName;
    }

    public void setLeName(String leName) {
        this.leName = leName;
    }

    public String getLeDescription() {
        return leDescription;
    }

    public void setLeDescription(String leDescription) {
        this.leDescription = leDescription;
    }

    public String getLeIcon() {
        return leIcon;
    }

    public void setLeIcon(String leIcon) {
        this.leIcon = leIcon;
    }

    public boolean getLeState() {
        return leState;
    }

    public void setLeState(boolean leState) {
        this.leState = leState;
    }

    public Integer getLeOrder() {
        return leOrder;
    }

    public void setLeOrder(Integer leOrder) {
        this.leOrder = leOrder;
    }

    @XmlTransient
    public Collection<Vocabulary> getVocabularyCollection() {
        return vocabularyCollection;
    }

    public void setVocabularyCollection(Collection<Vocabulary> vocabularyCollection) {
        this.vocabularyCollection = vocabularyCollection;
    }

    public LessonType getLeIdLessonType() {
        return leIdLessonType;
    }

    public void setLeIdLessonType(LessonType leIdLessonType) {
        this.leIdLessonType = leIdLessonType;
    }

    public Theme getLeIdTheme() {
        return leIdTheme;
    }

    public void setLeIdTheme(Theme leIdTheme) {
        this.leIdTheme = leIdTheme;
    }

    @XmlTransient
    public Collection<Verb> getVerbCollection() {
        return verbCollection;
    }

    public void setVerbCollection(Collection<Verb> verbCollection) {
        this.verbCollection = verbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (leId != null ? leId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lesson)) {
            return false;
        }
        Lesson other = (Lesson) object;
        if ((this.leId == null && other.leId != null) || (this.leId != null && !this.leId.equals(other.leId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.powersoft.learningenglish.querymanager.entity.Lesson[ leId=" + leId + " ]";
    }
    
}
