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
import javax.persistence.Id;
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
@Table(name = "lesson_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LessonType.findAll", query = "SELECT l FROM LessonType l")
    , @NamedQuery(name = "LessonType.findByLtId", query = "SELECT l FROM LessonType l WHERE l.ltId = :ltId")
    , @NamedQuery(name = "LessonType.findByLtValue", query = "SELECT l FROM LessonType l WHERE l.ltValue = :ltValue")})
public class LessonType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "lt_id")
    private Integer ltId;
    @Column(name = "lt_value")
    private String ltValue;
    @OneToMany(mappedBy = "leIdLessonType")
    private Collection<Lesson> lessonCollection;

    public LessonType() {
    }

    public LessonType(Integer ltId) {
        this.ltId = ltId;
    }

    public Integer getLtId() {
        return ltId;
    }

    public void setLtId(Integer ltId) {
        this.ltId = ltId;
    }

    public String getLtValue() {
        return ltValue;
    }

    public void setLtValue(String ltValue) {
        this.ltValue = ltValue;
    }

    @XmlTransient
    public Collection<Lesson> getLessonCollection() {
        return lessonCollection;
    }

    public void setLessonCollection(Collection<Lesson> lessonCollection) {
        this.lessonCollection = lessonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ltId != null ? ltId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LessonType)) {
            return false;
        }
        LessonType other = (LessonType) object;
        if ((this.ltId == null && other.ltId != null) || (this.ltId != null && !this.ltId.equals(other.ltId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.powersoft.learningenglish.querymanager.entity.LessonType[ ltId=" + ltId + " ]";
    }
    
}
