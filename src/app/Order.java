package app;

public class Order {
    private Cart cart;

    public Order(Cart cart) {
        this.cart = cart;
    }

    public void makeOrder(){
        System.out.println("[😊] 주문이 완료되었습니다.");
        System.out.println("[😊] 주문 내역은 다음과 같습니다.");
        cart.printCartDetail();
        System.out.println("[😊] 이용해주셔서 감사합니다.");


    }
}
