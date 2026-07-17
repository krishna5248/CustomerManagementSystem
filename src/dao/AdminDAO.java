package dao;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {

    // LOGIN METHOD

    public boolean login(
            String username,
            String password
    ) {

        boolean status = false;

        String query =
                "SELECT * FROM admins "
                + "WHERE username=? AND password=?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, username);

            pst.setString(2, password);

            ResultSet rs =
                    pst.executeQuery();

            if (rs.next()) {

                status = true;
            }

            rs.close();

            pst.close();

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return status;
    }
}