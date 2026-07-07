package bank;

public class Account {

    private int accountNumber;
    private String accountType;
    private double balance;
    private Customer customer;

    public Account(int accountNumber,String accountType,double balance,Customer customer) 
    {
    this.accountNumber = accountNumber;
    this.accountType = accountType;
    this.balance = balance;
    this.customer = customer;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public String getAccountType(){
        return accountType;
    }

    public double getBalance(){
        return balance;
    }
    public Customer getCustomer(){
        return customer;
    }

    //setter 
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void displayAccountDetails() {

        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Type : " + accountType);
        System.out.println("Balance : " + balance);

        System.out.println();
        customer.displayCustomerDetails();

    }

    public void deposit(double amount) {

    if(amount <= 0) {
        System.out.println("Deposit amount must be greater than 0.");
        return;
    }

    balance += amount;

    System.out.println("Rs" + amount + " deposited successfully.");
    System.out.println("Updated Balance : Rs" + balance);
}

public void withdraw(double amount) {

    if(amount <= 0) {
        System.out.println("Withdrawal amount must be greater than 0.");
        return;
    }

    if(amount > balance) {
        System.out.println("Insufficient Balance.");
        return;
    }

    balance -= amount;

    System.out.println("₹" + amount + " withdrawn successfully.");
    System.out.println("Remaining Balance : Rs" + balance);
}

public void checkBalance() {
    System.out.println("Current Balance : Rs" + balance);
}

    







}
