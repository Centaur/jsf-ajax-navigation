package com.gtan.ee;



import org.omnifaces.util.Ajax;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@ViewScoped
public class Hello {
    private List<String> partials = new ArrayList<>(Arrays.asList("partial1.xhtml", "partial2.xhtml"));
    private String oldLinkId;
    public List<String> getPartials() {
        return partials;
    }
    private String currentPartial;
    public void appendPartial(String newPartial) {
        partials.add(newPartial);
    }
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
