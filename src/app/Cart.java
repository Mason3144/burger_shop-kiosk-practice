package app;

import app.product.Product;
import app.product.subProduct.BurgerSet;
import app.product.subProduct.Drink;
import app.product.subProduct.Hamburger;
import app.product.subProduct.Side;

import java.util.Scanner;


public class Cart {
    private Product[] items = new Product[0];
    private Scanner scanner = new Scanner(System.in);

    public void printCart() {
        int totalPrice=0;
        System.out.println("🧺 장바구니");
        System.out.println("-".repeat(50));

        for(Product item:items){
            if(item instanceof BurgerSet){
                BurgerSet burgerSet = (BurgerSet) item;
                System.out.printf("%-10s %d원 (%s(케첩 %d개), %s(빨대 %s))\n",
                        item.getName(),
                        item.getPrice(),
                        burgerSet.getSide().getName(),
                        burgerSet.getSide().getKetchup(),
                        burgerSet.getDrink().getName(),
                        burgerSet.getDrink().hasstraw() ? "있음" : "없음"
                );
            }
            else System.out.printf("%-10s %d원 ",item.getName(),item.getPrice());

            if(item instanceof Hamburger) System.out.printf("(단품)\n");
            else if(item instanceof Side) System.out.printf("(케첩 %d)\n",((Side) item).getKetchup());
            else if (item instanceof Drink) System.out.printf("(빨대 %s)\n",((Drink) item).hasstraw()?"있음":"없음");

            totalPrice += item.getPrice();
        }

        System.out.println("-".repeat(50));
        System.out.printf("합계 : %d원\n", totalPrice);

        System.out.println("이전으로 돌아가려면 엔터를 누르세요. ");
        scanner.nextLine();
    }

    public void addToCart(int productId){


    };


}
