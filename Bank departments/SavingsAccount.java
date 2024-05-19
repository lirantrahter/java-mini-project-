package Q2;

public class SavingsAccount extends BankAccount{
	
	final double INTEREST = 0.1;
	private double interest;
	
	//Represents an interest-bearing savings account, with a fixed interest rate
	public SavingsAccount(String accountNumber, String nameAccountOwner, String id, double balance) {
		super(accountNumber, nameAccountOwner, id, balance);
		interest = INTEREST;
	}
	
	//Represents an interest-bearing savings account, with interest given by the user
	public SavingsAccount(String accountNumber, String nameAccountOwner, String id, double balance, double interest) {
		super(accountNumber, nameAccountOwner, id, balance);
		this.interest = interest;
	}
	
	//Returns the account's interest
	public double getInterest() {
		return interest;
	}
	
	//Changes the interest rate of the account
	public void setInteresr(double interest) {
		this.interest = interest;
	}
	
	//Calculates the interest on the account by multiplying the interest rate by the amount of the account
	public double interestCalculation() {
		return  getBalance() * interest;
	}
	
	//Manages the monthly management including crediting the account according to the calculation of the interest
	public void monthlyManagement()  throws IllegalBalance {
		deposit(interestCalculation());
		
	}
	
	//Prints the account details including the interest rate
	public String toString() {
		return super.toString() + "\n" + "interest is: " + interest;
	}

	//Compares interest bearing savings account details
	public boolean equals(Object obj) {
		if (!(obj instanceof SavingsAccount)) {
			return false;
		}
		return this.equals(obj) && interest == ((SavingsAccount) obj).interest;
	}
}

	

