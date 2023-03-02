package app;

import app.product.Product;
import app.product.ProductRepository;


public class Kiosk {

    void operate(){
        ProductRepository productRepository = new ProductRepository();
        Product[] products = productRepository.getProducts();
        Menu menu = new Menu(products);

        //메뉴 출력
        menu.printMenu();


    };

}

/*
* 메뉴 출력
* 메뉴선택 - 옵션선택 - 장바구니 담기 - 다시 메뉴출력
* 장바구니 선택 - 장바구니출력 - 다시 메뉴출력
* 주문하기 선택 - 주문 내역 출력 - 종료
* */