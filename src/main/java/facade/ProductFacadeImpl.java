package facade;

import api.ProductDao;
import api.ProductFacade;
import dao.ProductDaoImpl;
import entity.Product;

import java.io.IOException;
import java.util.List;

public class ProductFacadeImpl implements ProductFacade {
    private static ProductFacadeImpl instance = null;
    ProductDao productDao = ProductDaoImpl.getInstance();


    private ProductFacadeImpl(){}

    public static ProductFacadeImpl getInstance(){
        if(instance == null){
            instance = new ProductFacadeImpl();
        }
        return instance;
    }

    public String createProduct(Product product) {
        try {
            productDaoS.saveProduct(product);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return " utworzono produkt ";
    }

    public String removeProduct(Product productName) {
        try {
            productDao.removeProductByName(productName.getProductName());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return " usunięto produkt ";
    }

    public List<Product> getAllProducts() {
        try {
            return productDao.getAllProducts();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
