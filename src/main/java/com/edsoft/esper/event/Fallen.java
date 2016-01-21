package com.edsoft.esper.event;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edsoft on 13.01.2016.
 */
public class Fallen implements Serializable {
    private long c;
    private List<String> l;


    public Fallen(long c) {
l = new ArrayList<>();
        this.c = c;
    }

    public List<String> getL() {
        return l;
    }

    public void setL(List<String> l) {
        this.l = l;
    }

    public long getC() {
        return c;
    }

    public void setC(long c) {
        this.c = c;
    }
}
