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
        System.out.println("[π] μ£Όλ¬Έμ΄ μλ£λμμ΅λλ€.");
        System.out.println("[π] μ£Όλ¬Έ λ΄μ­μ λ€μκ³Ό κ°μ΅λλ€.");
        cart.printCartDetail();

        int finalPrice = discount.discount(cart.getTotalPrice());

        System.out.printf("ν μΈ μ μ© κΈμ‘ : %dμ\n", finalPrice);

        System.out.println("[π] μ΄μ©ν΄μ£Όμμ κ°μ¬ν©λλ€.");

    }
}
