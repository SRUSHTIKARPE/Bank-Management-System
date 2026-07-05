package bank;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank(
                "ABC Bank",
                "Sangamner");

        Customer customer = new Customer(
                1,
                "Srushti Karpe",
                "9876543210",
                "srushti@gmail.com",
                "Sangamner");

        Account account = new Account(
                1001,
                "Savings",
                5000,
                customer);

        bank.displayBankDetails();
        System.out.println();

        account.displayAccountDetails();
    }
}