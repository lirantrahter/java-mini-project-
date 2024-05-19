package Q2;


public abstract class BankAccount {
	private String accountNumber;
	private String nameAccountOwner;
	private String id;
	private double balance;
	
	//represents a bank account
	public BankAccount(String accountNumber, String nameAccountOwner, String id, double balance) {
		this.accountNumber = accountNumber;
		this.nameAccountOwner = nameAccountOwner;
		this.id = id;
		this.balance = balance;
	}

	//Returns the account number
	public String getAccountNumber() {
		return accountNumber;
	}

	//Change the account number
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	//return the name of account owner
	public String getNameAccountOwner() {
		return nameAccountOwner;
	}

	//change the name of account owner
	public void setNameAccountOwner(String nameAccountOwner) {
		this.nameAccountOwner = nameAccountOwner;
	}

	//return id of account owner
	public String getId() {
		return id;
	}

	//change id of account owner
	public void setId(String id) {
		this.id = id;
	}

	//return balance account 
	public double getBalance() {
		return this.balance;
	}

	//add money to account 
	public void deposit(double money) {
		balance += money;
	}

	//Deducts money from the account if there is enough money there
	public void withdrawal(double money) throws IllegalBalance  {
		if (balance - money < 0) {
            throw new IllegalBalance("There is not enough bank account to do the operation");
		} else
			balance -= money;
	}

	//Monthly management of the bank account
	public abstract void monthlyManagement() throws Exception;

	//Prints the account details
	public String toString() {
		String str = "account number: " + this.accountNumber + "\n" + "name account owner: " + this.nameAccountOwner
				+ "\n" + "id account owner: " + this.id + "\n" + "balance: " + this.balance;
		return str;
	}

	//Compares two bank accounts
	public boolean equals(Object obj) {
		if (!(obj instanceof BankAccount)) {
			return false;
		}
		if (this.accountNumber.equals(((BankAccount) obj).accountNumber)
				&& this.nameAccountOwner.equals(((BankAccount) obj).nameAccountOwner)
				&& this.id.equals(((BankAccount) obj).id) && this.balance == ((BankAccount) obj).balance) {
			return true;
		}
		return false;
	}
}