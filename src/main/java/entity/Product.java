package entity;
import entity.Enum.Colors;
import entity.Enum.ProductSeparators;

public class Product {
    private Long id;
    private String productName;
    private double price;
    private double weight;
    private Colors color;
    private int productCount;

    public Product(Long id, String productName, double price, double weight, Colors color, int productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public Colors getColor() {
        return color;
    }

    public int getProductCount() {
        return productCount;
    }

    protected String getBasicToString(){
        return id + ProductSeparators.PRODUCT_SEPARATOR.toString() + productName + ProductSeparators.PRODUCT_SEPARATOR.toString() + price + ProductSeparators.PRODUCT_SEPARATOR.toString() + weight + ProductSeparators.PRODUCT_SEPARATOR.toString() + color + ProductSeparators.PRODUCT_SEPARATOR.toString() + productCount;
    }

    @Override
    public String toString() {
       return  ProductSeparators.PRODUCT_ID.toString() + ProductSeparators.PRODUCT_SEPARATOR.toString() + getBasicToString();
    }


}
