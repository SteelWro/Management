package entity;

import entity.Enum.Colors;
import entity.Enum.Material;
import entity.Enum.ProductSeparators;

public class Cloth extends Product{
    private String size;
    private Material material;


    public Cloth(Long id, String productName, double price, double weight, Colors color, int productCount, String size, Material material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public Material getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return ProductSeparators.CLOTH_ID.toString() + ProductSeparators.PRODUCT_SEPARATOR.toString() + getBasicToString() + ProductSeparators.PRODUCT_SEPARATOR.toString() + size + ProductSeparators.PRODUCT_SEPARATOR.toString() + material.toString();
    }


}
