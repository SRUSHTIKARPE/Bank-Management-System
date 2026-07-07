package bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank("ABC Bank","Sangamner");

   
boolean exit = false;

while (!exit) {

    System.out.println("\n====================================");
    System.out.println("      BANK MANAGEMENT SYSTEM");
    System.out.println("====================================");
    System.out.println("1. Create Account");
    System.out.println("2. Deposit");
    System.out.println("3. Withdraw");
    System.out.println("4. Check Balance");
    System.out.println("5. Search Account");
    System.out.println("6. Display All Accounts");
    System.out.println("7. Delete Account");
    System.out.println("8. Transfer Money");
    System.out.println("9. Exit");
    System.out.print("Enter your choice : ");

    int choice = sc.nextInt();
    sc.nextLine();



switch(choice){

case 1:
    System.out.println("Enter customer details : ");

int customerId = InputValidator.getInt(sc, "Customer ID: ");

String name = InputValidator.getString(sc, "Name: ");

String phoneNumber = InputValidator.getPhone(sc);

String email = InputValidator.getEmail(sc);

String address = InputValidator.getString(sc, "Address: ");



   System.out.println("Enter Account details :");
        
int accountNumber;

while (true) {

    accountNumber = InputValidator.getInt(sc, "Account Number: ");

    // Check if account already exists
    if (bank.searchAccount(accountNumber) == null) {
        break;      // Account number is unique
    }

    System.out.println("Account Number already exists. Please enter another account number.");
}

String accountType = InputValidator.getString(sc, "Account Type: ");

double balance = InputValidator.getDouble(sc, "Balance: ");

Customer customer1 = new Customer(
customerId,
name,
phoneNumber,
email,
address);


Account account1 = new Account(
accountNumber,
accountType,
balance,
customer1);
bank.createAccount(account1);

    break;

case 2:
    
    System.out.print("Enter Account Number: ");
    int accNo = sc.nextInt();

    System.out.print("Enter Amount: ");
    double amount = sc.nextDouble();

    bank.deposit(accNo, amount);

    break;

case 3:

    System.out.print("Enter Account Number: ");
    accNo = sc.nextInt();

    System.out.print("Enter Amount: ");
    amount = sc.nextDouble();

    bank.withdraw(accNo, amount);

    break;

case 4:

    System.out.print("Enter Account Number: ");
    accNo = sc.nextInt();

    bank.checkBalance(accNo);

    break;

case 5:

int searchNumber;

do {

    System.out.print("Enter Account Number: ");
    searchNumber = sc.nextInt();

    if(searchNumber <= 0){
        System.out.println("Invalid Account Number.");
    }

} while(searchNumber <= 0);

Account foundAccount = bank.searchAccount(searchNumber);

if (foundAccount != null) {

    System.out.println("\nAccount Found!");

    foundAccount.displayAccountDetails();

}
else {

    System.out.println("Account Not Found.");

}

    break;

case 6:
    bank.displayAllAccounts();

    break;    

case 7:

    System.out.print("Enter Account Number to delete: ");
    int dltaccountNumber = sc.nextInt();

    bank.deleteAccount(dltaccountNumber);

    break;

case 8:
    
    int fromAccount =
        InputValidator.getInt(sc, "From Account Number: ");

    int toAccount =
        InputValidator.getInt(sc, "To Account Number: ");

    double amt =
        InputValidator.getDouble(sc, "Amount: ");

    bank.transferMoney(fromAccount, toAccount, amt);

    break;

case 9:
    exit = true;
    System.out.println("Thank You for using Bank Management System.");

    break;

default:

    System.out.println("Invalid Choice.");

}
}
sc.close();
}
}






    