import api.ProductServiceImpl;
import entity.Product;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    @Test
    public void testGetAllProducts() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l,"Spodnie",20.2,2.1,"carmazine",200));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        List<Product> productsFromTestClass = productService.getAllProducts();

        Assert.assertEquals(products, productsFromTestClass);
    }

    @Test
    public void testNotGetAllProducts() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l,"Spodnie",20.2,2.1,"carmazine",200));

        ProductServiceImpl productsService = new ProductServiceImpl(new ArrayList<Product>(products));
        List<Product> productFromTestClass = productsService.getAllProducts();
        products.add(new Product(10l,"meszek", 21.2,32,"white", 2));

        Assert.assertNotEquals(products, productFromTestClass);
    }

    @Test
    public void testGetProductsCount() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l,"Spodnie1",20.2,2.12,"carmazine",200));
        products.add(new Product(2l,"Spodnie2",20.2,2.13,"carmazine",200));
        products.add(new Product(3l,"Spodnie3",20.2,2.14,"carmazine",200));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final int result = productService.getProductsCount();

        Assert.assertEquals(3,result);
    }

    @Test
    public void testNotGetProductsCount() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l,"Spodnie1",20.2,2.12,"carmazine",200));
        products.add(new Product(2l,"Spodnie2",20.2,2.13,"carmazine",200));
        products.add(new Product(3l,"Spodnie3",20.2,2.14,"carmazine",200));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final int result = productService.getProductsCount();

        Assert.assertNotEquals(10,result);
    }


    @Test
    public void testGetProductByProductName() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l,"Spodnie1",20.2,2.12,"carmazine",200));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product result = productService.getProductByProductName("Spodnie1");

        Assert.assertEquals("Spodnie1", result);

    }

    @Test
    public void testNotGetProductByProductName() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l,"Spodnie1",20.2,2.12,"carmazine",200));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final Product result = productService.getProductByProductName("Spodnie1");

        Assert.assertNotEquals("dupa", result);
    }

    @Test
    public void testIsProductMoreThanZero() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l,"Spodnie1",20.2,2.12,"carmazine",200));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean result = productService.isProductMoreThanZero("Spodnie1");

        Assert.assertTrue(result);

    }

    @Test
    public void testNotIsProductMoreThanZero() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l,"Spodnie1",20.2,2.12,"carmazine",200));

        ProductServiceImpl productService = new ProductServiceImpl(products);
        final boolean result = productService.isProductMoreThanZero("buty");

        Assert.assertFalse(result);
    }

    @Test
    public void testIsExistByProductName() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l,"Spodnie1",20.2,2.12,"carmazine",200));
    }

    @Test
    public void testNotIsExistByProductName() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l,"Spodnie1",20.2,2.12,"carmazine",200));
    }

    @Test
    public void testIsExistById() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l,"Spodnie1",20.2,2.12,"carmazine",200));
    }

    @Test
    public void testNotIsExistById() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1l,"Spodnie1",20.2,2.12,"carmazine",200));
    }


}
