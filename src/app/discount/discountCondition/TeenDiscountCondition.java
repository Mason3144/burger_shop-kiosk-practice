package app.discount.discountCondition;

import app.discount.discountPolicy.DiscountPolicy;

import java.util.Scanner;

public class TeenDiscountCondition implements DiscountCondition {
    // 500원 할인
    private boolean isEligible=false;
    private DiscountPolicy discountPolicy;

    public TeenDiscountCondition(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public boolean getIsEligible() {
        return isEligible;
    }
    private void setEligible(boolean eligible) {
        isEligible = eligible;
    }
    public void checkDiscountCondition(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("19세 미만이신가요? (1)_예 (2)_아니오");
        if(scanner.nextLine().equals("1")) setEligible(true);
    }
    public int applyDiscount(int price){
        return discountPolicy.calculateDiscountedPrice(price);
    }
}
