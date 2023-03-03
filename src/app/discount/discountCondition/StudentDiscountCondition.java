package app.discount.discountCondition;

import app.discount.discountPolicy.DiscountPolicy;

import java.util.Scanner;

public class StudentDiscountCondition implements DiscountCondition {
    private boolean isEligible=false;
    private DiscountPolicy discountPolicy;

    public StudentDiscountCondition(DiscountPolicy discountPolicy) {
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
        System.out.println("학생이십니까? (1)_예 (2)_아니오");
        if(scanner.nextLine().equals("1")) setEligible(true);
    }
    public int applyDiscount(int price){
        return discountPolicy.calculateDiscountedPrice(price);
    }
}
