package bank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Bank {
    //private ArrayList<Account> accounts;
    private String bankName;
    private String branchName;

    public Bank(String bankName, String branchName){

    this.bankName = bankName;
    this.branchName = branchName;

    //accounts = new ArrayList<>();
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

    //accounts.add(account);

    try{
        Connection con = DBConnection.getConnection();

        String customerQuery = "INSERT INTO customer VALUES(?,?,?,?,?)";

        PreparedStatement ps1= con.prepareStatement(customerQuery);

        ps1.setInt(1,
        account.getCustomer().getCustomerId());

        ps1.setString(2,
        account.getCustomer().getName());

        ps1.setString(3,
        account.getCustomer().getPhoneNumber());

        ps1.setString(4,
        account.getCustomer().getEmail());

        ps1.setString(5,
        account.getCustomer().getAddress());

        ps1.executeUpdate();

         String accountQuery =
        "INSERT INTO account VALUES(?,?,?,?)";

        PreparedStatement ps2 =
        con.prepareStatement(accountQuery);

        ps2.setInt(1,
        account.getAccountNumber());

        ps2.setString(2,
        account.getAccountType());

        ps2.setDouble(3,
        account.getBalance());

        ps2.setInt(4,
        account.getCustomer().getCustomerId());

        ps2.executeUpdate();

        System.out.println("Account Created Successfully.");

        con.close();

    }
    catch(Exception e){

        e.printStackTrace();

    }

    

    }

    public void displayAllAccounts(){

        // if(accounts.isEmpty()){
        //     System.out.println("No Accounts Found.");
        //     return;
        // }

        // for(Account account : accounts){

        //     account.displayAccountDetails();

        //     System.out.println("----------------------");

        // }

        try{
            Connection con=DBConnection.getConnection();

            String query = "SELECT * FROM account a JOIN customer c ON a.customer_id = c.customer_id";
            Statement st =con.createStatement();

        ResultSet rs =
        st.executeQuery(query);

        while(rs.next()) {

            System.out.println();

            System.out.println("Account Number : "
            + rs.getInt("account_number"));

            System.out.println("Account Type : "
            + rs.getString("account_type"));

            System.out.println("Balance : "
            + rs.getDouble("balance"));

            System.out.println("Customer ID : "
            + rs.getInt("customer_id"));

            System.out.println("Name : "
            + rs.getString("name"));

            System.out.println("Phone : "
            + rs.getString("phone"));

            System.out.println("Email : "
            + rs.getString("email"));

            System.out.println("Address : "
            + rs.getString("address"));

            System.out.println("----------------------");
        }
        con.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

public Account searchAccount(int accountNumber) {

    // for (Account account : accounts) {

    //     if (account.getAccountNumber() == accountNumber) {
    //         return account;
    //     }
    // }


    try {

        Connection con =
        DBConnection.getConnection();

        String query =
        "SELECT * FROM account a JOIN customer c ON a.customer_id=c.customer_id WHERE account_number=?";

        PreparedStatement ps =
        con.prepareStatement(query);

        ps.setInt(1, accountNumber);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){

            Customer customer =
            new Customer(

            rs.getInt("customer_id"),

            rs.getString("name"),

            rs.getString("phone"),

            rs.getString("email"),

            rs.getString("address")

            );

            Account account =
            new Account(

            rs.getInt("account_number"),

            rs.getString("account_type"),

            rs.getDouble("balance"),

            customer

            );

            return account;

        }

    }

    catch(Exception e){

        e.printStackTrace();

    }

   
    return null;
}    



}