package com.algaworks.erp.util;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author leand
 */
public class FacesMessages implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private void add(String message, FacesMessage.Severity severity) {
        FacesMessage facesMessage = new FacesMessage(message);
        facesMessage.setSeverity(severity);

        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }

    public void info(String message) {
        this.add(message, FacesMessage.SEVERITY_INFO);
    }
}
