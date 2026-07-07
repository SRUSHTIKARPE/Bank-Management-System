package bank;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private String bankName;
    private String branchName;

    public Bank(String bankName, String branchName){

    this.bankName = bankName;
    this.branchName = branchName;

    accounts = new ArrayList<>();
}

    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getBranchName() {
        return branchName;
    }
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public void displayBankDetails() {
    System.out.println("Bank Name : " + bankName);
    System.out.println("Branch    : " + branchName);
    }

public void createAccount(Account account){

    accounts.add(account);

    System.out.println("Account created successfully.");

    }

public void displayAllAccounts(){

        if(accounts.isEmpty()){
            System.out.println("No Accounts Found.");
            return;
        }

        for(Account account : accounts){

            account.displayAccountDetails();

            System.out.println("----------------------");

        }

    }

public Account searchAccount(int accountNumber) {

    for (Account account : accounts) {

        if (account.getAccountNumber() == accountNumber) {
            return account;
        }
    }

    return null;
}    


public void deposit(int accountNumber, double amount) {

    Account account = searchAccount(accountNumber);

    if (account != null) {
        account.deposit(amount);
    } else {
        System.out.println("Account Not Found.");
    }
}

public void withdraw(int accountNumber, double amount) {

    Account account = searchAccount(accountNumber);

    if (account != null) {
        account.withdraw(amount);
    } else {
        System.out.println("Account Not Found.");
    }
}

public void checkBalance(int accountNumber) {

    Account account = searchAccount(accountNumber);

    if (account != null) {
        account.checkBalance();
    } else {
        System.out.println("Account Not Found.");
    }
}

public boolean deleteAccount(int accountNumber) {

    Account account = searchAccount(accountNumber);

    if (account != null) {
        accounts.remove(account);
        System.out.println("Account deleted successfully.");
        return true;
    }

    System.out.println("Account Not Found.");
    return false;
}

public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount) {

    // Search sender account
    Account sender = searchAccount(fromAccountNumber);

    // Search receiver account
    Account receiver = searchAccount(toAccountNumber);

    // Check whether both accounts exist
    if (sender == null) {
        System.out.println("Sender Account Not Found.");
        return;
    }

    if (receiver == null) {
        System.out.println("Receiver Account Not Found.");
        return;
    }

    // Prevent transferring to the same account
    if (fromAccountNumber == toAccountNumber) {
        System.out.println("Cannot transfer to the same account.");
        return;
    }

    // Check amount
    if (amount <= 0) {
        System.out.println("Invalid Amount.");
        return;
    }

    // Check balance
    if (sender.getBalance() < amount) {
        System.out.println("Insufficient Balance.");
        return;
    }

    // Perform transfer
    sender.deductBalance(amount);
    receiver.addBalance(amount);

    System.out.println("\nTransfer Successful!");
    System.out.println("Transferred Amount : Rs." + amount);
    System.out.println("From Account       : " + fromAccountNumber);
    System.out.println("To Account         : " + toAccountNumber);
}


}