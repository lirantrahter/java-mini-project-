package Q1;

import java.util.ArrayList;
import java.util.Collections;

public class Question {
	private String question;
	private ArrayList<String> possibleAnswers;
	private String correctAnswer;

	public Question(String question, ArrayList<String> answers) {
		this.question = question;
		this.possibleAnswers = answers;
		this.correctAnswer = answers.get(0);// the first answer is always the correct one
	}

	// return the question
	public String getQuestion() {
		return this.question;
	}

	// return the answers
	public ArrayList<String> getAnswers() {
		Collections.shuffle(this.possibleAnswers);
		return this.possibleAnswers;
	}

	// return the correct answer
	public String getCorrectAnswer() {
		return this.correctAnswer;
	}
}
