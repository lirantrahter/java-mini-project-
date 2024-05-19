package Q2;

public class InterstChecking extends NoServiceChargeChecking {
		
	final double BIGGER_MINIMUM_WITHDRAWAL = 150;
	final double INTEREST = 0.1;
	private double interest;
	
	//represents the current account bearing interest. Such an account is an account without a monthly fee with a higher minimum balance, if a fixed minimum
	public InterstChecking(String accountNumber, String nameAccountOwner, String id, double balance) {
		super(accountNumber, nameAccountOwner, id, balance);
		setMinimumWithdrawal(BIGGER_MINIMUM_WITHDRAWAL);
		interest = INTEREST;
	}
	
	//represents the interest-bearing current account. Such an account is an account without a monthly fee with a higher minimum balance, if a minimum given by the user
	public InterstChecking(String accountNumber, String nameAccountOwner, String id, double balance, double interest, double minimumWithdrawal) {
		super(accountNumber, nameAccountOwner, id, balance);
		setMinimumWithdrawal(minimumWithdrawal);
		this.interest = interest;
	}
	
	//Returns the interest on the account
	public double getInterest() {
		return interest;
	}
	
	//Changes the interest the account has
	public void setInteresr(double interest) {
		this.interest = interest;
	}
	
	//The calculation of the interest payment is based on the interest rate multiplied by the amount in the account
	public double interestCalculation() {
		return  getBalance() * interest;
	}
	
	//Manages the monthly calculation according to the interest that can be calculated
	public void monthlyManagement()  throws IllegalBalance {
		deposit(interestCalculation());
		
	}
	
	//Prints the current account bearing interest if the interest rate
	public String toString() {
		return super.toString() + "\n" + "interest is: " + interest;
	}

	//Compares between accounts if interest
	public boolean equals(Object obj) {
		if (!(obj instanceof InterstChecking)) {
			return false;
		}
		return this.equals(obj) && interest == ((InterstChecking) obj).interest;
	}
}
