package app.product.subProduct;

import app.product.Product;

public class Side extends Product {
    int ketchup=1;
    public Side(int id, String name, int cal, int price) {
        super(id, name, cal, price);
    }
    public void option(){};
}