package app.product.subProduct;

import app.product.Product;

public class BurgerSet extends Product {
    private Hamburger hamburger;
    private Side side;
    private Drink drink;

    public BurgerSet(int id, String name, int cal, int price, Hamburger hamburger, Side side, Drink drink) {
        super(id, name, cal, price);
        this.hamburger = hamburger;
        this.side = side;
        this.drink = drink;
    }

    public Hamburger getHamburger() {
        return hamburger;
    }

    public Side getSide() {
        return side;
    }

    public Drink getDrink() {
        return drink;
    }
}
