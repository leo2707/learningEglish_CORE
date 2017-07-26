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
@Table(name = "theme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Theme.findAll", query = "SELECT t FROM Theme t")
    , @NamedQuery(name = "Theme.findByThId", query = "SELECT t FROM Theme t WHERE t.thId = :thId")
    , @NamedQuery(name = "Theme.findByThName", query = "SELECT t FROM Theme t WHERE t.thName = :thName")
    , @NamedQuery(name = "Theme.findByThDescription", query = "SELECT t FROM Theme t WHERE t.thDescription = :thDescription")
    , @NamedQuery(name = "Theme.findByThKeywords", query = "SELECT t FROM Theme t WHERE t.thKeywords = :thKeywords")
    , @NamedQuery(name = "Theme.findByThIcon", query = "SELECT t FROM Theme t WHERE t.thIcon = :thIcon")
    , @NamedQuery(name = "Theme.findByThState", query = "SELECT t FROM Theme t WHERE t.thState = :thState")
    , @NamedQuery(name = "Theme.findByThOrder", query = "SELECT t FROM Theme t WHERE t.thOrder = :thOrder")})
public class Theme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "th_id")
    private Integer thId;
    @Column(name = "th_name")
    private String thName;
    @Column(name = "th_description")
    private String thDescription;
    @Column(name = "th_keywords")
    private String thKeywords;
    @Column(name = "th_icon")
    private String thIcon;
    @Basic(optional = false)
    @Column(name = "th_state")
    private boolean thState;
    @Column(name = "th_order")
    private Integer thOrder;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "leIdTheme")
    private Collection<Lesson> lessonCollection;

    public Theme() {
    }

    public Theme(Integer thId) {
        this.thId = thId;
    }

    public Theme(Integer thId, boolean thState) {
        this.thId = thId;
        this.thState = thState;
    }

    public Integer getThId() {
        return thId;
    }

    public void setThId(Integer thId) {
        this.thId = thId;
    }

    public String getThName() {
        return thName;
    }

    public void setThName(String thName) {
        this.thName = thName;
    }

    public String getThDescription() {
        return thDescription;
    }

    public void setThDescription(String thDescription) {
        this.thDescription = thDescription;
    }

    public String getThKeywords() {
        return thKeywords;
    }

    public void setThKeywords(String thKeywords) {
        this.thKeywords = thKeywords;
    }

    public String getThIcon() {
        return thIcon;
    }

    public void setThIcon(String thIcon) {
        this.thIcon = thIcon;
    }

    public boolean getThState() {
        return thState;
    }

    public void setThState(boolean thState) {
        this.thState = thState;
    }

    public Integer getThOrder() {
        return thOrder;
    }

    public void setThOrder(Integer thOrder) {
        this.thOrder = thOrder;
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
        hash += (thId != null ? thId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theme)) {
            return false;
        }
        Theme other = (Theme) object;
        if ((this.thId == null && other.thId != null) || (this.thId != null && !this.thId.equals(other.thId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.powersoft.learningenglish.querymanager.entity.Theme[ thId=" + thId + " ]";
    }
    
}
