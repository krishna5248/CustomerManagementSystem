package ui;

import dao.CustomerDAO;
import model.Customer;

import javax.swing.*;
import java.util.List;

public class CustomerFrame extends JFrame {

    JLabel lblTitle;

    JLabel lblName;
    JLabel lblPhone;
    JLabel lblAddress;
    JLabel lblPoints;
    JLabel lblId;

    JTextField txtName;
    JTextField txtPhone;
    JTextField txtAddress;
    JTextField txtPoints;
    JTextField txtId;

    JButton btnAdd;
    JButton btnView;
    JButton btnSearch;
    JButton btnUpdate;
    JButton btnDelete;

    JTextArea area;

    CustomerDAO dao;

    public CustomerFrame() {

        dao = new CustomerDAO();

        setTitle("Customer Management");

        setSize(800, 650);

        setLayout(null);

        // TITLE

        lblTitle =
                new JLabel("CUSTOMER MANAGEMENT");

        lblTitle.setBounds(280, 20, 300, 40);

        add(lblTitle);

        // CUSTOMER ID

        lblId =
                new JLabel("Customer ID");

        lblId.setBounds(50, 100, 120, 30);

        add(lblId);

        txtId =
                new JTextField();

        txtId.setBounds(180, 100, 180, 30);

        add(txtId);

        // NAME

        lblName =
                new JLabel("Name");

        lblName.setBounds(50, 150, 120, 30);

        add(lblName);

        txtName =
                new JTextField();

        txtName.setBounds(180, 150, 180, 30);

        add(txtName);

        // PHONE

        lblPhone =
                new JLabel("Phone");

        lblPhone.setBounds(50, 200, 120, 30);

        add(lblPhone);

        txtPhone =
                new JTextField();

        txtPhone.setBounds(180, 200, 180, 30);

        add(txtPhone);

        // ADDRESS

        lblAddress =
                new JLabel("Address");

        lblAddress.setBounds(50, 250, 120, 30);

        add(lblAddress);

        txtAddress =
                new JTextField();

        txtAddress.setBounds(180, 250, 180, 30);

        add(txtAddress);

        // LOYALTY POINTS

        lblPoints =
                new JLabel("Loyalty Points");

        lblPoints.setBounds(50, 300, 120, 30);

        add(lblPoints);

        txtPoints =
                new JTextField();

        txtPoints.setBounds(180, 300, 180, 30);

        add(txtPoints);

        // BUTTONS

        btnAdd =
                new JButton("ADD");

        btnAdd.setBounds(450, 100, 150, 40);

        add(btnAdd);

        btnView =
                new JButton("VIEW");

        btnView.setBounds(450, 160, 150, 40);

        add(btnView);

        btnSearch =
                new JButton("SEARCH");

        btnSearch.setBounds(450, 220, 150, 40);

        add(btnSearch);

        btnUpdate =
                new JButton("UPDATE");

        btnUpdate.setBounds(450, 280, 150, 40);

        add(btnUpdate);

        btnDelete =
                new JButton("DELETE");

        btnDelete.setBounds(450, 340, 150, 40);

        add(btnDelete);

        // TEXT AREA

        area =
                new JTextArea();

        JScrollPane pane =
                new JScrollPane(area);

        pane.setBounds(50, 420, 680, 150);

        add(pane);

        // ADD CUSTOMER

        btnAdd.addActionListener(e -> {

            String name =
                    txtName.getText();

            String phone =
                    txtPhone.getText();

            String address =
                    txtAddress.getText();

            int points =
                    Integer.parseInt(
                            txtPoints.getText()
                    );

            Customer customer =
                    new Customer(
                            0,
                            name,
                            phone,
                            address,
                            points
                    );

            boolean status =
                    dao.addCustomer(customer);

            if(status) {

                JOptionPane.showMessageDialog(
                        this,
                        "Customer Added Successfully"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Failed To Add Customer"
                );
            }
        });

        // VIEW CUSTOMERS

        btnView.addActionListener(e -> {

            area.setText("");

            List<Customer> list =
                    dao.getAllCustomers();

            for(Customer customer : list) {

                area.append(
                        customer + "\n"
                );
            }
        });

        // SEARCH CUSTOMER

        btnSearch.addActionListener(e -> {

            int id =
                    Integer.parseInt(
                            txtId.getText()
                    );

            Customer customer =
                    dao.searchCustomerById(id);

            if(customer != null) {

                txtName.setText(
                        customer.getName()
                );

                txtPhone.setText(
                        customer.getPhone()
                );

                txtAddress.setText(
                        customer.getAddress()
                );

                txtPoints.setText(
                        String.valueOf(
                                customer.getLoyaltyPoints()
                        )
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Customer Not Found"
                );
            }
        });

        // UPDATE CUSTOMER

        btnUpdate.addActionListener(e -> {

            int id =
                    Integer.parseInt(
                            txtId.getText()
                    );

            String name =
                    txtName.getText();

            String phone =
                    txtPhone.getText();

            String address =
                    txtAddress.getText();

            int points =
                    Integer.parseInt(
                            txtPoints.getText()
                    );

            Customer customer =
                    new Customer(
                            id,
                            name,
                            phone,
                            address,
                            points
                    );

            boolean status =
                    dao.updateCustomer(customer);

            if(status) {

                JOptionPane.showMessageDialog(
                        this,
                        "Customer Updated Successfully"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Update Failed"
                );
            }
        });

        // DELETE CUSTOMER

        btnDelete.addActionListener(e -> {

            int id =
                    Integer.parseInt(
                            txtId.getText()
                    );

            boolean status =
                    dao.deleteCustomer(id);

            if(status) {

                JOptionPane.showMessageDialog(
                        this,
                        "Customer Deleted Successfully"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Delete Failed"
                );
            }
        });

        setLocationRelativeTo(null);

        setVisible(true);
    }
}