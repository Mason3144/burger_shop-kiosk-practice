package app;

import app.product.Product;
import app.product.subProduct.Drink;
import app.product.subProduct.Hamburger;
import app.product.subProduct.Side;


public class Menu {
    private Product[] products;

    public Menu(Product[] products) {
        this.products = products;
    }

    public void printMenu(){
        System.out.println("[🎈] 메뉴");
        System.out.println("-".repeat(50));

        printHamburger();
        printSide();
        printDrink();
        System.out.println();

        System.out.println("🧺 (0) 장바구니");
        System.out.println("💰 (+) 주문하기");
        System.out.println("-".repeat(50));
        System.out.println("[😊] 메뉴를 선택해주세요 : ");

    }

    public void printDrink() {
        System.out.println("🥤 음료");
        for(Product product: products){
            if(product instanceof Drink) {
                printEachMenu(product);
            }
        }
        System.out.println();
    }

    public void printSide() {
        System.out.println("🍟 사이드");
        for(Product product: products){
            if(product instanceof Side) {
                printEachMenu(product);
            }
        }
        System.out.println();
    }

    private void printHamburger() {
        System.out.println("🍔 햄버거");
        for(Product product: products){
            if(product instanceof Hamburger) {
                printEachMenu(product);
            }
        }
        System.out.println();
    }

    private static void printEachMenu(Product product) {
        System.out.printf("(%d) %s  %dKcal  %d원\n",
                product.getId(),
                product.getName(),
                product.getCal(),
                product.getPrice()
        );
    }

}
