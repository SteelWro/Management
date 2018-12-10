package facade;

import api.ProductDao;
import api.ProductFacade;
import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;
import exception.productException.ProductCountNegativeException;
import exception.productException.ProductNameEmptyException;
import exception.productException.ProductPriceNoPositiveException;
import exception.productException.ProductWeightNoPositiveException;
import service.ProductServiceImpl;

import java.io.IOException;
import java.util.Collections;
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
        } catch (ProductWeightNoPositiveException e) {
            return e.getMessage();
        } catch (ProductPriceNoPositiveException e) {
            return e.getMessage();
        } catch (ProductCountNegativeException e) {
            return e.getMessage();
        } catch (ProductNameEmptyException e) {
            return e.getMessage();
        }
        return " utworzono produkt ";
    }


    public String removeProduct(String productName) {
        try {
            productService.removeProduct(productName);
        } catch (IOException e) {
            return e.getMessage();
        }
        return " usunięto produkt ";
    }

    public List<Product> getAllProducts() {
        try {
            return productService.getAllProducts();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
