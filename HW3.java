package main;

import models.Answers;
import models.Questions;
import models.Answer;
import java.util.List;

/**
 * Automated Testing Mainline for Question and Answer System.
 * 
 * Implements five specific test cases for HW3 assignment:
 * 1. Adding a question with normal input
 * 2. Adding a question with empty input
 * 3. Adding a question with special characters
 * 4. Adding a question with long input
 * 5. Adding and retrieving an answer
 * 
 * @author Abdullah Hilowle
 * @version 1.0
 */
public class HW3 {
    private static Questions questions = new Questions();
    private static Answers answers = new Answers();
    private static int numPassed = 0;
    private static int numFailed = 0;

    /**
     * Main method to execute all automated test cases.
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("HW3 Automated Testing Begin");
        System.out.println("---------------------------");

        // Execute the five specific test methods
        testAddQuestionNormalInput();
        testAddQuestionEmptyInput();
        testAddQuestionSpecialChars();
        testAddQuestionLongInput();
        testAddAndRetrieveAnswer();

        // Display test summary
        System.out.println("\nTest Summary:");
        System.out.println("Passed Tests: " + numPassed);
        System.out.println("Failed Tests: " + numFailed);
    }

    /**
     * Test adding a question with a normal, valid input.
     * 
     * Verifies that a standard question can be successfully added 
     * to the Questions collection.
     */
    public static void testAddQuestionNormalInput() {
        String testInput = "This is a normal question?";
        System.out.println("\nTest Case 1: Normal Question Input");
        
        int initialSize = questions.getAllQuestions().size();
        questions.addQuestion(testInput);
        int finalSize = questions.getAllQuestions().size();

        if (finalSize > initialSize && questions.getAllQuestions().get(finalSize - 1).getText().equals(testInput)) {
            System.out.println("PASSED: Normal question added successfully");
            numPassed++;
        } else {
            System.out.println("FAILED: Could not add normal question");
            numFailed++;
        }
    }

    /**
     * Test adding a question with an empty input.
     * 
     * Checks the system's behavior when attempting to add 
     * a question with an empty string.
     */
    public static void testAddQuestionEmptyInput() {
        String testInput = "";
        System.out.println("\nTest Case 2: Empty Question Input");
        
        int initialSize = questions.getAllQuestions().size();
        questions.addQuestion(testInput);
        int finalSize = questions.getAllQuestions().size();

        if (finalSize == initialSize) {
            System.out.println("PASSED: Empty question not added");
            numPassed++;
        } else {
            System.out.println("FAILED: Empty question unexpectedly added");
            numFailed++;
        }
    }

    /**
     * Test adding a question with special characters.
     * 
     * Evaluates the system's handling of a question 
     * containing only special characters.
     */
    public static void testAddQuestionSpecialChars() {
        String testInput = "><{}-";
        System.out.println("\nTest Case 3: Special Characters Question");
        
        int initialSize = questions.getAllQuestions().size();
        questions.addQuestion(testInput);
        int finalSize = questions.getAllQuestions().size();

        if (finalSize > initialSize && questions.getAllQuestions().get(finalSize - 1).getText().equals(testInput)) {
            System.out.println("PASSED: Special characters question added successfully");
            numPassed++;
        } else {
            System.out.println("FAILED: Could not add special characters question");
            numFailed++;
        }
    }

    /**
     * Test adding a question with a very long input.
     * 
     * Verifies the system's behavior when adding a question 
     * that approaches or exceeds typical length constraints.
     */
    public static void testAddQuestionLongInput() {
        String testInput = "A".repeat(800) + "?";
        System.out.println("\nTest Case 4: Long Question Input");
        
        int initialSize = questions.getAllQuestions().size();
        questions.addQuestion(testInput);
        int finalSize = questions.getAllQuestions().size();

        if (finalSize > initialSize && questions.getAllQuestions().get(finalSize - 1).getText().equals(testInput)) {
            System.out.println("PASSED: Long question added successfully");
            numPassed++;
        } else {
            System.out.println("FAILED: Could not add long question");
            numFailed++;
        }
    }

    /**
     * Test adding and retrieving an answer for a question.
     * 
     * Checks the ability to add an answer and successfully 
     * retrieve it for a specific question.
     */
    public static void testAddAndRetrieveAnswer() {
        System.out.println("\nTest Case 5: Add and Retrieve Answer");
        
        // First, ensure we have a question to answer
        questions.addQuestion("Test question for answer retrieval?");
        int questionId = questions.getAllQuestions().size() - 1;
        
        String testAnswerText = "This is a test answer.";
        answers.addAnswer(questionId, testAnswerText, false);
        
        List<Answer> retrievedAnswers = answers.getAnswersForQuestion(questionId);
        
        if (!retrievedAnswers.isEmpty() && 
            retrievedAnswers.stream().anyMatch(a -> a.getText().equals(testAnswerText))) {
            System.out.println("PASSED: Answer added and retrieved successfully");
            numPassed++;
        } else {
            System.out.println("FAILED: Could not add or retrieve answer");
            numFailed++;
        }
    }
}