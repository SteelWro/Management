package api;

import entity.Product;

import java.sql.PreparedStatement;
import java.util.List;

public interface ProductFacade {
    String createProduct(Product product);
    String removeProduct(Product productName);
    List<Product> getAllProducts();
}
