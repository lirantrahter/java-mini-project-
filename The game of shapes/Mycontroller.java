package Q2;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

//Draws 10 shapes on the screen by pressing the button (10 different shapes each time)
public class Mycontroller {

	@FXML
	private Canvas canvas;
	private Random rnd = new Random();
	private final int NUMBRE_OF_SHAPES = 10;

	//The shapes that can be drawn
	private static enum Shape {
		RECTANGLE, OVAL, LINE
	}

	private static final Shape[] shapes = Shape.values();

	@FXML
	void btn(ActionEvent event) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		for (int i = 0; i < NUMBRE_OF_SHAPES; i++) {
			Color rndColor = new Color(rnd.nextDouble(), rnd.nextDouble(), rnd.nextDouble(), 1);//Random choice of color
			gc.setFill(rndColor);
			Shape shapeType = shapes[rnd.nextInt(shapes.length)];//Random selection of the shape
			
			// Drawing the shapes
			switch (shapeType) {
			case RECTANGLE:
				gc.fillRect(rnd.nextDouble() * canvas.getWidth(), rnd.nextDouble() * canvas.getHeight(),
						rnd.nextDouble() * canvas.getWidth() * 0.25, rnd.nextDouble() * canvas.getHeight() * 0.25);
				break;
			case OVAL:
				gc.fillOval(rnd.nextDouble() * canvas.getWidth(), rnd.nextDouble() * canvas.getHeight(),
						rnd.nextDouble() * canvas.getWidth() * 0.25, rnd.nextDouble() * canvas.getHeight() * 0.25);
				break;
			case LINE:
				gc.setStroke(rndColor);
				gc.strokeLine(rnd.nextDouble() * canvas.getWidth(), rnd.nextDouble() * canvas.getHeight(),
						rnd.nextDouble() * canvas.getWidth() + rnd.nextDouble() * canvas.getWidth() * 0.25,
						rnd.nextDouble() * canvas.getHeight() + rnd.nextDouble() * canvas.getHeight() * 0.25);
				break;
			default:
				break;
			}

		}
	}
}