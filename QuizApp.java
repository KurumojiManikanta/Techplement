import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuizManager quizManager = new QuizManager();

        while (true) {
            System.out.println("\n📌 Quiz Generator Menu");
            System.out.println("1. Create a Quiz");
            System.out.println("2. Take a Quiz");
            System.out.println("3. View All Quizzes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    quizManager.createQuiz(scanner);
                    break;
                case 2:
                    quizManager.takeQuiz(scanner);
                    break;
                case 3:
                    quizManager.viewQuizzes();
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
