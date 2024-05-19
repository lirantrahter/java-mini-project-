package Q1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	// Running the program and recording the actions on the screen
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println(
				"Write down pairs of coefficient and power when there is a space between the numbers, to stop write down 'end':");
		Polynom p = input(scan);
		Polynom q = input(scan);
		scan.close();
		System.out.println("polynom P = " + p);
		System.out.println("polynom Q = " + q);
		System.out.println("P + Q = " + p.plus(q));
		System.out.println("P - Q = " + p.minus(q));
		System.out.println("Q - P = " + q.minus(p));
		System.out.println("The derivative of the polynomial P is: " + p.derivative());
		System.out.println("The derivative of the polynomial Q is: " + q.derivative());
		System.out.println("If polynomial P equal to polynomial Q ? " + q.equals(p));
	}

	/*
	 * Find the absorption of a new polynomial from the user when the method of
	 * registration is the power gain coefficient (for example to register the
	 * polynomial: 5x^2+2x+2 it is necessary to type: 5 2 2 1 2 0) To finish we will
	 * register "end"
	 */
	private static Polynom input(Scanner scan) throws Exception {
		ArrayList<double[]> polynomP = new ArrayList<>();
		String str = "";
		System.out.println("write the polynom :");
		while (true) {
			str = scan.nextLine();
			if (str.equals("end")) {
				break;
			}
			polynomP.add(new double[] { Double.valueOf(str.split(" ")[0]), Integer.valueOf(str.split(" ")[1]) });
		}
		double[] coefficientOfP = new double[polynomP.size()];
		int[] powerOfP = new int[polynomP.size()];
		int i = 0;
		for (double[] arr : polynomP) {
			coefficientOfP[i] = arr[0];
			powerOfP[i] = (int) arr[1];
			i++;
		}
		return new Polynom(coefficientOfP, powerOfP);

	}
}
