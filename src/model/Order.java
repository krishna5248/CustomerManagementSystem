package model;

public class Order {

	private int orderId;

	private int customerId;

	private int productId;

	private int quantity;

	private double totalAmount;

	private double discount;

	private double finalAmount;

	// CONSTRUCTOR

	public Order(int orderId, int customerId, int productId, int quantity, double totalAmount, double discount,
			double finalAmount) {

		this.orderId = orderId;

		this.customerId = customerId;

		this.productId = productId;

		this.quantity = quantity;

		this.totalAmount = totalAmount;

		this.discount = discount;

		this.finalAmount = finalAmount;
	}

	// GETTERS

	public int getOrderId() {

		return orderId;
	}

	public int getCustomerId() {

		return customerId;
	}

	public int getProductId() {

		return productId;
	}

	public int getQuantity() {

		return quantity;
	}

	public double getTotalAmount() {

		return totalAmount;
	}

	public double getDiscount() {

		return discount;
	}

	public double getFinalAmount() {

		return finalAmount;
	}

	// SETTERS

	public void setOrderId(int orderId) {

		this.orderId = orderId;
	}

	public void setCustomerId(int customerId) {

		this.customerId = customerId;
	}

	public void setProductId(int productId) {

		this.productId = productId;
	}

	public void setQuantity(int quantity) {

		this.quantity = quantity;
	}

	public void setTotalAmount(double totalAmount) {

		this.totalAmount = totalAmount;
	}

	public void setDiscount(double discount) {

		this.discount = discount;
	}

	public void setFinalAmount(double finalAmount) {

		this.finalAmount = finalAmount;
	}

	// TOSTRING

	@Override
	public String toString() {

		return "Order ID : " + orderId + " | Customer ID : " + customerId + " | Product ID : " + productId
				+ " | Quantity : " + quantity + " | Total : " + totalAmount + " | Discount : " + discount
				+ " | Final Amount : " + finalAmount;
	}
}