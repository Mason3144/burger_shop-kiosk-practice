package app.discount.discountCondition;

import app.discount.discountPolicy.FixedAmountDiscountPolicy;
import app.discount.discountPolicy.FixedRateDiscountPolicy;

import java.util.Scanner;

public class TeenDiscountCondition  {
    // 500원 할인
    private boolean isEligible=false;
    private FixedAmountDiscountPolicy fixedAmountDiscountPolicy= new FixedAmountDiscountPolicy(500);

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
        return fixedAmountDiscountPolicy.calculateDiscountedPrice(price);
    }
}
