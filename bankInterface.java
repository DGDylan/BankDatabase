
public interface bankInterface {
	
	//Methods that open accounts
	public void openAccount(String name, String SSN); //0
	public void openCheckingAccount(Account x, double balance); //1
	public void openCreditAccount(Account x, double balance); //2
	
	//Checking Account methods
	public void deposit(Account x, double amount); //3
	public void withdraw(Account x, double amount); //4
	public void transfer(Account x, Account y, double amount); //5
	public void payCreditBalance(Account x, double amount); //6
	
	//Credit Account Methods
	public void makePayment(Account x, double amount);  //7
	public void payBalance(Account x, double amount); //8
	
	//Change methods
	public void changeName(Account x, String name); //9
	public void changeSSN(Account x, String SSN); //10
	
	//Close 
	public void closeCheckingAcc(Account x); //11
	public void closeCreditAcc(Account x); //12
	public void closeAccount(int index); //13

	//Method that returns the index of the account based on the account's name
	public int getAccountIndex(String name);
	
}
