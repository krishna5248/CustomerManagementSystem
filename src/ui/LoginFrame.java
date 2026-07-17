package ui;

import dao.AdminDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame
        implements ActionListener {

    JLabel lblTitle;

    JLabel lblUsername;

    JLabel lblPassword;

    JTextField txtUsername;

    JPasswordField txtPassword;

    JButton btnLogin;

    public LoginFrame() {
    	

        setTitle("Customer Management System");

        setSize(500, 400);

        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // TITLE

        lblTitle =
                new JLabel("ADMIN LOGIN");

        lblTitle.setBounds(170, 30, 200, 40);

        add(lblTitle);

        // USERNAME

        lblUsername =
                new JLabel("Username");

        lblUsername.setBounds(70, 100, 100, 30);

        add(lblUsername);

        txtUsername =
                new JTextField();

        txtUsername.setBounds(180, 100, 180, 30);

        add(txtUsername);

        // PASSWORD

        lblPassword =
                new JLabel("Password");

        lblPassword.setBounds(70, 160, 100, 30);

        add(lblPassword);

        txtPassword =
                new JPasswordField();

        txtPassword.setBounds(180, 160, 180, 30);

        add(txtPassword);

        // LOGIN BUTTON

        btnLogin =
                new JButton("LOGIN");

        btnLogin.setBounds(170, 240, 120, 40);

        add(btnLogin);

        btnLogin.addActionListener(this);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username =
                txtUsername.getText();

        String password =
                String.valueOf(
                        txtPassword.getPassword()
                );

        AdminDAO dao =
                new AdminDAO();

        boolean status =
                dao.login(username, password);

        if (status) {

            JOptionPane.showMessageDialog(
                    this,
                    "Login Successful"
            );

            new DashboardFrame();

            dispose();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Username or Password"
            );
        }
    }

    // MAIN METHOD

    public static void main(String[] args) {

        new LoginFrame();
    }
}