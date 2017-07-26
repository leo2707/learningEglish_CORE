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
public class Lesson implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String id;
    private Theme theme;
    private LessonType lessonType;
    private String name;
    private String description;
    private String icon;
    private Integer order;
    private String color;

    public Lesson() {
    }

    public Lesson(String id, String name, String description, String icon, Integer order) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.order = order;
    }

    public Lesson(String id, LessonType lessonType, String name, String description, String icon, Integer order) {
        this.id = id;
        this.lessonType = lessonType;
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public LessonType getLessonType() {
        return lessonType;
    }

    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
