package com.gtan.ee;



import org.omnifaces.util.Ajax;
import org.omnifaces.util.Components;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@ViewScoped
public class Hello {
    private List<String> partials = new ArrayList<>(Arrays.asList("partial1.xhtml", "partial2.xhtml"));
    private String oldParentId;

    public List<String> getPartials() {
        return partials;
    }
    private String currentPartial;
    public void appendPartial(String newPartial) {
        partials.add(newPartial);
    }
    public void setCurrentPartial(String currentPartial) {
        oldParentId = Components.getCurrentComponent().getParent().getClientId();
        this.currentPartial = currentPartial;
        Ajax.oncomplete("window.location.hash='"+ currentPartial +"'");
    }
    public String getCurrentPartial() {
        return currentPartial;
    }

    /**
     * actionListener runs before action
     * @param event
     */
    public void renderFragments(ActionEvent event){
        if(oldParentId != null)
            Ajax.update(oldParentId);
        UIComponent trigger = event.getComponent();
        Ajax.update(trigger.getParent().getClientId());
    }

}
