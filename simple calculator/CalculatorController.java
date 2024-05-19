package Q2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class CalculatorController {

	@FXML
	private Button add;

	@FXML
	private Button buttonDelete;

	@FXML
	private Button change;

	@FXML
	private Button comma;

	@FXML
	private Button divide;

	@FXML
	private Button eight;

	@FXML
	private Button equals;

	@FXML
	private Button five;

	@FXML
	private Button four;

	@FXML
	private Button multiply;

	@FXML
	private Button nine;

	@FXML
	private Button one;

	@FXML
	private Button seven;

	@FXML
	private Button six;

	@FXML
	private Button substract;

	@FXML
	private Button three;

	@FXML
	private Button two;

	@FXML
	private Button zero;
	@FXML
	private TextArea display;
	private Calculator calculator;

	public CalculatorController() {
		calculator = new Calculator();
	}

	@FXML
	void handleChangeSign(ActionEvent event) {
		calculator.changeSign();
		display.setText(calculator.getCurrentResult());
	}

	@FXML
	void handleComma(ActionEvent event) {
		calculator.comma();
		display.setText(calculator.getCurrentResult());
	}

	@FXML
	void handleDelete(ActionEvent event) {
		calculator.reset();
		display.setText(calculator.getCurrentResult());
	}

	@FXML
	void handleEquals(ActionEvent event) {
		calculator.equal();
		display.setText(calculator.getCurrentResult());
	}

	@FXML
	void handleKeyPress(KeyEvent event) {
		switch (event.getText()) {
		case "0":
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
			if(display.getText().equals("Do not divide by zero")) {display.setText("");}
			calculator.number(event.getText());
			;
			break;
		case "+":
			calculator.operation("add");
			break;
		case "-":
			calculator.operation("substract");
			break;
		case "/":
			calculator.operation("divide");
			break;
		case "*":
			calculator.operation("multiply");
			break;
		case ".":
			calculator.comma();
			break;
		case "+/-":
			calculator.changeSign();
			break;
		default:
			break;
		}
		display.setText(calculator.getCurrentResult());

	}

	@FXML
	void handleNum(ActionEvent event) {
		Button btn = (Button) event.getSource();
		calculator.number(btn.getText());
		display.setText(calculator.getCurrentResult());

	}

	@FXML
	void handleOperation(ActionEvent event) {
		Button btn = (Button) event.getSource();
		calculator.operation(btn.getId());
		display.setText(calculator.getCurrentResult());
	}

}
