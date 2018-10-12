package api;

import entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Integer getProductsCount();
    Product getProductByProductName(String ProductName);
    Boolean isProductMoreThanZero(String ProductName);
    Boolean isExistByProductName(String ProductName);
    Boolean isExistById(int id);
}
