/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.bean.model;

import co.com.powersoft.learningenglish.bean.Theme;
import co.com.powersoft.learningenglish.util.bean.generic.GenericResponse;
import java.io.Serializable;
import java.util.List;

/**
 * Object Response of the method [Theme - getAllThemes()]
 *
 * @author Leonardo Solano
 * @since 2016-11-27
 */
public class GetAllThemesRs extends GenericResponse implements Serializable{
    
    private List<Theme> themes;

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }    
    
}
