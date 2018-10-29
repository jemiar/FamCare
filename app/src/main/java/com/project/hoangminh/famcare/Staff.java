package com.project.hoangminh.famcare;

public class Staff {

    private String name;
    private String pos;
    private int photo;

    public Staff(String n, String p, int pic) {
        name = n;
        pos = p;
        photo = pic;
    }

    public String getName() {
        return name;
    }

    public String getPos() {
        return pos;
    }

    public int getPhoto() {
        return photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }
}
