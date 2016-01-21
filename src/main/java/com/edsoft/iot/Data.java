package com.edsoft.iot;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by edsoft on 24.12.2015.
 */
public class Data implements Serializable {
    private int id;
    private int value;
    private String sensorType;
    private String date;
    private List<Long> timeList;

    public Data(String id, String value, String sensorType) {
        this.id = Integer.parseInt(id);
        this.value = Integer.parseInt(value);
        this.sensorType = sensorType;
        this.date = new SimpleDateFormat("MMM dd yyyy HH:mm:ss").format(new Date());
        timeList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Long> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<Long> timeList) {
        this.timeList = timeList;
    }

    public void addTime() {
        timeList.add(System.nanoTime());
    }

    @Override
    public String toString() {
        return getId() + "\t" + getValue() + "\t" + getDate() + "\t" + getSensorType();
    }
}
