package service;

import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;

import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao = ProductDaoImpl.getInstance();
    private static ProductServiceImpl instance = null;

    private ProductServiceImpl(){
    }

    public static ProductServiceImpl getInstance(){
        if(instance == null){
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    public List<Product> getAllProducts() {
        try {
            return productDao.getAllProducts();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Integer getProductsCount() {
        try {
            return productDao.getAllProducts().size();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Product getProductByProductName(String ProductName) {
        return productDao.getProductByProductName(ProductName);
    }

    public Boolean isProductMoreThanZero(String ProductName) {
        if(isProductExist(ProductName)){
            if(productDao.getProductByProductName(ProductName).getProductCount()>0) return true;
        }
        return false;

    }

    public Boolean isProductExist(String ProductName) {
        List<Product> products = null;
        try {
            products = productDao.getAllProducts();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Product product : products){
            if(product.getProductName().equals(ProductName)) return true;
        }
        return false;
    }

    public Boolean isProductExist(Long id) {
        List<Product> products = null;
        try {
            products = productDao.getAllProducts();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Product product : products){
            if(product.getId().equals(id)) return true;
        }
        return false;
    }
}
