package app;

import app.discount.Discount;
import app.discount.discountCondition.DiscountCondition;
import app.discount.discountCondition.StudentDiscountCondition;
import app.discount.discountCondition.TeenDiscountCondition;
import app.discount.discountPolicy.FixedAmountDiscountPolicy;
import app.discount.discountPolicy.FixedRateDiscountPolicy;
import app.product.Product;
import app.product.ProductRepository;

import java.util.Scanner;

public class Kiosk {
    private ProductRepository productRepository;
    private Menu menu;
    private Cart cart;
    private Order order;

    public Kiosk(ProductRepository productRepository, Menu menu, Cart cart, Order order) {
        this.productRepository = productRepository;
        this.menu = menu;
        this.cart = cart;
        this.order = order;
    }

    void operate(){
        Scanner scanner = new Scanner(System.in);


        while(true){
            //메뉴 출력
            menu.printMenu();

            //메뉴선택-옵션선택- 장바구니 담기
            String input = scanner.nextLine();
            if(input.equals("+")){
                order.makeOrder();
                break;
            }else {
                try{ // 만약 인풋이 숫자형 데이터가 아니라면 Integer.parseInt()메서드에서 오류가 나기때문에 try catch문을 사용하여 오류를 잡아준다.
                    int menuNum = Integer.parseInt(input);
                    if(menuNum==0) cart.printCart();
                    else if(menuNum>0 && menuNum <= productRepository.getProducts().length) cart.addToCart(menuNum);
                    else System.out.println("잘못된 입력입니다. [enter]를 눌러 초기메뉴로 돌아가주세요.");
                }catch(NumberFormatException ex){
                    System.out.println("잘못된 입력입니다. [enter]를 눌러 초기메뉴로 돌아가주세요.");
                }
                scanner.nextLine();
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