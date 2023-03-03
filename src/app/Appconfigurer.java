package app;

import app.discount.Discount;
import app.discount.discountCondition.DiscountCondition;
import app.discount.discountCondition.StudentDiscountCondition;
import app.discount.discountCondition.TeenDiscountCondition;
import app.discount.discountPolicy.FixedAmountDiscountPolicy;
import app.discount.discountPolicy.FixedRateDiscountPolicy;
import app.product.ProductRepository;

public class Appconfigurer {
    private ProductRepository productRepository = new ProductRepository();
    private Menu menu = new Menu(productRepository().getProducts());
    private Cart cart = new Cart(productRepository(),menu());
    private Discount discount = new Discount(
            new DiscountCondition[]{
                    new StudentDiscountCondition(new FixedRateDiscountPolicy(10)),
                    new TeenDiscountCondition(new FixedAmountDiscountPolicy(500))
            }
    );

    private Order order = new Order(cart(),discount());
    public ProductRepository productRepository(){
        return productRepository;
    }
    public Menu menu(){
        return menu;
    }

    public Cart cart(){
        return cart;
    }
    public Order order(){
        return order;
    }
    public Discount discount(){
        return  discount;
    }
}
