package ui;

import dao.ProductDAO;
import model.Product;

import javax.swing.*;
import java.util.List;

public class ProductFrame extends JFrame {

    JLabel lblTitle;

    JLabel lblId;
    JLabel lblName;
    JLabel lblCategory;
    JLabel lblPrice;
    JLabel lblStock;

    JTextField txtId;
    JTextField txtName;
    JTextField txtCategory;
    JTextField txtPrice;
    JTextField txtStock;

    JButton btnAdd;
    JButton btnView;
    JButton btnSearch;
    JButton btnUpdate;
    JButton btnDelete;

    JTextArea area;

    ProductDAO dao;

    public ProductFrame() {

        dao = new ProductDAO();

        setTitle("Product Management");

        setSize(800, 650);

        setLayout(null);

        // TITLE

        lblTitle =
                new JLabel("PRODUCT MANAGEMENT");

        lblTitle.setBounds(280, 20, 300, 40);

        add(lblTitle);

        // PRODUCT ID

        lblId =
                new JLabel("Product ID");

        lblId.setBounds(50, 100, 120, 30);

        add(lblId);

        txtId =
                new JTextField();

        txtId.setBounds(180, 100, 180, 30);

        add(txtId);

        // PRODUCT NAME

        lblName =
                new JLabel("Product Name");

        lblName.setBounds(50, 150, 120, 30);

        add(lblName);

        txtName =
                new JTextField();

        txtName.setBounds(180, 150, 180, 30);

        add(txtName);

        // CATEGORY

        lblCategory =
                new JLabel("Category");

        lblCategory.setBounds(50, 200, 120, 30);

        add(lblCategory);

        txtCategory =
                new JTextField();

        txtCategory.setBounds(180, 200, 180, 30);

        add(txtCategory);

        // PRICE

        lblPrice =
                new JLabel("Price");

        lblPrice.setBounds(50, 250, 120, 30);

        add(lblPrice);

        txtPrice =
                new JTextField();

        txtPrice.setBounds(180, 250, 180, 30);

        add(txtPrice);

        // STOCK

        lblStock =
                new JLabel("Stock");

        lblStock.setBounds(50, 300, 120, 30);

        add(lblStock);

        txtStock =
                new JTextField();

        txtStock.setBounds(180, 300, 180, 30);

        add(txtStock);

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

        // ADD PRODUCT

        btnAdd.addActionListener(e -> {

            String name =
                    txtName.getText();

            String category =
                    txtCategory.getText();

            double price =
                    Double.parseDouble(
                            txtPrice.getText()
                    );

            int stock =
                    Integer.parseInt(
                            txtStock.getText()
                    );

            Product product =
                    new Product(
                            0,
                            name,
                            category,
                            price,
                            stock
                    );

            boolean status =
                    dao.addProduct(product);

            if(status) {

                JOptionPane.showMessageDialog(
                        this,
                        "Product Added Successfully"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Failed To Add Product"
                );
            }
        });

        // VIEW PRODUCTS

        btnView.addActionListener(e -> {

            area.setText("");

            List<Product> list =
                    dao.getAllProducts();

            for(Product product : list) {

                area.append(
                        product + "\n"
                );
            }
        });

        // SEARCH PRODUCT

        btnSearch.addActionListener(e -> {

            int id =
                    Integer.parseInt(
                            txtId.getText()
                    );

            Product product =
                    dao.searchProductById(id);

            if(product != null) {

                txtName.setText(
                        product.getProductName()
                );

                txtCategory.setText(
                        product.getCategory()
                );

                txtPrice.setText(
                        String.valueOf(
                                product.getPrice()
                        )
                );

                txtStock.setText(
                        String.valueOf(
                                product.getStock()
                        )
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Product Not Found"
                );
            }
        });

        // UPDATE PRODUCT

        btnUpdate.addActionListener(e -> {

            int id =
                    Integer.parseInt(
                            txtId.getText()
                    );

            String name =
                    txtName.getText();

            String category =
                    txtCategory.getText();

            double price =
                    Double.parseDouble(
                            txtPrice.getText()
                    );

            int stock =
                    Integer.parseInt(
                            txtStock.getText()
                    );

            Product product =
                    new Product(
                            id,
                            name,
                            category,
                            price,
                            stock
                    );

            boolean status =
                    dao.updateProduct(product);

            if(status) {

                JOptionPane.showMessageDialog(
                        this,
                        "Product Updated Successfully"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Update Failed"
                );
            }
        });

        // DELETE PRODUCT

        btnDelete.addActionListener(e -> {

            int id =
                    Integer.parseInt(
                            txtId.getText()
                    );

            boolean status =
                    dao.deleteProduct(id);

            if(status) {

                JOptionPane.showMessageDialog(
                        this,
                        "Product Deleted Successfully"
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