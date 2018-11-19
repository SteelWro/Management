package entity;

import entity.Enum.ProductSeparators;

public class Boots extends Product{
    private int size;
    private boolean isNaturalSkin;

    public Boots(Long id, String productName, double price, double weight, String color, int productCount, int size, boolean isNaturalSkin) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNaturalSkin = isNaturalSkin;
    }

    public int getSize() {
        return size;
    }

    public boolean isNaturalSkin() {
        return isNaturalSkin;
    }

    @Override
    public String toString() {
         return ProductSeparators.BOOTS_ID.toString() + ProductSeparators.PRODUCT_SEPARATOR.toString() + getBasicToString() + ProductSeparators.PRODUCT_SEPARATOR.toString() + size + ProductSeparators.PRODUCT_SEPARATOR.toString() + isNaturalSkin;
    }
}
