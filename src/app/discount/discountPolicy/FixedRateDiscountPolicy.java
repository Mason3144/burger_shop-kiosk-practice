package app.discount.discountPolicy;

public class FixedRateDiscountPolicy {
    private int discountRate;

    public FixedRateDiscountPolicy(int discountRate) {
        this.discountRate = discountRate;
    }

    public int calculateDiscountedPrice(int price){
        return price - (price * this.discountRate/100);
    }
}
