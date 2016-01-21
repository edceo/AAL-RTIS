package com.edsoft.esper.event;

/**
 * Created by edsoft on 14.01.2016.
 */
public class LowTemperature {

    private long c;

    public LowTemperature(long c) {
        this.c = c;
    }

    public long getC() {
        return c;
    }

    public void setC(long c) {
        this.c = c;
    }
}
