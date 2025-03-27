package main;

import java.util.List;
import java.util.Scanner;


// If your classes are in the "models" package, add the following imports:
import models.Questions;
import models.Answers;
import models.Question;
import models.Answer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Questions questions = new Questions();
        Answers answers = new Answers();

        while (true) {
            System.out.println("\n1. Add Question\n2. View Questions\n3. Add Answer\n4. View Answers\n5. Exit");
            System.out.print("Enter choice: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter question text: ");
                    String text = scanner.nextLine();
                    questions.addQuestion(text);
                }
                case 2 -> {
                    var allQuestions = questions.getAllQuestions();
                    if (allQuestions.isEmpty()) {
                        System.out.println("No questions available.");
                    } else {
                        allQuestions.forEach(System.out::println);
                    }
                }
                case 3 -> {
                    System.out.print("Enter Question ID: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next();
                        continue;
                    }
                    int qId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Answer Text: ");
                    String ansText = scanner.nextLine();

                    System.out.print("Is Correct? (true/false): ");
                    if (!scanner.hasNextBoolean()) {
                        System.out.println("Invalid input. Please enter 'true' or 'false'.");
                        scanner.next();
                        continue;
                    }
                    boolean isCorrect = scanner.nextBoolean();
                    answers.addAnswer(qId, ansText, isCorrect);
                }
                case 4 -> {
                    System.out.print("Enter Question ID to view answers: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next();
                        continue;
                    }
                    int qId = scanner.nextInt();
                    var ansList = answers.getAnswersForQuestion(qId);
                    if (ansList.isEmpty()) {
                        System.out.println("No answers found for this question.");
                    } else {
                        ansList.forEach(System.out::println);
                    }
                }
                case 5 -> {
                    System.out.println("Exiting... Data has been saved.");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}