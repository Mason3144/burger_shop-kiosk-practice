package app;

import app.discount.discountCondition.StudentDiscountCondition;
import app.discount.discountCondition.TeenDiscountCondition;

public class Order {
    private Cart cart;

    public Order(Cart cart) {
        this.cart = cart;
    }

    public void makeOrder(){
        TeenDiscountCondition teenDiscountCondition = new TeenDiscountCondition();
        StudentDiscountCondition studentDiscountCondition = new StudentDiscountCondition();

        studentDiscountCondition.checkDiscountCondition();
        teenDiscountCondition.checkDiscountCondition();

        System.out.println("[😊] 주문이 완료되었습니다.");
        System.out.println("[😊] 주문 내역은 다음과 같습니다.");
        cart.printCartDetail();

        int finalPrice = cart.getTotalPrice();
        if(teenDiscountCondition.getIsEligible()) finalPrice = teenDiscountCondition.applyDiscount(finalPrice);
        if(studentDiscountCondition.getIsEligible()) finalPrice = studentDiscountCondition.applyDiscount(finalPrice);
        System.out.printf("할인 적용 금액 : %d원\n", finalPrice);

        System.out.println("[😊] 이용해주셔서 감사합니다.");

    }
}
