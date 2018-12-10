package validator;

import entity.Product;
import exception.productException.ProductCountNegativeException;
import exception.productException.ProductNameEmptyException;
import exception.productException.ProductPriceNoPositiveException;
import exception.productException.ProductWeightNoPositiveException;

public class ProductValidator {
    private static ProductValidator instance = null;

    private ProductValidator(){
    }

    public static ProductValidator getInstance(){
        if(instance == null){
            instance = new ProductValidator();
        }
        return instance;
    }

    public boolean isValidate(Product product) throws ProductPriceNoPositiveException, ProductCountNegativeException, ProductWeightNoPositiveException, ProductNameEmptyException {
            isPriceMoreThanZero(product);
            isProductCountMoreThanZero(product);
            isWageMoreThanZero(product);
            isNameIsNotEmpty(product);
        return true;
    }

    public boolean isPriceMoreThanZero(Product product) throws ProductPriceNoPositiveException {
        if(product.getPrice() > 0) return true;
        else throw new ProductPriceNoPositiveException("Cena jest ujemna");
    }

    public boolean isProductCountMoreThanZero(Product product) throws ProductCountNegativeException {
        if(product.getProductCount() > 0) return true;
        else throw new ProductCountNegativeException("ilość produktu jest ujemna");

    }

    public boolean isWageMoreThanZero(Product product) throws ProductWeightNoPositiveException {
        if(product.getWeight() > 0) return true;
        else throw new ProductWeightNoPositiveException("waga produktu jest ujemna");
    }

    public boolean isNameIsNotEmpty(Product product) throws ProductNameEmptyException {
        if(product.getProductName().equals("") || product.getProductName().equals(null))
            throw new ProductNameEmptyException("brak nazwy produktu");
        return true;
    }

}
