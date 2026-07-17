package ui;

import dao.CustomerDAO;
import dao.OrderDAO;
import dao.ProductDAO;

import javax.swing.*;

public class DashboardFrame extends JFrame {

    JLabel lblTitle;

    JLabel lblCustomers;

    JLabel lblOrders;

    JLabel lblRevenue;

    JButton btnCustomers;

    JButton btnProducts;

    JButton btnOrders;

    JButton btnLogout;

    public DashboardFrame() {

        setTitle("Dashboard");

        setSize(700, 500);

        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // TITLE

        lblTitle =
                new JLabel("ADMIN DASHBOARD");

        lblTitle.setBounds(250, 20, 250, 40);

        add(lblTitle);

        // DAO OBJECTS

        CustomerDAO customerDAO =
                new CustomerDAO();

        ProductDAO productDAO =
                new ProductDAO();

        OrderDAO orderDAO =
                new OrderDAO();

        // TOTAL CUSTOMERS

        int totalCustomers =
                customerDAO.getAllCustomers().size();

        lblCustomers =
                new JLabel(
                        "Total Customers : "
                                + totalCustomers
                );

        lblCustomers.setBounds(50, 100, 250, 40);

        add(lblCustomers);

        // TOTAL ORDERS

        int totalOrders =
                orderDAO.getTotalOrders();

        lblOrders =
                new JLabel(
                        "Total Orders : "
                                + totalOrders
                );

        lblOrders.setBounds(50, 160, 250, 40);

        add(lblOrders);

        // TOTAL REVENUE

        double revenue =
                orderDAO.getTotalRevenue();

        lblRevenue =
                new JLabel(
                        "Total Revenue : ₹"
                                + revenue
                );

        lblRevenue.setBounds(50, 220, 250, 40);

        add(lblRevenue);

        // CUSTOMER BUTTON

        btnCustomers =
                new JButton("Customers");

        btnCustomers.setBounds(
                400,
                100,
                180,
                40
        );

        add(btnCustomers);

        // PRODUCT BUTTON

        btnProducts =
                new JButton("Products");

        btnProducts.setBounds(
                400,
                170,
                180,
                40
        );

        add(btnProducts);

        // ORDER BUTTON

        btnOrders =
                new JButton("Orders");

        btnOrders.setBounds(
                400,
                240,
                180,
                40
        );

        add(btnOrders);

        // LOGOUT BUTTON

        btnLogout =
                new JButton("Logout");

        btnLogout.setBounds(
                400,
                310,
                180,
                40
        );

        add(btnLogout);

        // BUTTON ACTIONS

        btnCustomers.addActionListener(e -> {

            new CustomerFrame();
        });

        btnProducts.addActionListener(e -> {

            new ProductFrame();
        });

        btnOrders.addActionListener(e -> {

            new OrderFrame();
        });

        btnLogout.addActionListener(e -> {

            dispose();

            new LoginFrame();
        });

        setLocationRelativeTo(null);

        setVisible(true);
    }
}