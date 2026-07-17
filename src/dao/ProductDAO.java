package dao;

import db.DBConnection;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // ADD PRODUCT

    public boolean addProduct(Product product) {

        boolean status = false;

        String query =
                "INSERT INTO products "
                + "(product_name, category, price, stock) "
                + "VALUES (?, ?, ?, ?)";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1,
                    product.getProductName());

            pst.setString(2,
                    product.getCategory());

            pst.setDouble(3,
                    product.getPrice());

            pst.setInt(4,
                    product.getStock());

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

    // VIEW ALL PRODUCTS

    public List<Product> getAllProducts() {

        List<Product> productList =
                new ArrayList<>();

        String query =
                "SELECT * FROM products";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    con.prepareStatement(query);

            ResultSet rs =
                    pst.executeQuery();

            while (rs.next()) {

                Product product =
                        new Product(

                                rs.getInt("product_id"),

                                rs.getString("product_name"),

                                rs.getString("category"),

                                rs.getDouble("price"),

                                rs.getInt("stock")
                        );

                productList.add(product);
            }

            rs.close();

            pst.close();

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return productList;
    }

    // SEARCH PRODUCT

    public Product searchProductById(int productId) {

        Product product = null;

        String query =
                "SELECT * FROM products "
                + "WHERE product_id=?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setInt(1, productId);

            ResultSet rs =
                    pst.executeQuery();

            if (rs.next()) {

                product =
                        new Product(

                                rs.getInt("product_id"),

                                rs.getString("product_name"),

                                rs.getString("category"),

                                rs.getDouble("price"),

                                rs.getInt("stock")
                        );
            }

            rs.close();

            pst.close();

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return product;
    }

    // UPDATE PRODUCT

    public boolean updateProduct(Product product) {

        boolean status = false;

        String query =
                "UPDATE products "
                + "SET product_name=?, "
                + "category=?, "
                + "price=?, "
                + "stock=? "
                + "WHERE product_id=?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1,
                    product.getProductName());

            pst.setString(2,
                    product.getCategory());

            pst.setDouble(3,
                    product.getPrice());

            pst.setInt(4,
                    product.getStock());

            pst.setInt(5,
                    product.getProductId());

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

    // DELETE PRODUCT

    public boolean deleteProduct(int productId) {

        boolean status = false;

        String query =
                "DELETE FROM products "
                + "WHERE product_id=?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setInt(1, productId);

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