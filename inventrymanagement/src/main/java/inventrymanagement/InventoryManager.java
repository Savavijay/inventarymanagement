package inventrymanagement;

import java.util.List;
import java.util.Optional;

public class InventoryManager {

    private List<Product> products;

    public InventoryManager() {
        this.products = FileManager.loadProducts();
    }

    // Add a new product
    public void addProduct(Product product) {
        products.add(product);
        FileManager.saveProducts(products);
    }

    // View all products
    public void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            products.forEach(System.out::println);
        }
    }

    // Update product details by ID
    public void updateProduct(String productId, double newPrice, int newQuantity) {
        Optional<Product> productOpt = products.stream()
                .filter(product -> product.getProductId().equals(productId))
                .findFirst();

        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            product.setPrice(newPrice);
            product.setQuantity(newQuantity);
            FileManager.saveProducts(products);
            System.out.println("Product updated: " + product);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    // Remove product by ID
    public void removeProduct(String productId) {
        Optional<Product> productOpt = products.stream()
                .filter(product -> product.getProductId().equals(productId))
                .findFirst();

        if (productOpt.isPresent()) {
            products.remove(productOpt.get());
            FileManager.saveProducts(products);
            System.out.println("Product removed.");
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }
}
