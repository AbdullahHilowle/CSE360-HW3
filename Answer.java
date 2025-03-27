package models;

import java.io.Serializable;


public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private int questionId;
    private String text;
    private boolean isCorrect;

    public Answer(int id, int questionId, String text, boolean isCorrect) {
        this.id = id;
        this.questionId = questionId;
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public int getId() {
        return id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    @Override
    public String toString() {
        return "Answer ID: " + id + ", Question ID: " + questionId + ", Text: " + text + ", Correct: " + isCorrect;
    }
}