import java.util.ArrayList;
import java.util.Scanner;

class Quiz {
    private String quizName;
    private ArrayList<Question> questions;

    public Quiz(String quizName) {
        this.quizName = quizName;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void start(Scanner scanner) {
        int score = 0;
        
        System.out.println("\n📝 Starting Quiz: " + quizName);
        for (Question q : questions) {
            System.out.println("\n" + q.getQuestion());
            for (String option : q.getOptions()) {
                System.out.println(option);
            }
            System.out.print("Your answer: ");
            char userAnswer = scanner.next().toUpperCase().charAt(0);

            if (userAnswer == q.getCorrectAnswer()) {
                score++;
            }
        }

        System.out.println("\n📊 Quiz Over! Your Score: " + score + "/" + questions.size());
        if (score == questions.size()) {
            System.out.println("🎉 Excellent! You got all answers correct!");
        } else if (score > 0) {
            System.out.println("👍 Good job! Try again for a perfect score.");
        } else {
            System.out.println("😢 Better luck next time!");
        }
    }

    public String getQuizName() {
        return quizName;
    }
}
