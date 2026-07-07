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



}