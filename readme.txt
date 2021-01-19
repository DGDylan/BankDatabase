Function key:
0 - openAccount(name, ssn): 0,NAME,SSN
1 - openCheckingAccount(name, initial balance): 1,NAME,0.0
2 - openCreditAccount(name, initial balance): 2,NAME,0.0
3 - deposit(name, amount): 3,NAME,0.0
4 - withdraw(name, amount): 4,NAME,0.0
5 - transfer(name1, name2, amount): 5,NAME1,NAME2,0.0
6 - payCreditBalance(name, amount): 6,NAME,0.0
7 - makePayment(name, amount): 7,NAME,0.0
8 - payBalance(name, amount): 8,NAME,0.0
9 - changeName(name, namechange): 9,NAME,NAMECHANGE
10 - changeSSN(name, ssnchange): 10,NAME,SSNCHANGE
11 - closeCheckingAcc(name): 11,NAME
12 - closeCreditAcc(name): 12,NAME
13 - closeAccount(name): 13,NAME

Main Program:
The main program will read the bank.txt file and add each word split by commas into an ArrayList,
then it will go through each word and according to the number, it will call a function. In each 
if/else if statement it creates a string of what happened in the function and passes it to the log file that
writes to log.txt. At the end of main there is a for loop that loops through the bank database and creates a 
string of the accounts that are left and their checking/credit account balances, and this string is passed into
a function that outputs to output.txt.
*Note: If log.txt and output.txt exit already, delete log.txt and output.txt to test if program works, otherwise it will add the strings to the existing log.txt and output.txt

Account:
Account contains name and ssn with a unique account number. In the account class, I made separate methods in the class
to make a checking account with balance and a unique checking id, and credit account with a unique credit id.
When the checking or credit account is closed, the balances are set to 0.

AccountList:
Class made from the ArrayList that we made in class to store Accounts.

bankInterface:
Lists all the functions for the bankDatabase.

bankDatabase:
Contains all the functions implemented from the bankInterface.

bank.txt:
Text file that follows the key above and is read by the main

log.txt:
Outputs a log of all the function calls

output.txt:
Outputs the final state of the database
NAME has a checking balance of: $0.0 and a credit balance of: $0.0.