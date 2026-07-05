package bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank("ABC Bank","Sangamner");
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

bank.displayAllAccounts();
    }
}