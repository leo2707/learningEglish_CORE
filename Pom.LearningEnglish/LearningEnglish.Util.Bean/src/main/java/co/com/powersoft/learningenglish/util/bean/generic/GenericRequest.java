/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.powersoft.learningenglish.util.bean.generic;

import java.io.Serializable;
import java.util.Date;


/**
 * Clase que contiene la informacion generica del request
 *
 * @author Leonardo Solano
 * @since 2017-04-16
 */
public class GenericRequest implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String requestId;
    private Date requestDate;
    private String appOrigin;
    private String ipOrigin;
    private String userId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getAppOrigin() {
        return appOrigin;
    }

    public void setAppOrigin(String appOrigin) {
        this.appOrigin = appOrigin;
    }

    public String getIpOrigin() {
        return ipOrigin;
    }

    public void setIpOrigin(String ipOrigin) {
        this.ipOrigin = ipOrigin;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
}
