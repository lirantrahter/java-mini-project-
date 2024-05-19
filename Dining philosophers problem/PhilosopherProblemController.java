
package Q2;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PhilosopherProblemController {

	@FXML
	private Rectangle phil1;

	@FXML
	private Rectangle phil2;

	@FXML
	private Rectangle phil3;

	@FXML
	private Rectangle phil4;

	@FXML
	private Rectangle phil5;
	
	private final int NUM_PHILOSOPHERS = 5;

	public void initialize() {
		Rectangle[] phil = {phil1, phil2, phil3, phil4, phil5};
		phil1.setFill(Color.RED);
		phil2.setFill(Color.RED);
		phil3.setFill(Color.RED);
		phil4.setFill(Color.RED);
		phil5.setFill(Color.RED);

	     final Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
	        Object[] forks = new Object[NUM_PHILOSOPHERS];

	        for (int i = 0; i < forks.length; i++) {
	            forks[i] = new Object();
	        }

	        for (int i = 0; i < philosophers.length; i++) {
	            Object leftFork = forks[i];
	            Object rightFork = forks[(i + 1) % forks.length];

	            if (i == philosophers.length - 1) {
	                philosophers[i] = new Philosopher(rightFork, leftFork, phil[i]);
	            } else {
	                philosophers[i] = new Philosopher(leftFork, rightFork, phil[i]);
	            }

	            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
	            t.start();
	        }
	    }
	}
