package bank;

public class Bank {
    private String bankName;
    private String branchName;

    public Bank(String bankName, String branchName) {
    this.bankName = bankName;
    this.branchName = branchName;
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

    
}