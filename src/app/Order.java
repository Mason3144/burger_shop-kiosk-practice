package app;

import app.discount.Discount;


public class Order {
    private Cart cart;
    private Discount discount;


    public Order(Cart cart,Discount discount) {
        this.cart = cart;
        this.discount = discount;
    }

    public void makeOrder(){
        System.out.println("[😊] 주문이 완료되었습니다.");
        System.out.println("[😊] 주문 내역은 다음과 같습니다.");
        cart.printCartDetail();

        int finalPrice = discount.discount(cart.getTotalPrice());

        System.out.printf("할인 적용 금액 : %d원\n", finalPrice);

        System.out.println("[😊] 이용해주셔서 감사합니다.");

    }
}
