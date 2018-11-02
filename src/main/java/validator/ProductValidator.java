package validator;

import entity.Product;
import exception.productException.ProductCountNegativeException;
import exception.productException.ProductPriceNoPositiveException;

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

    public boolean isPriceMoreThanZero(Product product) throws ProductPriceNoPositiveException {
        if(product.getPrice() > 0) return true;
        else throw new ProductPriceNoPositiveException("Cena jest ujemna");
    }

    public boolean isProductCountMoreThanZero(Product product) throws ProductCountNegativeException {
        if(product.getProductCount() > 0) return true;
        else throw new ProductCountNegativeException("ilość produktu jest ujemna");

    }

    public boolean isWageMoreThanZero

}
