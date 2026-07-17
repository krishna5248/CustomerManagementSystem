package dao;

import db.DBConnection;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    // ADD CUSTOMER

    public boolean addCustomer(Customer customer) {

        boolean status = false;

        String query =
                "INSERT INTO customers "
                + "(name, phone, address, loyalty_points) "
                + "VALUES (?, ?, ?, ?)";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, customer.getName());

            pst.setString(2, customer.getPhone());

            pst.setString(3, customer.getAddress());

            pst.setInt(4, customer.getLoyaltyPoints());

            int rows = pst.executeUpdate();

            if (rows > 0) {

                status = true;
            }

            pst.close();

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return status;
    }

    // VIEW ALL CUSTOMERS

    public List<Customer> getAllCustomers() {

        List<Customer> customerList =
                new ArrayList<>();

        String query =
                "SELECT * FROM customers";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    con.prepareStatement(query);

            ResultSet rs =
                    pst.executeQuery();

            while (rs.next()) {

                Customer customer =
                        new Customer(

                                rs.getInt("customer_id"),

                                rs.getString("name"),

                                rs.getString("phone"),

                                rs.getString("address"),

                                rs.getInt("loyalty_points")
                        );

                customerList.add(customer);
            }

            rs.close();

            pst.close();

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return customerList;
    }

    // SEARCH CUSTOMER

    public Customer searchCustomerById(int customerId) {

        Customer customer = null;

        String query =
                "SELECT * FROM customers "
                + "WHERE customer_id=?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setInt(1, customerId);

            ResultSet rs =
                    pst.executeQuery();

            if (rs.next()) {

                customer =
                        new Customer(

                                rs.getInt("customer_id"),

                                rs.getString("name"),

                                rs.getString("phone"),

                                rs.getString("address"),

                                rs.getInt("loyalty_points")
                        );
            }

            rs.close();

            pst.close();

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return customer;
    }

    // UPDATE CUSTOMER

    public boolean updateCustomer(Customer customer) {

        boolean status = false;

        String query =
                "UPDATE customers "
                + "SET name=?, phone=?, "
                + "address=?, loyalty_points=? "
                + "WHERE customer_id=?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, customer.getName());

            pst.setString(2, customer.getPhone());

            pst.setString(3, customer.getAddress());

            pst.setInt(4,
                    customer.getLoyaltyPoints());

            pst.setInt(5,
                    customer.getCustomerId());

            int rows =
                    pst.executeUpdate();

            if (rows > 0) {

                status = true;
            }

            pst.close();

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return status;
    }

    // DELETE CUSTOMER

    public boolean deleteCustomer(int customerId) {

        boolean status = false;

        String query =
                "DELETE FROM customers "
                + "WHERE customer_id=?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setInt(1, customerId);

            int rows =
                    pst.executeUpdate();

            if (rows > 0) {

                status = true;
            }

            pst.close();

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return status;
    }
}