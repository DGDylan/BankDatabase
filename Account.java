
public class Account {
	
	//Account Variables
	public String name;
	public String SSN;
	public int AccNumber;
	public static int AccountCounter = 0;
	//Checking Account Variables
	public int checkingAccNum;
	public static int checkingNumCounter = 200;
	public double checkingBalance;
	//Credit Account Variables
	public int creditAccNum;
	public static int creditNumCounter = 500;
	public double creditBalance;
	
	//Default constructor
	public Account() {
		this.name = null;
		this.SSN = null;
		AccNumber = ++AccountCounter;
	}
	
	//Pass in constructor
	public Account(String name, String SSN) {
		this.name = name;
		this.SSN = SSN;
		AccNumber = ++AccountCounter;
	}
	
	//Method to open a checking account
	public void createCheckingAcc(double balance) {
		checkingAccNum = ++checkingNumCounter;
		this.checkingBalance = balance;
	}
	
	//Method to open a credit account
	public void createCreditAcc(double balance) {
		creditAccNum = ++creditNumCounter;
		this.creditBalance = balance;
	}
	
	//Close methods
	public void closeCheckingAcc() {
		this.checkingAccNum = 0;
		this.checkingBalance = 0;
	}
	
	public void closeCreditAcc() {
		this.creditAccNum = 0;
		this.creditBalance = 0;
	}
	
	//Set methods
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSSN(String SSN) {
		this.SSN = SSN;
	}
	
	public void setCheckingBal(double amount) {
		this.checkingBalance = amount;
	}
	
	public void setCreditBal(double amount) {
		this.creditBalance = amount;
	}
	
	//Get methods
	public String getName() {
		return this.name;
	}
	
	public String getSSN() {
		return this.SSN;
	}
	
	public int getAccNumber() {
		return this.AccNumber;
	}
	
	public int getCheckingAccNum() {
		return this.checkingAccNum;
	}
	
	public double getCheckingBalance() {
		return this.checkingBalance;
	}
	
	public int getCreditAccNum() {
		return this.creditAccNum;
	}
	
	public double getCreditBalance() {
		return this.creditBalance;
	}
	
}
