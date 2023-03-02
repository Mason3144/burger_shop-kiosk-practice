package app.product.subProduct;

import app.product.Product;

public class Drink extends Product {
    boolean hasstraw = true;
    public Drink(int id, String name, int cal, int price) {
        super(id, name, cal, price);
    }
    public Drink(Drink drink){
        super(drink.getName(), drink.getCal(), drink.getPrice());
    }

    public boolean hasstraw() {
        return hasstraw;
    }

    public void setHasstraw(boolean hasstraw) {
        this.hasstraw = hasstraw;
    }
}