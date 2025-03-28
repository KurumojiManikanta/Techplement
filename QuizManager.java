import java.util.ArrayList;
import java.util.Scanner;

class QuizManager {
    private ArrayList<Quiz> quizzes = new ArrayList<>();

    public void createQuiz(Scanner scanner) {
        System.out.print("\nEnter quiz name: ");
        String quizName = scanner.nextLine();
        Quiz quiz = new Quiz(quizName);

        while (true) {
            System.out.print("\nEnter question: ");
            String questionText = scanner.nextLine();
            String[] options = new String[4];

            for (int i = 0; i < 4; i++) {
                System.out.print("Option " + (char)('A' + i) + ": ");
                options[i] = scanner.nextLine();
            }

            System.out.print("Enter correct answer (A, B, C, D): ");
            char correctAnswer = scanner.next().toUpperCase().charAt(0);
            scanner.nextLine(); // Consume newline

            quiz.addQuestion(new Question(questionText, options, correctAnswer));

            System.out.print("Add another question? (yes/no): ");
            if (!scanner.nextLine().equalsIgnoreCase("yes")) {
                break;
            }
        }
        
        quizzes.add(quiz);
        System.out.println("✅ Quiz '" + quizName + "' created successfully!");
    }

    public void takeQuiz(Scanner scanner) {
        if (quizzes.isEmpty()) {
            System.out.println("No quizzes available! Create a quiz first.");
            return;
        }

        System.out.println("\nAvailable Quizzes:");
        for (int i = 0; i < quizzes.size(); i++) {
            System.out.println((i + 1) + ". " + quizzes.get(i).getQuizName());
        }

        System.out.print("Enter the quiz number: ");
        int quizIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (quizIndex >= 0 && quizIndex < quizzes.size()) {
            quizzes.get(quizIndex).start(scanner);
        } else {
            System.out.println("Invalid quiz number!");
        }
    }

    public void viewQuizzes() {
        if (quizzes.isEmpty()) {
            System.out.println("No quizzes available!");
        } else {
            System.out.println("\n📜 List of Quizzes:");
            for (Quiz quiz : quizzes) {
                System.out.println("- " + quiz.getQuizName());
            }
        }
    }
}
