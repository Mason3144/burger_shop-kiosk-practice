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
        System.out.println("[π] λ©λ΄");
        System.out.println("-".repeat(50));

        printHamburger();
        printSide();
        printDrink();
        System.out.println();

        System.out.println("π§Ί (0) μ₯λ°κ΅¬λ");
        System.out.println("π° (+) μ£Όλ¬ΈνκΈ°");
        System.out.println("-".repeat(50));
        System.out.println("[π] λ©λ΄λ₯Ό μ νν΄μ£ΌμΈμ : ");

    }

    public void printDrink() {
        System.out.println("π₯€ μλ£");
        for(Product product: products){
            if(product instanceof Drink) {
                printEachMenu(product);
            }
        }
        System.out.println();
    }

    public void printSide() {
        System.out.println("π μ¬μ΄λ");
        for(Product product: products){
            if(product instanceof Side) {
                printEachMenu(product);
            }
        }
        System.out.println();
    }

    private void printHamburger() {
        System.out.println("π νλ²κ±°");
        for(Product product: products){
            if(product instanceof Hamburger) {
                printEachMenu(product);
            }
        }
        System.out.println();
    }

    private static void printEachMenu(Product product) {
        System.out.printf("(%d) %s  %dKcal  %dμ\n",
                product.getId(),
                product.getName(),
                product.getCal(),
                product.getPrice()
        );
    }

}
