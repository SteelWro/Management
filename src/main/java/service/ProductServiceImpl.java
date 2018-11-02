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

    public List<Product> getAllProducts() throws IOException {
        return productDao.getAllProducts();
    }

    public Integer getProductsCount() throws IOException {
        return productDao.getAllProducts().size();
    }

    public Boolean isProductExist(String ProductName) throws IOException {
        List<Product> products = null;
        products = productDao.getAllProducts();

        for(Product product : products){
            if(product.getProductName().equals(ProductName)) return true;
        }
        return false;
    }

    public Boolean isProductExist(Long id) throws IOException {
        List<Product> products = null;
        products = productDao.getAllProducts();

        for(Product product : products){
            if(product.getId().equals(id)) return true;
        }
        return false;
    }

    public boolean saveProduct(Product product) {
        return false;
    }

    public Product getProductByProductName(String ProductName) throws IOException {
        return productDao.getProductByProductName(ProductName);
    }

    public Boolean isProductMoreThanZero(String ProductName) throws IOException {
        if(isProductExist(ProductName)){
            if(productDao.getProductByProductName(ProductName).getProductCount()>0) return true;
        }
        return false;

    }
}
