package api;

import entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts() throws IOException;
    Integer getProductsCount() throws IOException;
    Product getProductByProductName(String ProductName) throws IOException;

    Boolean isProductMoreThanZero(String ProductName) throws IOException;
    Boolean isProductExist(String ProductName) throws IOException;
    Boolean isProductExist(Long id) throws IOException;

    boolean saveProduct(Product product);
}
