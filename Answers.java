package models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Answers implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Answer> answers = new ArrayList<>();
    private int nextId = 1;
    private static final String FILE_NAME = "answers.ser";

    public Answers() {
        loadAnswers();
    }

    public void addAnswer(int questionId, String text, boolean isCorrect) {
        if (text == null || text.trim().isEmpty()) {
            System.out.println("Error: Answer text cannot be empty.");
            return;
        }
        answers.add(new Answer(nextId++, questionId, text, isCorrect));
        saveAnswers();
    }

    public List<Answer> getAnswersForQuestion(int questionId) {
        return answers.stream().filter(a -> a.getQuestionId() == questionId).toList();
    }

    private void saveAnswers() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(answers);
        } catch (IOException e) {
            System.out.println("Error saving answers: " + e.getMessage());
        }
    }

    private void loadAnswers() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            answers = (List<Answer>) in.readObject();
            nextId = answers.size() + 1;
        } catch (FileNotFoundException e) {
            System.out.println("No previous answers found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading answers: " + e.getMessage());
        }
    }
}