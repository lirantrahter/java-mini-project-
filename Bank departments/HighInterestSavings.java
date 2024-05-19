package Q2;

public class HighInterestSavings extends SavingsAccount{

	final double MINIMUM_WITHDRAWAL = 150;
	private double minimumWithdrawal;
	final double BIGGEST_INTEREST = 0.2;
	private double biggestInterest;

	//represents a savings account with a minimum balance that carries a higher interest rate than the interest rate of a regular savings account, if the interest rate is fixed
	public HighInterestSavings(String accountNumber, String nameAccountOwner, String id, double balance) {
		super(accountNumber, nameAccountOwner, id, balance);
		minimumWithdrawal = MINIMUM_WITHDRAWAL;
		biggestInterest = BIGGEST_INTEREST;
	}
	
	//represents a savings account with a minimum balance that carries an interest rate higher than the interest rate of a regular savings account, if the interest rate provided by the user
	public HighInterestSavings(String accountNumber, String nameAccountOwner, String id, double balance, double minimumWithdrawal, double biggestInterest) {
		super(accountNumber, nameAccountOwner, id, balance);
		this.minimumWithdrawal = minimumWithdrawal;
		this.biggestInterest = biggestInterest;
	}
	
	//Returns the interest rate
	public double getBiggestInterest() {
		return biggestInterest;
	}
	
	//changes the interest rate
	public void setBiggestInterest(double biggestInterest) {
		this.biggestInterest = biggestInterest;
	}
	
	//Returns the minimum balance
	public double getminimumWithdrawal() {
		return minimumWithdrawal;
	}
	
	//Changes the minimum balance
	public void setminimumWithdrawal(double minimumWithdrawal) {
		this.minimumWithdrawal = minimumWithdrawal;
	}
	
	//Prints the account details
	public String toString() {
		return super.toString() + "\n" + "minimum withdrawal: " + minimumWithdrawal;
	}

	//Compares savings accounts with a minimum interest-bearing balance
	public boolean equals(Object obj) {
		if (!(obj instanceof HighInterestSavings)) {
			return false;
		}
		return this.equals(obj) && minimumWithdrawal == ((HighInterestSavings) obj).minimumWithdrawal;
	}
}
