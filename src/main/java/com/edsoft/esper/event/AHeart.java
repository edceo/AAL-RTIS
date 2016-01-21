package com.edsoft.esper.event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edsoft on 13.01.2016.
 */
public class AHeart {
    private int val;
    private List<Long> l;


    public AHeart(int value) {
        l = new ArrayList<>();
        this.val = value;
    }


    public int getVal() {
        return val;
    }

    public void setL(List<Long> l) {
        this.l = l;
    }

    public List<Long> getL() {
        return l;
    }

    public int getValue() {
        return val;
    }

    public void setValue(int value) {
        this.val = value;
    }

    public void addTime() {
        l.add(System.nanoTime());
    }


}
