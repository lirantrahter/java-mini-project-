package Q2;

public class ServiceChargeChecking extends CheckingAccount{

	final int MONTHLY_FEE = 100;
	private double monthlyFee;
	
	//Represents a binding current account with a monthly fee with a fixed fee
	public ServiceChargeChecking(String accountNumber, String nameAccountOwner, String id, double balance) {
		super(accountNumber, nameAccountOwner, id, balance);
		monthlyFee = MONTHLY_FEE;
	}
	
	//Represents a binding checking account with a monthly fee with a fee provided by the user
	public ServiceChargeChecking(String accountNumber, String nameAccountOwner, String id, double balance,double monthlyFee) {
		super(accountNumber, nameAccountOwner, id, balance);
		this.monthlyFee = monthlyFee;
	}
	
	//Returns the monthly fee
	public double getMonthlyFee() {
		return monthlyFee;
	}
	
	//Changes the monthly fee
	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}
	
	//Monthly management of the account, subtracts the commission from the money in the account
	public void monthlyManagement() throws IllegalBalance {
		withdrawal(monthlyFee);
	}
	
	//Prints the account details if the monthly fee
	public String toString() {
		return super.toString() + "\n" + "monthly Fee: " + monthlyFee;
	}

	//Comparison of accounts receivable with commission
	public boolean equals(Object obj) {
		if (!(obj instanceof ServiceChargeChecking)) {
			return false;
		}
		return this.equals(obj) && monthlyFee == ((ServiceChargeChecking) obj).monthlyFee;

	}
}
