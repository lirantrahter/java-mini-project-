package Q1;

import java.util.ArrayList;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class GameController {

	@FXML
	private Text answerOne;
	@FXML
	private Text answerTwo;
	@FXML
	private Text answerThree;
	@FXML
	private Text answerFour;
	@FXML
	private Text question;
	@FXML
	private Text result;
	@FXML
	private Button btnOne;
	@FXML
	private Button btnTwo;
	@FXML
	private Button btnThree;
	@FXML
	private Button btnFour;
	@FXML
	private Button next;
	private Game game;
	private Text[] answersText;

	public GameController() {
		game = new Game();
	}

	@FXML
	private void initialize() {
		answersText = new Text[] { answerOne, answerTwo, answerThree, answerFour };
		result.setText("");
		loadQuestion();
	}

	private void loadQuestion() {
		question.setText("Question " + game.getCurrentQuestionNum() + ": " + game.getQuestion());
		ArrayList<String> answers = game.getPossibleAnswers();
		for (int i = 0; i < answersText.length; i++) {
			answersText[i].setText(answers.get(i));
			answersText[i].setFill(Color.BLACK);
		}
	}

	private void submitAnswer(String answer, Text ans) {
		if (game.submitAnswer(answer)) {
			result.setFill(Color.GREEN);
			result.setText("Correct!");
			ans.setFill(Color.GREEN);
		} else {
			result.setFill(Color.RED);
			result.setText("Wrong!\nThe correct answer is: " + game.getCorrectAnswer());
			ans.setFill(Color.RED);
		}
	}

	@FXML
	private void handleNext() {
		if (next.getText().equals("New Game?")) {
			restartGame();
			return;
		}
		if (game.getCurrentQuestionNum() == game.NUM_OF_QUESTION - 1) {
			next.setText("End Game");
		}

		game.nextQuestion();
		if (game.endGame()) {
			result.setFill(Color.BLACK);
			result.setText("Your result is: " + String.format("%.1f", game.getScore()));
			next.setText("New Game?");

			return;
		} else {
			loadQuestion();
			enableAnsBtns();
			result.setText("");
		}
	}

	@FXML
	private void handleAnswerClick(Event event) {
		Button btn = (Button) event.getSource();
		String id = btn.getId();
		switch (id) {
		case "btnOne":
			submitAnswer(answerOne.getText(), answerOne);
			break;
		case "btnTwo":
			submitAnswer(answerTwo.getText(), answerTwo);
			break;
		case "btnThree":
			submitAnswer(answerThree.getText(), answerThree);
			break;
		case "btnFour":
			submitAnswer(answerFour.getText(), answerFour);
			break;
		default:
			break;
		}
		disableAnsBtns();
	}

	// enables the answer buttons
	private void disableAnsBtns() {
		btnOne.setDisable(true);
		btnTwo.setDisable(true);
		btnThree.setDisable(true);
		btnFour.setDisable(true);
	}

	// disables the answer buttons
	private void enableAnsBtns() {
		btnOne.setDisable(false);
		btnTwo.setDisable(false);
		btnThree.setDisable(false);
		btnFour.setDisable(false);

	}

	// A new game starts
	private void restartGame() {
		game.restart();
		enableAnsBtns();
		next.setText("Next Question");
		result.setText("");
		loadQuestion();
	}
}
