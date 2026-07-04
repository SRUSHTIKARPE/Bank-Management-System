package bank;

public class Customer {

    private int customerId;
    private String name;
    private String phoneNumber;
    private String email;
    private String address; //variables are private so they can only directly acess by Customer class and other class must use methods to access them.that is encapsulation.


    public Customer(int customerId, String name, String phoneNumber, String email, String address)
    {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;

    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    //customerId setter is not created because IDs should remain fixed after creation.

    public void displayCustomerDetails() {

        System.out.println("Customer Id :" + customerId);
        System.out.println("Name :" + name);
        System.out.println("Phone :" + phoneNumber);
        System.out.println("Email :" + email);
        System.out.println("Address :" + address);
    }



}

