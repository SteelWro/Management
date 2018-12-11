package dao;

import api.ProductDao;
import entity.Product;
import entity.parser.Parser;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
    private static ProductDaoImpl instance = null;
    private static final String fileName = "products.txt";

    public ProductDaoImpl(){
    }

    public static ProductDaoImpl getInstance(){
        if(instance == null){
            instance = new ProductDaoImpl();
        }
        return instance;
    }

    public void saveProduct(Product product) throws IOException {
        List<Product> products = null;
        products = getAllProducts();
        products.add(product);
        saveProducts(products);
    }

    public void saveProducts(List<Product> products) throws FileNotFoundException {
        FileUtils.clearFile(fileName);
        PrintWriter printWriter = null;
        printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        for(Product product : products){
            printWriter.write(product.toString() + "\n");
        }
        printWriter.close();
    }

    public void removeProductById(Long productId) throws IOException {
        List<Product> products = null;
        products = getAllProducts();

        for(int i=0;i<products.size();i++){
            boolean isFoundProduct = products.get(i).getId().equals(productId);
            if(isFoundProduct){
                products.remove(i);
            }
        }
        saveProducts(products);
    }

    public void removeProductByName(String productName) throws IOException {
        List<Product> products = null;
        products = getAllProducts();

        for(int i=0;i<products.size(); i++){
            boolean isFoundProduct = products.get(i).getProductName().equals(productName);
            if(isFoundProduct){
                products.remove(i);
            }
        }
        saveProducts(products);
    }

    public List<Product> getAllProducts() throws IOException {
        List<Product> products = new ArrayList<Product>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("products.txt"));
        String line = bufferedReader.readLine();

        while(line!=null){
            Product product = Parser.parseStringToProduct(line);
            if(product!=null){
                products.add(product);
            }
            line = bufferedReader.readLine();
        }

        bufferedReader.close();
        return products;
    }
}
