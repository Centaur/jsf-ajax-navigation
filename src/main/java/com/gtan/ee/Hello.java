package com.gtan.ee;



import org.omnifaces.util.Ajax;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;

@ManagedBean
@ViewScoped
public class Hello {
    private String[] partials = new String[]{"partial1.xhtml", "partial2.xhtml", "partial3.xhtml"};
    private String oldLinkId;
    public String[] getPartials() {
        return partials;
    }
    private String currentPartial;
    public void setCurrentPartial(String currentPartial) {
        oldLinkId = UIComponent.getCurrentComponent(FacesContext.getCurrentInstance()).getClientId();
        this.currentPartial = currentPartial;
    }
    public String getCurrentPartial() {
        return currentPartial;
    }
    public void renderOldLink(AjaxBehaviorEvent event){
        if(oldLinkId != null)
            Ajax.update(oldLinkId);
    }
}
