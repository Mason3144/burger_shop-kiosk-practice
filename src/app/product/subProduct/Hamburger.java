package app.product.subProduct;

import app.product.Product;

public class Hamburger extends Product {
    private boolean isBurgerSet = false;
    private int burgerSetPrice;
    public Hamburger(int id, String name, int cal, int price,int burgerSetPrice) {
        super(id, name, cal, price);
        this.burgerSetPrice = burgerSetPrice;
    }

    public Hamburger(Hamburger hamburger) {
        super(hamburger.getName(), hamburger.getCal(), hamburger.getPrice());
        this.burgerSetPrice = hamburger.getburgerSetPrice();
    }

    public boolean isBurgerSet() {
        return isBurgerSet;
    }
    public void setBurgerSet(boolean set) {
        isBurgerSet = set;
    }
    public int getburgerSetPrice() {
        return burgerSetPrice;
    }
}
