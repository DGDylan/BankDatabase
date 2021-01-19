
public class bankDatabase implements bankInterface {
	
	public AccountList accounts = new AccountList();
	
	//Create account methods
	public void openAccount(String name, String SSN) {
		Account person = new Account(name, SSN);
		accounts.add(person);
	}

	public void openCheckingAccount(Account x, double balance) {
		x.createCheckingAcc(balance);
	}

	public void openCreditAccount(Account x, double balance) {
		x.createCreditAcc(balance);
	}

	
	//Checking account methods
	public void deposit(Account x, double amount) {
		double prevBalanace = x.getCheckingBalance();
		x.setCheckingBal(prevBalanace + amount); 
	}

	public void withdraw(Account x, double amount) {
		double prevBalance = x.getCheckingBalance();
		x.setCheckingBal(prevBalance - amount);
	}

	public void transfer(Account x, Account y, double amount) {
		double xBalance = x.getCheckingBalance();
		double yBalance = y.getCheckingBalance();
		if(xBalance < amount) {
			throw new IllegalArgumentException("Insufficient Funds.");
		}
		
		else {
			x.setCheckingBal(xBalance - amount);
			y.setCheckingBal(yBalance + amount); 
		}
	}

	public void payCreditBalance(Account x, double amount) {
		double prevCheckingBalance = x.getCheckingBalance();
		double prevCreditBalance = x.getCreditBalance();
		if(prevCheckingBalance < amount) {
			throw new IllegalArgumentException("Insufficient Funds.");
		}
		else if(prevCreditBalance < amount) {
			throw new IllegalArgumentException("You are trying to pay more than you owe.");
		}
		else {
			x.setCheckingBal(prevCheckingBalance - amount);
			x.setCreditBal(prevCreditBalance - amount);
		}	
	}

	
	//Credit Account methods
	public void makePayment(Account x, double amount) {
		double prevBalance = x.getCreditBalance();
		x.setCreditBal(prevBalance + amount);
	}

	public void payBalance(Account x, double amount) {
		double prevBalance = x.getCreditBalance();
		if(prevBalance < amount) {
			throw new IllegalArgumentException("You are trying to pay more than you owe.");
		}
		else {
			x.setCreditBal(prevBalance - amount);
		}
	}

	public void changeName(Account x, String name) {
		x.setName(name);		
	}

	public void changeSSN(Account x, String SSN) {
		x.setSSN(SSN);		
	}

	//Methods to close accounts
	public void closeCheckingAcc(Account x) {
		x.closeCheckingAcc();
	}

	public void closeCreditAcc(Account x) {
		x.closeCreditAcc();
	}
	
	public void closeAccount(int index) {
		accounts.remove(index);
	}
	
	//Returns the account index based on the name passed in
	public int getAccountIndex(String name) {
		int key = 0;
		for(int i = 0; i < accounts.size; i++) {
			if(accounts.get(i).getName().equals(name)) {
				key = i;
			}
		}
		return key;
	}

	
}
