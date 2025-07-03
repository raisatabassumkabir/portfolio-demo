package bd.edu.seu.portfolio_with_sql.controller;

import java.util.Random;

public class CaptchaController {
    private int number1;
    private int number2;
    private String operator;
    private int correctAnswer;
    //56879800
    private final Random random = new Random();

    public String generateCaptchaQuestion() {
        number1 = random.nextInt(10) + 1;
        number2 = random.nextInt(10) + 1;
        operator = "+";
        correctAnswer = number1 + number2;


        return number1 + " " + operator + " " + number2 + " = ?";
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCaptchaCorrect(int userAnswer) {
        return userAnswer == correctAnswer;
    }
}
