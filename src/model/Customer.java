package model;

public class Customer {

    private int customerId;

    private String name;

    private String phone;

    private String address;

    private int loyaltyPoints;

    // CONSTRUCTOR

    public Customer(
            int customerId,
            String name,
            String phone,
            String address,
            int loyaltyPoints
    ) {

        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.loyaltyPoints = loyaltyPoints;
    }

    // GETTERS

    public int getCustomerId() {

        return customerId;
    }

    public String getName() {

        return name;
    }

    public String getPhone() {

        return phone;
    }

    public String getAddress() {

        return address;
    }

    public int getLoyaltyPoints() {

        return loyaltyPoints;
    }

    // SETTERS

    public void setCustomerId(int customerId) {

        this.customerId = customerId;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {

        this.loyaltyPoints = loyaltyPoints;
    }

    // TOSTRING

    @Override
    public String toString() {

        return "Customer ID : "
                + customerId
                + " | Name : "
                + name
                + " | Phone : "
                + phone
                + " | Address : "
                + address
                + " | Loyalty Points : "
                + loyaltyPoints;
    }
}