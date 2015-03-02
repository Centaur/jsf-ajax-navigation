package com.gtan.ee;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class Hello {
    static Logger logger = Logger.getLogger(Hello.class.getName());

    String name = "xiefei";

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
}
