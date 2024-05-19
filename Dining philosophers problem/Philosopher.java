package Q2;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Philosopher implements Runnable {

	// The forks on either side of this Philosopher
	private Object leftFork;
	private Object rightFork;
	private Rectangle phil;

	public Philosopher(Object leftFork, Object rightFork, Rectangle phil) {
		this.leftFork = leftFork;
		this.rightFork = rightFork;
		this.phil = phil;
	}

	private void doAction(String action) throws InterruptedException  {
		System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 5000)));


	}

	@Override
    public void run() {
        try {
            while (true) {
                // thinking
                doAction(": Thinking");
                phil.setFill(Color.GREEN);
    			//Thread.sleep(((int) (Math.random() * 1000)));
    			
                synchronized (leftFork) {
                    doAction(": Picked up left fork");
                    phil.setFill(Color.RED);
                    synchronized (rightFork) {
                        // eating

                        doAction(": Picked up right fork - eating");
                        phil.setFill(Color.BLUE);
            			
                        doAction(": Put down right fork");
            			phil.setFill(Color.GREEN);
                    }

                    // Back to thinking
                    doAction(": Put down left fork. Back to thinking");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
        
