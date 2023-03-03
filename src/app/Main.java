package app;

import app.discount.Discount;
import app.discount.discountCondition.DiscountCondition;
import app.discount.discountCondition.StudentDiscountCondition;
import app.discount.discountCondition.TeenDiscountCondition;
import app.discount.discountPolicy.FixedAmountDiscountPolicy;
import app.discount.discountPolicy.FixedRateDiscountPolicy;

public class Main {
    public static void main(String[] args) {
        Appconfigurer appconfigurer = new Appconfigurer();
        Kiosk kiosk = new Kiosk(
                appconfigurer.productRepository(),
                appconfigurer.menu(),
                appconfigurer.cart(),
                new Order(appconfigurer.cart(),appconfigurer.discount()
        ));
        kiosk.operate();

    }
}