package com.gtan.ee;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean
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
