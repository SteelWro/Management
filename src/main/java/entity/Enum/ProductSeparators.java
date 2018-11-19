package entity.Enum;

public enum ProductSeparators {
    PRODUCT_SEPARATOR("#"),PRODUCT_ID("P"),CLOTH_ID("C"),BOOTS_ID("B");

    private String sign;

    ProductSeparators(String sign){
        this.sign = sign;
    }

    public String toString(){
        return sign;
    }


}
