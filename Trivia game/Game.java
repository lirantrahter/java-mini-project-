package Q1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {

	final int NUM_OF_QUESTION = 10;
	final int MAX_SCORE = 100;
	private double score;
	private int currentQuestionNum;

	// The question and answer database
	private Question question1 = new Question("What is the capital of Japan?",
			new ArrayList<>(List.of("Tokyo", "Beijing", "Seoul", "Bangkok")));
	private Question question2 = new Question("Who wrote the play \"Romeo and Juliet\"?",
			new ArrayList<>(List.of("William Shakespeare", "Charles Dickens", "Jane Austen", "Mark Twain")));
	private Question question3 = new Question("What is the largest mammal in the world?",
			new ArrayList<>(List.of("Blue Whale", "Elephant", "Giraffe", "Gorilla")));
	private Question question4 = new Question("Which planet is known as the \"Morning Star\"?",
			new ArrayList<>(List.of("Venus", "Mars", "Jupiter", "Saturn")));
	private Question question5 = new Question("What is the currency of Brazil?",
			new ArrayList<>(List.of("Real", "Peso", "Euro", "Yen")));
	private Question question6 = new Question("In which year did Christopher Columbus first reach the Americas?",
			new ArrayList<>(List.of("1492", "1607", "1776", "1812")));
	private Question question7 = new Question("What is the chemical symbol for gold?",
			new ArrayList<>(List.of("Au", "Gd", "Ag", "Fe")));
	private Question question8 = new Question("Who painted the Mona Lisa?",
			new ArrayList<>(List.of("Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Michelangelo")));
	private Question question9 = new Question("What is the main ingredient in guacamole?",
			new ArrayList<>(List.of("Avocado", "Tomato", "Onion", "Garlic")));
	private Question question10 = new Question("Which country is known as the \"Land of the Rising Sun\"?",
			new ArrayList<>(List.of("Japan", "China", "South Korea", "Vietnam")));
	private ArrayList<Question> question = new ArrayList<>(Arrays.asList(question1, question2, question3, question4,
			question5, question6, question7, question8, question9, question10));

	// starts the game
	public Game() {
		currentQuestionNum = 0;
		score = 0;
		Collections.shuffle(question);
	}

	// Returns the question
	public String getQuestion() {
		return question.get(currentQuestionNum).getQuestion();
	}

	// Returns the possible answers
	public ArrayList<String> getPossibleAnswers() {
		return question.get(currentQuestionNum).getAnswers();
	}

	// Brings us to the next question
	public void nextQuestion() {
		currentQuestionNum++;

	}

	// Returns the number of questions we got right
	public int getCurrentQuestionNum() {
		return currentQuestionNum + 1;
	}

	// Returns the score we have accumulated
	public double getScore() {
		return score;
	}

	// Returns the correct answer
	public String getCorrectAnswer() {
		return question.get(currentQuestionNum).getCorrectAnswer();
	}

	// gets an answer and returns if it was correct or not, and adds score
	public boolean submitAnswer(String answer) {
		if (answer.equals(getCorrectAnswer())) {
			score += (double) MAX_SCORE / NUM_OF_QUESTION;
			return true;
		}
		return false;
	}

	// restarts the game
	public void restart() {
		score = 0;
		currentQuestionNum = 0;
		Collections.shuffle(question);
	}

	// Returns true if we have finished the game otherwise false
	public boolean endGame() {
		return this.currentQuestionNum >= NUM_OF_QUESTION;
	}
}
