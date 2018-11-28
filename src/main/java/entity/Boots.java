package entity;

import entity.Enum.Colors;
import entity.Enum.ProductSeparators;
import entity.Enum.SkinType;

public class Boots extends Product{
    private int size;
    private SkinType skinType;

    public Boots(Long id, String productName, double price, double weight, Colors color, int productCount, int size, SkinType skinType) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.skinType = skinType;
    }

    public int getSize() {
        return size;
    }

    public SkinType getSkinType() {
        return skinType;
    }

    @Override
    public String toString() {
         return ProductSeparators.BOOTS_ID.toString() + ProductSeparators.PRODUCT_SEPARATOR.toString() + getBasicToString() + ProductSeparators.PRODUCT_SEPARATOR.toString() + size + ProductSeparators.PRODUCT_SEPARATOR.toString() + skinType.toString();
    }
}
