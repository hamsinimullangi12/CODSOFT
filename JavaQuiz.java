import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class JavaQuiz {
    private static final int TOTAL_QUESTIONS = 10;
    private static int currentQuestion = 0;
    private static int score = 0;
    private static boolean[] userAnswers = new boolean[TOTAL_QUESTIONS];
    private static Timer timer = new Timer();
    private static boolean timerExpired = false;
    private static boolean quizStarted = false;

    private static String[] questions = {
            "1. What is the capital of Java?",
            "2. Which keyword is used for inheritance in Java?",
            "3. What is the output of 'System.out.println(5 + 7 + \"Java\")'?",
            "4. How do you declare an array in Java?",
            "5. What is the purpose of the 'super' keyword in Java?",
            "6. What is the default value of a local variable in Java?",
            "7. What is the purpose of the 'finally' block in a try-catch-finally statement?",
            "8. What is the difference between '==' and '.equals()' for comparing strings in Java?",
            "9. What is the main difference between an interface and an abstract class in Java?",
            "10. How can you achieve multiple inheritance in Java?"
    };

    private static String[][] options = {
            {"A. Jakarta", "B. Bandung", "C. Surabaya", "D. Yogyakarta"},
            {"A. extends", "B. inherits", "C. implements", "D. derives"},
            {"A. 12Java", "B. 5Java", "C. 12", "D. 57Java"},
            {"A. int[] array = new int[5];", "B. array[] = new int[5];", "C. int array[5];", "D. int array[] = new int[];"},
            {"A. To call the superclass constructor.", "B. To access the superclass methods and fields.", "C. To refer to the current object.", "D. To invoke the static method of the superclass."},
            {"A. 0", "B. 1", "C. Garbage value", "D. Compilation error"},
            {"A. It always executes, regardless of whether an exception is thrown or not.", "B. It is used to handle exceptions.", "C. It is executed if an exception is thrown.", "D. It is used to specify the resources that need to be closed."},
            {"A. '==' compares the memory address, while '.equals()' compares the actual content.", "B. '==' is used for primitive types, and '.equals()' is used for objects.", "C. They are entirely interchangeable.", "D. '==' is used for objects, and '.equals()' is used for primitive types."},
            {"A. An interface can have concrete methods, while an abstract class cannot.", "B. An abstract class can have constructors, while an interface cannot.", "C. An interface supports multiple inheritance, while an abstract class does not.", "D. An abstract class can have private methods, while an interface cannot."},
            {"A. By using the 'extends' keyword.", "B. By using the 'implements' keyword.", "C. Java does not support multiple inheritance.", "D. By using the 'extends' and 'implements' keywords."}
    };

    private static char[] correctAnswers = {'A', 'A', 'C', 'A', 'B', 'D', 'A', 'A', 'C', 'D'};

    public static void main(String[] args) {
        startQuiz();
    }

    private static void startQuiz() {
        if (!quizStarted) {
            System.out.println("Welcome to the Java Quiz!\n");
            quizStarted = true;
        }
        displayNextQuestion();
    }

    private static void displayNextQuestion() {
        if (currentQuestion < TOTAL_QUESTIONS) {
            System.out.println(questions[currentQuestion]);
            for (String option : options[currentQuestion]) {
                System.out.println(option);
            }
            System.out.print("Your choice: ");

            Scanner scanner = new Scanner(System.in);
            char userChoice = Character.toUpperCase(scanner.next().charAt(0));

            if (!timerExpired) {
                checkAnswer(userChoice);
            }

            timerExpired = false;
            currentQuestion++;
            startQuiz();
        } else {
            endQuiz();
        }
    }

    private static void checkAnswer(char userChoice) {
        char correctAnswer = correctAnswers[currentQuestion];
        boolean isCorrect = (userChoice == correctAnswer);
        userAnswers[currentQuestion] = isCorrect;
        if (isCorrect) {
            score++;
            System.out.println("Correct!\n");
        } else {
            System.out.println("Incorrect. The correct answer is " + correctAnswer + ".\n");
        }
    }

    private static void endQuiz() {
        timer.cancel();
        System.out.println("Quiz completed! Here are your results:");

        for (int i = 0; i < TOTAL_QUESTIONS; i++) {
            System.out.println(questions[i]);
            System.out.println("Your answer: " + options[i][correctAnswers[i] - 'A']);
            System.out.println("Correct answer: " + options[i][correctAnswers[i] - 'A']);
            System.out.println("Result: " + (userAnswers[i] ? "Correct" : "Incorrect"));
            System.out.println();
        }

        System.out.println("Your final score: " + score + " out of " + TOTAL_QUESTIONS);
    }
}
