package app.product.subProduct;

import app.product.Product;

public class Hamburger extends Product {
    boolean isSet = false;
    int setPrice;
    public Hamburger(int id, String name, int cal, int price,int setPrice) {
        super(id, name, cal, price);
        this.setPrice = setPrice;
    }
    public void option(){};
}
