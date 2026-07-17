package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {

            String url =
                    "jdbc:mysql://localhost:3306/customer_system";

            String user = "root";

            String password = "Nani@5248";

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    url,
                    user,
                    password
            );

        } catch (Exception e) {

            e.printStackTrace();
        }

        return con;
    }
}