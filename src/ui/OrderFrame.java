package ui;

import dao.OrderDAO;
import model.Order;

import javax.swing.*;
import java.util.List;

public class OrderFrame extends JFrame {

	JLabel lblTitle;

	JLabel lblOrderId;
	JLabel lblCustomerId;
	JLabel lblProductId;
	JLabel lblQuantity;
	JLabel lblTotal;
	JLabel lblDiscount;
	JLabel lblFinal;

	JTextField txtOrderId;
	JTextField txtCustomerId;
	JTextField txtProductId;
	JTextField txtQuantity;
	JTextField txtTotal;
	JTextField txtDiscount;
	JTextField txtFinal;

	JButton btnAdd;
	JButton btnView;
	JButton btnSearch;
	JButton btnDelete;

	JTextArea area;

	OrderDAO dao;

	public OrderFrame() {

		dao = new OrderDAO();

		setTitle("Order Management");

		setSize(850, 700);

		setLayout(null);

		// TITLE

		lblTitle = new JLabel("ORDER MANAGEMENT");

		lblTitle.setBounds(300, 20, 300, 40);

		add(lblTitle);

		// ORDER ID

		lblOrderId = new JLabel("Order ID");

		lblOrderId.setBounds(50, 100, 120, 30);

		add(lblOrderId);

		txtOrderId = new JTextField();

		txtOrderId.setBounds(200, 100, 180, 30);

		add(txtOrderId);

		// CUSTOMER ID

		lblCustomerId = new JLabel("Customer ID");

		lblCustomerId.setBounds(50, 150, 120, 30);

		add(lblCustomerId);

		txtCustomerId = new JTextField();

		txtCustomerId.setBounds(200, 150, 180, 30);

		add(txtCustomerId);

		// PRODUCT ID

		lblProductId = new JLabel("Product ID");

		lblProductId.setBounds(50, 200, 120, 30);

		add(lblProductId);

		txtProductId = new JTextField();

		txtProductId.setBounds(200, 200, 180, 30);

		add(txtProductId);

		// QUANTITY

		lblQuantity = new JLabel("Quantity");

		lblQuantity.setBounds(50, 250, 120, 30);

		add(lblQuantity);

		txtQuantity = new JTextField();

		txtQuantity.setBounds(200, 250, 180, 30);

		add(txtQuantity);

		// TOTAL AMOUNT

		lblTotal = new JLabel("Total Amount");

		lblTotal.setBounds(50, 300, 120, 30);

		add(lblTotal);

		txtTotal = new JTextField();

		txtTotal.setBounds(200, 300, 180, 30);

		add(txtTotal);

		// DISCOUNT

		lblDiscount = new JLabel("Discount");

		lblDiscount.setBounds(50, 350, 120, 30);

		add(lblDiscount);

		txtDiscount = new JTextField();

		txtDiscount.setBounds(200, 350, 180, 30);

		add(txtDiscount);

		// FINAL AMOUNT

		lblFinal = new JLabel("Final Amount");

		lblFinal.setBounds(50, 400, 120, 30);

		add(lblFinal);

		txtFinal = new JTextField();

		txtFinal.setBounds(200, 400, 180, 30);

		add(txtFinal);

		// BUTTONS

		btnAdd = new JButton("ADD");

		btnAdd.setBounds(500, 120, 180, 40);

		add(btnAdd);

		btnView = new JButton("VIEW");

		btnView.setBounds(500, 190, 180, 40);

		add(btnView);

		btnSearch = new JButton("SEARCH");

		btnSearch.setBounds(500, 260, 180, 40);

		add(btnSearch);

		btnDelete = new JButton("DELETE");

		btnDelete.setBounds(500, 330, 180, 40);

		add(btnDelete);

		// TEXT AREA

		area = new JTextArea();

		JScrollPane pane = new JScrollPane(area);

		pane.setBounds(50, 500, 730, 120);

		add(pane);

		// ADD ORDER

		btnAdd.addActionListener(e -> {

			int customerId = Integer.parseInt(txtCustomerId.getText());

			int productId = Integer.parseInt(txtProductId.getText());

			int quantity = Integer.parseInt(txtQuantity.getText());

			double total = Double.parseDouble(txtTotal.getText());

			double discount = Double.parseDouble(txtDiscount.getText());

			double finalAmount = Double.parseDouble(txtFinal.getText());

			Order order = new Order(0, customerId, productId, quantity, total, discount, finalAmount);

			boolean status = dao.addOrder(order);

			if (status) {

				JOptionPane.showMessageDialog(this, "Order Added Successfully");

			} else {

				JOptionPane.showMessageDialog(this, "Failed To Add Order");
			}
		});

		// VIEW ORDERS

		btnView.addActionListener(e -> {

			area.setText("");

			List<Order> list = dao.getAllOrders();

			for (Order order : list) {

				area.append(order + "\n");
			}
		});

		// SEARCH ORDER

		btnSearch.addActionListener(e -> {

			int id = Integer.parseInt(txtOrderId.getText());

			Order order = dao.searchOrderById(id);

			if (order != null) {

				txtCustomerId.setText(String.valueOf(order.getCustomerId()));

				txtProductId.setText(String.valueOf(order.getProductId()));

				txtQuantity.setText(String.valueOf(order.getQuantity()));

				txtTotal.setText(String.valueOf(order.getTotalAmount()));

				txtDiscount.setText(String.valueOf(order.getDiscount()));

				txtFinal.setText(String.valueOf(order.getFinalAmount()));

			} else {

				JOptionPane.showMessageDialog(this, "Order Not Found");
			}
		});

		// DELETE ORDER

		btnDelete.addActionListener(e -> {

			int id = Integer.parseInt(txtOrderId.getText());

			boolean status = dao.deleteOrder(id);

			if (status) {

				JOptionPane.showMessageDialog(this, "Order Deleted Successfully");

			} else {

				JOptionPane.showMessageDialog(this, "Delete Failed");
			}
		});

		setLocationRelativeTo(null);

		setVisible(true);
	}
}