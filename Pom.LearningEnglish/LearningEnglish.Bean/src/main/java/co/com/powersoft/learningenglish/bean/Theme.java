/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class Theme implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String name;
    private String description;
    private String keywords;
    private String icon;
    private boolean state;
    private Integer order;
    private Collection<Lesson> lessons;

    public Theme() {
    }

    public Theme(Integer id, String name, String description, String keywords, String icon, boolean state, Integer order) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.keywords = keywords;
        this.icon = icon;
        this.state = state;
        this.order = order;
    }

    public Theme(Integer id, String name, String description, String keywords, String icon, boolean state, Integer order, Collection<Lesson> lessons) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.keywords = keywords;
        this.icon = icon;
        this.state = state;
        this.order = order;
        this.lessons = lessons;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Collection<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Collection<Lesson> lessons) {
        this.lessons = lessons;
    }

    
    
}
