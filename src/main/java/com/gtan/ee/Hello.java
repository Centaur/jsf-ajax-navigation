package com.gtan.ee;


import org.omnifaces.util.Components;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class Hello {
    static Logger logger = Logger.getLogger(Hello.class.getName());

    String name = "xiefei";

    private String[] partials = new String[]{"partial1.xhtml", "partial2.xhtml"};
    private String oldLinkId;


    public String getOldLinkId() {
        return oldLinkId;
    }

    public void setOldLinkId(String oldLinkId) {
        this.oldLinkId = oldLinkId;
    }

    public String[] getPartials() {
        return partials;
    }

    private String currentPartial = "partial1.xhtml";

    public String getName() {
        logger.fine("text get");
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void log() {
        logger.fine("text changed");
    }

    public void setCurrentPartial(String currentPartial) {
        this.currentPartial = currentPartial;
    }

    public String getCurrentPartial() {
        return currentPartial;
    }

    public void rememberOldLinkId(ComponentSystemEvent event) throws AbortProcessingException{
        oldLinkId = ((UIComponent)event.getSource()).getClientId();
    }
}
