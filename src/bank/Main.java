package bank;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("ABC Bank","Sangamner");

Customer customer1 = new Customer(
1,
"Snehal",
"9876543210",
"snehal@gmail.com",
"Sangamner");

Account account1 = new Account(
1001,
"Savings",
5000,
customer1);

bank.createAccount(account1);

bank.displayAllAccounts();
    }
}