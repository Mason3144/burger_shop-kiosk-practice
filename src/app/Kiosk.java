package app;

import app.product.Product;
import app.product.ProductRepository;

import java.util.Scanner;

public class Kiosk {

    void operate(){
        Scanner scanner = new Scanner(System.in);

        ProductRepository productRepository = new ProductRepository();
        Product[] products = productRepository.getProducts();

        Menu menu = new Menu(products);

        Cart cart = new Cart();


        while(true){
            //메뉴 출력
            menu.printMenu();
            String input = scanner.nextLine();
            cart.addToCart(Integer.parseInt(input));

            break;
        }




    };

}

/*
* 메뉴 출력
* 메뉴선택 - 옵션선택 - 장바구니 담기 - 다시 메뉴출력
* 장바구니 선택 - 장바구니출력 - 다시 메뉴출력
* 주문하기 선택 - 주문 내역 출력 - 종료
* */