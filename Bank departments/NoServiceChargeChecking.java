package Q2;

public class NoServiceChargeChecking extends CheckingAccount {

	final double MINIMUM_WITHDRAWAL = 100;
	private double minimumWithdrawal;

	//represents a checking account without a monthly fee with a minimum balance below which no withdrawals can be made, if a fixed minimum withdrawal
	public NoServiceChargeChecking(String accountNumber, String nameAccountOwner, String id, double balance) {
		super(accountNumber, nameAccountOwner, id, balance);
		minimumWithdrawal = MINIMUM_WITHDRAWAL;
	}

	//represents a checking account without a monthly fee with a minimum balance below which no withdrawals can be made, if a minimum withdrawal set by the user
	public NoServiceChargeChecking(String accountNumber, String nameAccountOwner, String id, double balance,
			double minimumWithdrawal) {
		super(accountNumber, nameAccountOwner, id, balance);
		this.minimumWithdrawal = minimumWithdrawal;
	}

	//Returns the minimum balance
	public double getMinimumWithdrawal() {
		return minimumWithdrawal;
	}

	//Changes the minimum balance
	public void setMinimumWithdrawal(double minimumWithdrawal) {
		this.minimumWithdrawal = minimumWithdrawal;
	}

	//Makes a withdrawal from the account considering the minimum balance
	public void withdrawal(double money) throws IllegalBalance {
		if (getBalance() - money - minimumWithdrawal < 0) {
            throw new IllegalBalance("There is not enough bank account to do the operation");

		} else
			withdrawal(minimumWithdrawal);

	}

	@Override
	public void monthlyManagement()  throws Exception{}

	//Prints the account details with minimum balance
	public String toString() {
		return super.toString() + "\n" + "minimum withdrawal: " + minimumWithdrawal;
	}

	//Compares account details with minimum balance
	public boolean equals(Object obj) {
		if (!(obj instanceof NoServiceChargeChecking)) {
			return false;
		}
		return this.equals(obj) && minimumWithdrawal == ((NoServiceChargeChecking) obj).minimumWithdrawal;
	}
}
