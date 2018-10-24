package com.project.hoangminh.famcare;

public class Detail_Item {
    private String day;
    private String time;
    private String value;

    public Detail_Item() {
    }

    public Detail_Item(String d, String t, String v) {
        day = d;
        time = t;
        value = v;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getValue() {
        return value;
    }
}
