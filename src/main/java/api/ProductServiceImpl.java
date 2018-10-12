package api;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    List<Product> products;

    public ProductServiceImpl() {
        products = new ArrayList<Product>();
    }

    public ProductServiceImpl(List<Product> products) {
        this.products = products;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Integer getProductsCount() {
        return products.size();
    }

    public Product getProductByProductName(String ProductName) {
        return null;
    }

    public Boolean isProductMoreThanZero(String ProductName) {
        return null;
    }

    public Boolean isExistByProductName(String ProductName) {
        return null;
    }

    public Boolean isExistById(int id) {
        return null;
    }
}
