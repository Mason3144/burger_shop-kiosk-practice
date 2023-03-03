package app.discount.discountCondition;

import app.discount.discountPolicy.FixedRateDiscountPolicy;

import java.util.Scanner;

public class StudentDiscountCondition  {
    //10%할인

    // 종합 policy만들어서 통합해보기
    /*
    * 할인 조건 검사 → checkDiscountCondition() 메서드
        할인 조건 검사 결과 → isSatisfied 필드
        적용시킬 할인 정책 → fixedRateDiscountPolicy / fixedAmountDiscountPolicy 필드
        할인 적용 → applyDiscount() 메서드
    * */
    private boolean isEligible=false;
    private FixedRateDiscountPolicy fixedRateDiscountPolicy= new FixedRateDiscountPolicy(10);

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
        return fixedRateDiscountPolicy.calculateDiscountedPrice(price);
    }
}
