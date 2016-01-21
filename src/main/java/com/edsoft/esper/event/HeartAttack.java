package com.edsoft.esper.event;

/**
 * Created by edsoft on 13.01.2016.
 */
public class HeartAttack {

    private int ahVal;
    private long fC;

    public HeartAttack(int ahVal, long fC) {
        this.ahVal = ahVal;
        this.fC = fC;
    }

    public int getAhVal() {
        return ahVal;
    }

    public void setAhVal(int ahVal) {
        this.ahVal = ahVal;
    }

    public long getfC() {
        return fC;
    }

    public void setfC(long fC) {
        this.fC = fC;
    }
}
