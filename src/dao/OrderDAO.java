package dao;

import db.DBConnection;
import model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

	// ADD ORDER

	public boolean addOrder(Order order) {

		boolean status = false;

		String query = "INSERT INTO orders " + "(customer_id, product_id, quantity, "
				+ "total_amount, discount, final_amount) " + "VALUES (?, ?, ?, ?, ?, ?)";

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, order.getCustomerId());

			pst.setInt(2, order.getProductId());

			pst.setInt(3, order.getQuantity());

			pst.setDouble(4, order.getTotalAmount());

			pst.setDouble(5, order.getDiscount());

			pst.setDouble(6, order.getFinalAmount());

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

	// VIEW ALL ORDERS

	public List<Order> getAllOrders() {

		List<Order> orderList = new ArrayList<>();

		String query = "SELECT * FROM orders";

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Order order = new Order(

						rs.getInt("order_id"),

						rs.getInt("customer_id"),

						rs.getInt("product_id"),

						rs.getInt("quantity"),

						rs.getDouble("total_amount"),

						rs.getDouble("discount"),

						rs.getDouble("final_amount"));

				orderList.add(order);
			}

			rs.close();

			pst.close();

			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return orderList;
	}

	// SEARCH ORDER

	public Order searchOrderById(int id) {

		Order order = null;

		String query = "SELECT * FROM orders " + "WHERE order_id=?";

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				order = new Order(

						rs.getInt("order_id"),

						rs.getInt("customer_id"),

						rs.getInt("product_id"),

						rs.getInt("quantity"),

						rs.getDouble("total_amount"),

						rs.getDouble("discount"),

						rs.getDouble("final_amount"));
			}

			rs.close();

			pst.close();

			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return order;
	}

	// DELETE ORDER

	public boolean deleteOrder(int id) {

		boolean status = false;

		String query = "DELETE FROM orders " + "WHERE order_id=?";

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, id);

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

	// TOTAL ORDERS

	public int getTotalOrders() {

		int total = 0;

		String query = "SELECT COUNT(*) FROM orders";

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				total = rs.getInt(1);
			}

			rs.close();

			pst.close();

			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return total;
	}

	// TOTAL REVENUE

	public double getTotalRevenue() {

		double revenue = 0;

		String query = "SELECT SUM(final_amount) FROM orders";

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				revenue = rs.getDouble(1);
			}

			rs.close();

			pst.close();

			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return revenue;
	}
}