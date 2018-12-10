package service;

import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;
import exception.productException.ProductCountNegativeException;
import exception.productException.ProductNameEmptyException;
import exception.productException.ProductPriceNoPositiveException;
import exception.productException.ProductWeightNoPositiveException;
import validator.ProductValidator;

import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao = ProductDaoImpl.getInstance();
    private static ProductServiceImpl instance = null;
    ProductValidator productValidator = ProductValidator.getInstance();

    public ProductServiceImpl(){
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

    public boolean saveProduct(Product product) throws IOException, ProductPriceNoPositiveException, ProductNameEmptyException, ProductCountNegativeException, ProductWeightNoPositiveException {
        if(productValidator.isValidate(product)){
            productDao.saveProduct(product);
            return true;
        }
    return false;
    }

    public void removeProduct(String productName) throws IOException {
        productDao.removeProductByName(productName);
    }

    public Product getProductByProductName(String productName) throws IOException {
        List<Product> products = getAllProducts();
        for(Product product : products)
            if(product.getProductName().equals(productName)) return product;
        return null;
    }

    public Boolean isProductMoreThanZero(String productName) throws IOException {
        List<Product> products = getAllProducts();
        for(Product product : products)
            if(product.getProductName().equals(productName) && product.getProductCount()>0) return true;
        return false;

    }
}
