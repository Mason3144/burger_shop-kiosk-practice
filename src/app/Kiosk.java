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

        Cart cart = new Cart(productRepository,menu);


        while(true){
            //메뉴 출력
            menu.printMenu();

            //메뉴선택
            String input = scanner.nextLine();
            if(input.equals("+")){

                break;
            }else {
                int menuNum = Integer.parseInt(input);
                if(menuNum==0) cart.printCart();
                else if(menuNum>0 && menuNum <= products.length) cart.addToCart(menuNum);
                else System.out.println("잘못된 입력입니다. [enter]를 눌러 초기메뉴로 돌아가주세요.");
            }
        }




    };

}

/*
* 메뉴 출력
* 메뉴선택 - 옵션선택 - 장바구니 담기 - 다시 메뉴출력
* 장바구니 선택 - 장바구니출력 - 다시 메뉴출력
* 주문하기 선택 - 주문 내역 출력 - 종료
* */