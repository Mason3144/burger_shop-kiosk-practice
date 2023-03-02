package app.product.subProduct;

import app.product.Product;

public class Drink extends Product {
    boolean straw = true;
    public Drink(int id, String name, int cal, int price) {
        super(id, name, cal, price);
    }
    public void option(){};
}