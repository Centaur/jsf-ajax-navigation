package com.gtan.ee;

import org.omnifaces.util.Beans;

import javax.faces.component.UIComponent;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * Created by xf on 15/3/3.
 */
public class RememberOldLinkId implements PhaseListener{
    @Override
    public void afterPhase(PhaseEvent event) {
        Hello bean = Beans.getReference(Hello.class);
        String currentPartial = bean.getCurrentPartial();
        if(currentPartial != null) {
            UIComponent currentComponent = event.getFacesContext().getViewRoot().findComponent(currentPartial);
            if (currentComponent != null) {
                String oldLinkId = currentComponent.getId();
                bean.setOldLinkId(oldLinkId);
            }
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }
}
