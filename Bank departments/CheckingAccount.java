package Q2;

public abstract class CheckingAccount extends BankAccount{
	
	//Represents a checking account that allows writing checks
	public CheckingAccount(String accountNumber, String nameAccountOwner, String id, double balance) {
		super(accountNumber, nameAccountOwner, id, balance);
	}
	
	//Receives a check and deducts from the account
	public void writeCheck(double money)throws IllegalBalance {
		if(this.getBalance() - money < 0) {
            throw new IllegalBalance("There is not enough bank account to do the operation");
	
		}
		this.withdrawal(money);
	}
}
