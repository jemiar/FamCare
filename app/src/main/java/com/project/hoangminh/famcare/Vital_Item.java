package com.project.hoangminh.famcare;

public class Vital_Item {
    private String label;
    private String value;
//    private String day;
//    private String time;
    private int iconId;

    public Vital_Item() {
    }

    public Vital_Item(String l, String v, int i) {
        label = l;
        value = v;
//        day = d;
//        time = t;
        iconId = i;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }

//    public String getDay() {
//        return day;
//    }
//
//    public String getTime() {
//        return time;
//    }

    public int getIconId() {
        return iconId;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setValue(String value) {
        this.value = value;
    }

//    public void setDay(String day) {
//        this.day = day;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }
}
