package api;

import entity.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ProductDao {
    void saveProduct(Product product);
    void saveProducts(List<Product> products);
    void removeProductById(Long productId);
    void removeProductByName(String productName);
    List<Product> getAllProducts() throws IOException;
    Product getProductById(Long productId) throws IOException;
    Product getProductByProductName(String productName);
}
