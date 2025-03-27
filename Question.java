package models;

import java.io.Serializable;


public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String text;

    public Question(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Question ID: " + id + ", Text: " + text;
    }
}