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
    System.out.println("8. Exit");
    System.out.print("Enter your choice : ");

    int choice = sc.nextInt();
    sc.nextLine();



switch(choice){

case 1:
    System.out.println("Enter customer details : ");

int customerId;
do {
    System.out.print("Customer ID: ");
    customerId = sc.nextInt();

    if (customerId <= 0) {
        System.out.println("Customer ID must be greater than 0.");
    }

} while (customerId <= 0);
sc.nextLine();

String name;
do {
    System.out.print("Name: ");
    name = sc.nextLine();

    if (name.trim().isEmpty()) {
        System.out.println("Name cannot be empty.");
    }
} while (name.trim().isEmpty());


String phoneNumber;
do {
    System.out.print("Phone Number: ");
    phoneNumber = sc.nextLine().trim();

    if (!phoneNumber.matches("\\d{10}")) {
        System.out.println("Phone number must contain exactly 10 digits.");
    }

} while (!phoneNumber.matches("\\d{10}"));


String email;
do {
    System.out.print("Email: ");
    email = sc.nextLine().trim();

    if (!email.contains("@") || !email.contains(".")) {
        System.out.println("Enter a valid email address.");
    }

} while (!email.contains("@") || !email.contains("."));

String address;
do {
    System.out.print("Address: ");
    address = sc.nextLine();

    if (address.trim().isEmpty()) {
        System.out.println("Address cannot be empty.");
    }
} while (address.trim().isEmpty());



    System.out.println("Enter Account details :");
        
int accountNumber;
while (true) {

    System.out.print("Account Number: ");

    if (sc.hasNextInt()) {

        accountNumber = sc.nextInt();
        sc.nextLine();   // consume newline

        if (accountNumber > 0) {
            break;
        }

        System.out.println("Account Number must be greater than 0.");

    } else {

        System.out.println("Please enter a valid number.");
        sc.nextLine();   // discard invalid input

    }
}

        System.out.print("Account Type:");
        String accountType=sc.nextLine();

double balance;
do {
    System.out.print("Balance: ");
    balance = sc.nextDouble();

    if (balance < 0) {
        System.out.println("Balance cannot be negative.");
    }

} while (balance < 0);

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






    