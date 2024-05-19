package Q1;

import java.util.ArrayList;

//Creating a polynomial and exporting the required commands
public class Polynom {
	private ArrayList<double[]> polynom = new ArrayList<>();

	// Creating the required polynomial when we are given two arrays of coefficient
	// and power
	public Polynom(double[] coefficient, int[] power) throws Exception {
		if (coefficient.length != power.length) {
			throw new Exception("\"Coefficient and power arrays must have the same length\"");
		}
		for (int i = 0; i < power.length; i++) {
			this.polynom.add(new double[] { coefficient[i], power[i] });
		}
		sortPolynomByPower();
		if (power.length == 0 && coefficient.length == 0) {
			this.polynom.add(new double[] { 0, 0 });
		}
	}

	// Generating the desired polynomial when we have a array list
	private Polynom(ArrayList<double[]> newPolynom) {
		polynom = newPolynom;
	}

	// Sort array by power
	private void sortPolynomByPower() {
		int n = polynom.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				double[] term1 = polynom.get(j);
				double[] term2 = polynom.get(j + 1);
				if (term1[1] < term2[1]) {
					// Swap the terms if they are out of order
					polynom.set(j, term2);
					polynom.set(j + 1, term1);
				}
			}
		}
		for (int i = 0; i < polynom.size() - 1; i++) {
			if (polynom.get(i)[1] == polynom.get(i + 1)[1]) {
				polynom.set(i, new double[] { polynom.get(i)[0] + polynom.get(i + 1)[0], polynom.get(i)[1] });
				polynom.remove(i + 1);

			}
		}
	}

	// Performing an addition operation on two polynomials
	public Polynom plus(Polynom other) {
		ArrayList<double[]> result = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < this.polynom.size() && j < other.polynom.size()) {
			if (this.polynom.get(i)[0] == 0) {
				i++;
				continue;
			}
			if (other.polynom.get(j)[0] == 0) {
				j++;
				continue;
			}
			if (this.polynom.get(i)[1] == other.polynom.get(j)[1]) {
				result.add(new double[] { this.polynom.get(i)[0] + other.polynom.get(j)[0], this.polynom.get(i)[1] });
				i++;
				j++;
				continue;
			}
			if (this.polynom.get(i)[1] < other.polynom.get(j)[1]) {
				result.add(new double[] { other.polynom.get(j)[0], other.polynom.get(j)[1] });
				j++;
				continue;
			}
			if (this.polynom.get(i)[1] > other.polynom.get(j)[1]) {
				result.add(new double[] { this.polynom.get(i)[0], this.polynom.get(i)[1] });
				i++;
			}
		}
		if (i != this.polynom.size()) {
			for (double[] mem : this.polynom) {
				result.add(mem);
			}
		} else if (j != other.polynom.size()) {
			for (double[] mem : other.polynom) {
				result.add(mem);

			}
		}
		return new Polynom(result);
	}

	// Performing a subtraction operation on two polynomials
	public Polynom minus(Polynom other) {
		ArrayList<double[]> minusOther = new ArrayList<>();
		for (double[] mem : other.polynom) {
			minusOther.add(new double[] { -1 * mem[0], mem[1] });
		}

		return this.plus(new Polynom(minusOther));
	}

	// Performing a derivation operation of a polynomial
	public Polynom derivative() {
		ArrayList<double[]> derivative = new ArrayList<>();
		for (double[] mem : this.polynom) {
			if (mem[1] != 0) {
				derivative.add(new double[] { mem[0] * mem[1], mem[1] - 1 });
			}
		}
		return new Polynom(derivative);
	}

	// Test if two polynomials are equal, if so return true otherwise false
	public boolean equals(Object obj) {
		if(!(obj instanceof Polynom)) {return false;}
		Polynom pol = this.minus((Polynom)obj);
		for (double[] mem : pol.polynom) {
			if (mem[0] != 0) {
				return false;
			}
		}
		return true;

	}

	// Performing a print operation
	public String toString() {
		String str = "";
		for (double[] mem : this.polynom) {
			if (mem[0] == 0) {
				continue;
			}
			if (str == "" && mem[1] > 1) {
				str += String.format("%.2f", mem[0]) + "x^" + String.valueOf((int) mem[1]);
			} else if (str == "" && mem[1] == 1) {
				str += String.format("%.2f", mem[0]) + "x";
			} else if ((str == "" && mem[1] == 0)) {
				str += String.format("%.2f", mem[0]);
			} else if (mem[0] > 0 && mem[1] > 1) {
				str += "+" + String.format("%.2f", mem[0]) + "x^" + String.valueOf((int) mem[1]);
			} else if (mem[0] > 0 && mem[1] == 1) {
				str += "+" + String.format("%.2f", mem[0]) + "x";
			} else if (mem[0] > 0 && mem[1] == 0) {
				str += "+" + String.format("%.2f", mem[0]);
			} else if (mem[0] < 0 && mem[1] > 1) {
				str += String.format("%.2f", mem[0]) + "x^" + String.valueOf((int) mem[1]);
			} else if (mem[0] < 0 && mem[1] == 1) {
				str += String.format("%.2f", mem[0]) + "x";
			} else if (mem[0] < 0 && mem[1] == 0) {
				str += String.format("%.2f", mem[0]);
			}

		}
		if (str.equals("")) {
			str = "0";
		}
		return str;
	}
}
