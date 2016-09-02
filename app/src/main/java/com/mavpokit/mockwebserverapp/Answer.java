package com.mavpokit.mockwebserverapp;

/**
 * Created by Alex on 30.08.2016.
 */
public class Answer {
    String link;
    String title;

    public Answer(String link, String title) {
        this.link = link;
        this.title = title;
    }

    @Override
    public String toString() {
        //return link+"\n"+title+"\n";
        return title;
    }
}

