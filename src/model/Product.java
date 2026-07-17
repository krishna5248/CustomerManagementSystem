package model;

public class Product {

    private int productId;

    private String productName;

    private String category;

    private double price;

    private int stock;

    // CONSTRUCTOR

    public Product(
            int productId,
            String productName,
            String category,
            double price,
            int stock
    ) {

        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    // GETTERS

    public int getProductId() {

        return productId;
    }

    public String getProductName() {

        return productName;
    }

    public String getCategory() {

        return category;
    }

    public double getPrice() {

        return price;
    }

    public int getStock() {

        return stock;
    }

    // SETTERS

    public void setProductId(int productId) {

        this.productId = productId;
    }

    public void setProductName(String productName) {

        this.productName = productName;
    }

    public void setCategory(String category) {

        this.category = category;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    public void setStock(int stock) {

        this.stock = stock;
    }

    // TOSTRING

    @Override
    public String toString() {

        return "Product ID : "
                + productId
                + " | Product Name : "
                + productName
                + " | Category : "
                + category
                + " | Price : "
                + price
                + " | Stock : "
                + stock;
    }
}