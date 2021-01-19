//Dylan Rambarran
//Project 1
//Jinqiu Liu CS313
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("bank.txt"));
		String line = null;
		bankDatabase bank = new bankDatabase();
		ArrayList<String> lines = new ArrayList<String>();
		
    //Stores each word of each line separated by the comma into an ArrayList
		while((line = br.readLine()) != null) {
			String[] words = line.split(",");
			for(int i = 0; i < words.length; i++) {
				String word = words[i];
				lines.add(word);
			}
		}
		
		int size = lines.size();
    //Loop through each word of the ArrayList and will call the functions based on the number of each line
		for(int i = 0; i < size; i++) {
			
			//0 - openAccount
			if(lines.get(i).equals("0")) {
				String name = lines.get(i + 1);
				String SSN = lines.get(i + 2);
				bank.openAccount(name, SSN);
				int index = bank.getAccountIndex(name);
				String s = name + " opened an account with SSN: " + SSN + ", and Account ID: " + bank.accounts.get(index).getAccNumber() + ".";
				Log(s);
			}
			
			//1 - openCheckingAccount
			else if(lines.get(i).equals("1")) {
				String name = lines.get(i + 1);
				double balance = 0.0; 
				balance = Double.parseDouble(lines.get(i + 2));
				int index = bank.getAccountIndex(name);
				bank.openCheckingAccount(bank.accounts.get(index), balance);
				String s = name + " opened a checking account with Checking ID: " + bank.accounts.get(index).getCheckingAccNum() + ",and balance : $" + balance + ".";
				Log(s);
			}
			
			//2 - openCreditAccount
			else if(lines.get(i).equals("2")) {
				String name = lines.get(i + 1);
				double balance = 0.0;
				balance = Double.parseDouble(lines.get(i + 2));
				int index = bank.getAccountIndex(name);
				bank.openCreditAccount(bank.accounts.get(index), balance);
				String s = name + " opened a credit account with Credit ID: " + bank.accounts.get(index).getCreditAccNum() + ",with an initial balance of: $" + balance + ".";
				Log(s);
			}
			
			//3 - deposit
			else if(lines.get(i).equals("3")) {
				String name = lines.get(i + 1);
				double amount = 0.0;
				amount = Double.parseDouble(lines.get(i + 2));
				int index = bank.getAccountIndex(name);
				bank.deposit(bank.accounts.get(index), amount);
				String s = name + " deposited: $" + amount + " into their checking account, their balance is now: $" + bank.accounts.get(index).getCheckingBalance() + ".";
				Log(s);
			}
			
			//4 - withdraw
			else if(lines.get(i).equals("4")) {
				String name = lines.get(i + 1);
				double amount = 0.0;
				amount = Double.parseDouble(lines.get(i + 2));
				int index = bank.getAccountIndex(name);
				bank.withdraw(bank.accounts.get(index), amount);
				String s = name + " withdrew: $" + amount + " from their checking account, their balance is now: $" + bank.accounts.get(index).getCheckingBalance() + ".";
				Log(s);
			}
			
			//5 - transfer
			else if(lines.get(i).equals("5")) {
				String name1 = lines.get(i + 1);
				String name2= lines.get(i + 2);
				double amount = 0.0;
				amount = Double.parseDouble(lines.get(i + 3));
				int index1 = bank.getAccountIndex(name1);
				int index2 = bank.getAccountIndex(name2);
				bank.transfer(bank.accounts.get(index1), bank.accounts.get(index2), amount);
				String s = name1 + " has transfered: $" + amount + " to " + name2 + "'s checking account.";
				Log(s);
			}
			
			//6 - payCreditBalance
			else if(lines.get(i).equals("6")) {
				String name = lines.get(i + 1);
				double amount = 0.0;
				amount = Double.parseDouble(lines.get(i + 2));
				int index = bank.getAccountIndex(name);
				bank.payCreditBalance(bank.accounts.get(index), amount);
				String s = name + " has used their checking account to pay off: $" + amount + " on their credit account, their credit balance is now: $" + bank.accounts.get(index).getCreditBalance() + ".";
				Log(s);
			}
			
			//7 - makePayment
			else if(lines.get(i).equals("7")) {
				String name = lines.get(i + 1);
				double amount = 0.0;
				amount = Double.parseDouble(lines.get(i + 2));
				int index = bank.getAccountIndex(name);
				bank.makePayment(bank.accounts.get(index), amount);
				String s = name + " has made a purchase of: $" + amount + ", their credit balance is now: $" + bank.accounts.get(index).getCreditBalance() + ".";
				Log(s);
			}
			
			//8 - payBalance
			else if(lines.get(i).equals("8")) {
				String name = lines.get(i + 1);
				double amount = 0.0;
				amount = Double.parseDouble(lines.get(i + 2));
				int index = bank.getAccountIndex(name);
				bank.payBalance(bank.accounts.get(index), amount);
				String s = name + " has paid: $" + amount + " off their credit balance, their credit balance is now: $" + bank.accounts.get(index).getCreditBalance() + ".";
				Log(s);
			}
			
			//9 - changeName
			else if(lines.get(i).equals("9")) {
				String name = lines.get(i + 1);
				String nameChange = lines.get(i + 2);
				int index = bank.getAccountIndex(name);
				bank.changeName(bank.accounts.get(index), nameChange);
				String s = name + " has changed their name to " + bank.accounts.get(index).getName() + ".";
				Log(s);
			}
			
			//10 - changeSSN
			else if(lines.get(i).equals("10")) {
				String name = lines.get(i + 1);
				String SSN = lines.get(i + 2);
				int index = bank.getAccountIndex(name);
        String prevSSN = bank.accounts.get(index).getSSN();
				bank.changeSSN(bank.accounts.get(index), SSN);
				String s = name + " changed their SSN from " + prevSSN + " to " + bank.accounts.get(index).getSSN() + ".";
				Log(s);
			}
			
			//11 - closeCheckingAcc
			else if(lines.get(i).equals("11")) {
				String name = lines.get(i + 1);
				int index = bank.getAccountIndex(name);
				bank.closeCheckingAcc(bank.accounts.get(index));
				String s = name + " closed their checking account.";
				Log(s);
			}
			
			//12 - closeCreditAcc
			else if(lines.get(i).equals("12")) {
				String name = lines.get(i + 1);
				int index = bank.getAccountIndex(name);
				bank.closeCreditAcc(bank.accounts.get(index));
				String s = name + " closed their checking account.";
				Log(s);
			}
			
			//13 - closeAccount
			else if(lines.get(i).equals("13")) {
				String name = lines.get(i + 1);
				int index = bank.getAccountIndex(name);
				bank.closeAccount(index);
				String s = name + " closed their account.";
				Log(s);
			}
		}

		br.close();
		
    //For loop to get info of remaining accounts and pass to Output function
		for(int i = 0; i < bank.accounts.size(); i++) {
      String s = bank.accounts.get(i).getName() + " has a checking balance of: $" + bank.accounts.get(i).getCheckingBalance() + " and a credit balance of: $" + bank.accounts.get(i).getCreditBalance() + ".";
      createOutput(s);
    }

	}
	
	//Method to create a log based on the functions that were called in the main
	public static void Log(String s) {
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("log.txt", true)));
			out.println(s);
			out.close();
		} 
		catch (IOException e) { }
	}
	
  
	//Outputs the final state of the database "NAME has a checking balance of: $0.0 and a credit balance of: $0.0."
	public static void createOutput(String s) {
		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt", true)));
			out.println(s);
			out.close();
		}
		catch(IOException e) { }
	}

}
