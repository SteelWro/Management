package entity.parser;

import entity.Product;
import entity.User;

import javax.jws.soap.SOAPBinding;

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

    public static User parseStringToUser(String line){
        String[] userInf = line.split(User.USER_SEPARATOR);

        Long id = Long.parseLong(userInf[0]);
        String login = userInf[1];
        String password = userInf[2];

        return(new User(id,login,password));
    }
}
