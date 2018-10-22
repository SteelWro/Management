import dao.ProductDaoImpl;
import entity.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ProductDaoImpl pdi = new ProductDaoImpl("product.txt");

pdi.saveProduct(new Product(3l,"Spodnie1",20.2,2.12,"carmazine",200));
        pdi.removeProductById(2l);

//        Product p = new Product(1l,"Spodnie1",20.2,2.12,"carmazine",200);
//        List<Product> products = new ArrayList<Product>();
//        products.add(p);

//        System.out.println(p.toString());

    }
}
