package api;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    private static ProductServiceImpl instance = null;

    private ProductServiceImpl(List<Product> products){
        this.products = products;
    }

    public static ProductServiceImpl getInstance(){
        if(instance == null){
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Integer getProductsCount() {
        return products.size();
    }

    public Product getProductByProductName(String ProductName) {
        for(Product product : products){
            if(product.getProductName().equals(ProductName)) return product;
        }
        return null;

    }

    public Boolean isProductMoreThanZero(String ProductName) {
        for(Product product : products){
            if(isProductExist(ProductName)&&product.getProductCount()>0) return true;
        }
        return false;
    }

    public Boolean isProductExist(String ProductName) {
        for(Product product : products){
            if(product.getProductName().equals(ProductName)) return true;
        }
        return false;
    }

    public Boolean isProductExist(Long id) {
        for(Product product : products){
            if(product.getId().equals(id)) return true;
        }
        return false;
    }
}
