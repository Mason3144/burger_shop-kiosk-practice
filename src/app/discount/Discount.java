package app.discount;

import app.discount.discountCondition.DiscountCondition;

public class Discount {
    private DiscountCondition[] discountConditions;

    public Discount(DiscountCondition[] discountConditions) {
        this.discountConditions = discountConditions;
    }

    public int discount(int finalPrice){
        for(DiscountCondition discountCondition:discountConditions){
            discountCondition.checkDiscountCondition();
            System.out.println(finalPrice);
            if(discountCondition.getIsEligible()) finalPrice = discountCondition.applyDiscount(finalPrice);
        }

        return finalPrice;
    }

}
