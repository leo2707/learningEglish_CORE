/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.bean.model;

import co.com.powersoft.learningenglish.bean.Verb;
import co.com.powersoft.learningenglish.util.bean.generic.GenericResponse;
import java.io.Serializable;
import java.util.List;

/**
 * Object Response of the method [Verb - getVerbs()]
 *
 * @author Leonardo Solano
 * @since 2017-01-15
 */
public class GetVerbsRs extends GenericResponse implements Serializable{
    
    private List<Verb> verbs;

    public List<Verb> getVerbs() {
        return verbs;
    }

    public void setVerbs(List<Verb> verbs) {
        this.verbs = verbs;
    }

    
    
}
