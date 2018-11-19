package entity.parser;

import entity.Boots;
import entity.Cloth;
import entity.Enum.ProductSeparators;
import entity.Product;
import entity.User;


public class Parser {
    public static Product parseStringToProduct(String line){
        String[] productInf = line.split(ProductSeparators.PRODUCT_SEPARATOR.toString());
        if(productInf[0].equals(ProductSeparators.PRODUCT_ID.toString()))
            return parseToProduct(productInf);
        else if(productInf[0].equals(ProductSeparators.CLOTH_ID.toString()))
            return parseToCloth(productInf);
        else if(productInf[0].equals(ProductSeparators.BOOTS_ID.toString()))
            return parseToBoots(productInf);
        else System.out.println("zły typ produktu");

    return null;
    }

    private static Product parseToBoots(String[] productInf){
        Long id = Long.parseLong(productInf[1]);
        String productName = productInf[2];
        Float price = Float.parseFloat(productInf[3]);
        Float weight = Float.parseFloat(productInf[4]);
        String color = productInf[5];
        Integer productCount = Integer.parseInt(productInf[6]);
        Integer size = Integer.parseInt(productInf[7]);
        Boolean isNaturalSkin = Boolean.parseBoolean(productInf[8]);

        return (new Boots(id, productName, price, weight, color, productCount,size,isNaturalSkin));
    }

    private static Product parseToCloth(String[] productInf){
        Long id = Long.parseLong(productInf[1]);
        String productName = productInf[2];
        Float price = Float.parseFloat(productInf[3]);
        Float weight = Float.parseFloat(productInf[4]);
        String color = productInf[5];
        Integer productCount = Integer.parseInt(productInf[6]);
        String size = productInf[7];
        String material = productInf[8];

        return (new Cloth(id, productName, price, weight, color, productCount,size,material));
    }

    private static Product parseToProduct(String[] productInf){
        Long id = Long.parseLong(productInf[1]);
        String productName = productInf[2];
        Float price = Float.parseFloat(productInf[3]);
        Float weight = Float.parseFloat(productInf[4]);
        String color = productInf[5];
        Integer productCount = Integer.parseInt(productInf[6]);

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
