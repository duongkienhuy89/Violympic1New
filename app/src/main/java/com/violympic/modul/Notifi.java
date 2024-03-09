package com.violympic.modul;

import androidx.annotation.Keep;

@Keep
public class Notifi {
    public Notifi() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String title="";

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    String content="";
}
