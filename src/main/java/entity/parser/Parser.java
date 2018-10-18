package entity.parser;

import entity.Product;

public class Parser {
    public static Product parseStringToProduct(String line){
        String[] productInf = line.split(Product.PRODUCT_SEPARATOR);

            Long id = Long.parseLong(productInf[0]);
            String productName = productInf[1];
            Float price = Float.parseFloat(productInf[2]);
            Float weight = Float.parseFloat(productInf[3]);
            String color = productInf[4];
            Integer productCount = Integer.parseInt(productInf[5]);

            return (new Product(id, productName, price, weight, color, productCount));

    }
}
