package app.product.subProduct;

import app.product.Product;

public class Hamburger extends Product {
    private boolean isSet = false;
    private int setPrice;
    public Hamburger(int id, String name, int cal, int price,int setPrice) {
        super(id, name, cal, price);
        this.setPrice = setPrice;
    }

    public boolean isSet() {
        return isSet;
    }
    public void setSet(boolean set) {
        isSet = set;
    }
    public int getSetPrice() {
        return setPrice;
    }
}
