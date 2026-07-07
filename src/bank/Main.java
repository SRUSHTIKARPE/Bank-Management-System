package bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank("ABC Bank","Sangamner");


/*    account1.checkBalance();

    System.out.print("Enter amount to deposit: ");
double depositAmount = sc.nextDouble();
account1.deposit(depositAmount);

System.out.print("Enter amount to withdraw: ");
double withdrawAmount = sc.nextDouble();
account1.withdraw(withdrawAmount);

    account1.checkBalance(); */
   
boolean exit = false;

while (!exit) {

    System.out.println("\n====================================");
    System.out.println("      BANK MANAGEMENT SYSTEM");
    System.out.println("====================================");
    System.out.println("1. Create Account");
    System.out.println("2. Display All Accounts");
    System.out.println("3. Search Account");
    System.out.println("4. Exit");
    System.out.print("Enter your choice : ");

    int choice = sc.nextInt();
    sc.nextLine();



switch(choice){

case 1:
    System.out.println("Enter customer details : ");

        System.out.print("Customer ID:");
        int customerId=sc.nextInt();
        sc.nextLine();

        System.out.print("Name:");
        String name=sc.nextLine();

        System.out.print("Phone number:");
        String phoneNumber=sc.nextLine();

        System.out.print("Email:");
        String email=sc.nextLine();

        System.out.print("Address:");
        String address=sc.nextLine();

        System.out.println("Enter Account details :");
        System.out.print("Account Number:");
        int accountNumber=sc.nextInt();
        sc.nextLine();

        System.out.print("Account Type:");
        String accountType=sc.nextLine();

        System.out.print("balance");
        double balance=sc.nextDouble();

        
// Customer customer1 = new Customer(
// 1,
// "Snehal",
// "9876543210",
// "snehal@gmail.com",
// "Sangamner");

        Customer customer1 = new Customer(
customerId,
name,
phoneNumber,
email,
address);


// Account account1 = new Account(
// 1001,
// "Savings",
// 5000,
// customer1);

Account account1 = new Account(
accountNumber,
accountType,
balance,
customer1);
bank.createAccount(account1);

    break;

case 2:
    bank.displayAllAccounts();

    break;

case 3:
    System.out.print("Enter account number to search: ");
int searchNumber = sc.nextInt();

Account foundAccount = bank.searchAccount(searchNumber);

if (foundAccount != null) {

    System.out.println("\nAccount Found!");

    foundAccount.displayAccountDetails();

}
else {

    System.out.println("Account Not Found.");

}

    break;

case 4:

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






    