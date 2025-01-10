package inventrymanagement;

public class Product {
    private String productId;
    private String name;
    private String category;
    private int quantity;
    private double price;

    public Product(String productId, String name, String category, int quantity, double price) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Category: %s, Quantity: %d, Price: %.2f", 
                             productId, name, category, quantity, price);
    }

    // For CSV file handling
    public String toCSV() {
        return productId + "," + name + "," + category + "," + quantity + "," + price;
    }

    public static Product fromCSV(String csv) {
        String[] values = csv.split(",");
        return new Product(values[0], values[1], values[2], Integer.parseInt(values[3]), Double.parseDouble(values[4]));
    }
}
