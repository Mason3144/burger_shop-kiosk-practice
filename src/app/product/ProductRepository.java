package app.product;

import app.product.subProduct.Drink;
import app.product.subProduct.Hamburger;
import app.product.subProduct.Side;

public class ProductRepository {
    private int id =1;
     Product[] products = new Product[]{
             new Hamburger(id++, "새우버거", 500, 3500,4500),
            new Hamburger(id++, "치킨버거", 600, 4000,5000),
            new Side(id++, "감자튀김", 300, 1000),
            new Side(id++, "어니언링", 300, 1000),
            new Drink(id++, "코카콜라", 200, 1000),
            new Drink(id++, "제로콜라", 0, 1000),
    };

    public Product[] getProducts() {
        return products;
    }
    public Product findById(int id){
        if(id>products.length) return null;
        return products[--id];

    }
}
