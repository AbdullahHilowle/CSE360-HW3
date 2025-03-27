package models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Questions implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Question> questions = new ArrayList<>();
    private int nextId = 1;
    private static final String FILE_NAME = "questions.ser";

    public Questions() {
        loadQuestions();
    }

    public void addQuestion(String text) {
        if (text == null || text.trim().isEmpty()) {
            System.out.println("Error: Question text cannot be empty.");
            return;
        }
        questions.add(new Question(nextId++, text));
        saveQuestions();
    }

    public List<Question> getAllQuestions() {
        return questions;
    }

    private void saveQuestions() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(questions);
        } catch (IOException e) {
            System.out.println("Error saving questions: " + e.getMessage());
        }
    }

    private void loadQuestions() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            questions = (List<Question>) in.readObject();
            nextId = questions.size() + 1;
        } catch (FileNotFoundException e) {
            System.out.println("No previous questions found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading questions: " + e.getMessage());
        }
    }
}