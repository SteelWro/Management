package facade;

import api.ProductDao;
import api.ProductFacade;
import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;
import service.ProductServiceImpl;

import java.io.IOException;
import java.util.List;

public class ProductFacadeImpl implements ProductFacade {
    private static ProductFacadeImpl instance = null;
    //ProductDao productDao = ProductDaoImpl.getInstance();
    ProductService productService = ProductServiceImpl.getInstance();


    private ProductFacadeImpl(){}

    public static ProductFacadeImpl getInstance(){
        if(instance == null){
            instance = new ProductFacadeImpl();
        }
        return instance;
    }

    public String createProduct(Product product) {
        try {
            productService.saveProduct(product);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return " utworzono produkt ";
    }

    public String removeProduct(Product productName) {
        try {
            productService.removeProduct(productName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return " usunięto produkt ";
    }

    public List<Product> getAllProducts() {
        try {
            return productService.getAllProducts();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
