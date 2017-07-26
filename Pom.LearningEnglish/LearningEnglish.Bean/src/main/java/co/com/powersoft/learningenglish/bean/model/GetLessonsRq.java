/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.bean.model;


import co.com.powersoft.learningenglish.util.bean.generic.GenericRequest;
import java.io.Serializable;

/**
 * Object Request of the method [Lesson - getLessons()]
 *
 * @author Leonardo Solano
 * @since 2017-01-12
 */
public class GetLessonsRq extends GenericRequest implements Serializable{
    
    private int themeId;

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }
    
    
}
