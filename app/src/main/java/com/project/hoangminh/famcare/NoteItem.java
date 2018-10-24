package com.project.hoangminh.famcare;

public class NoteItem {
    private String time;
    private String content;

    public NoteItem(String t, String c) {
        time = t;
        content = c;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
