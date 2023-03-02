package app;

import app.product.Product;
import app.product.ProductRepository;
import app.product.subProduct.BurgerSet;
import app.product.subProduct.Drink;
import app.product.subProduct.Hamburger;
import app.product.subProduct.Side;

import java.util.Arrays;
import java.util.Scanner;


public class Cart {
    private Product[] items= new Product[]{};
    private ProductRepository productRepository;
    private Menu menu;
    private int totalPrice=0;
    private Scanner scanner = new Scanner(System.in);

    public Cart(ProductRepository productRepository,Menu menu) {
        this.productRepository = productRepository;
        this.menu = menu;
    }

    public void printCart() {
        System.out.println();
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

    }

    public void addToCart(int productId){
        Product product = productRepository.findById(productId);

        // 새로운 메소드를 만들어 product에 새로운객체를 생성한뒤 할당


        chooseOption(product);

        if(product instanceof  Hamburger){
            Hamburger hamburger = (Hamburger) product;
            if(hamburger.isBurgerSet()) product = composeSet(hamburger);
        }

        items = Arrays.copyOf(items,items.length+1);
        items[items.length-1] = product;
        System.out.printf("[😊] %s를(을) 장바구니에 담았습니다. [enter]를 눌러 초기메뉴로 돌아가주세요.\n",product.getName());
        System.out.println();
    };



    private void chooseOption(Product product){
      // 각 클래스들에서 구현해보기
        if(product instanceof Hamburger){
            System.out.printf("단품으로 주문하시겠어요? (1)_단품(%d원) (2)_세트(%d원)\n", product.getPrice(),((Hamburger) product).getburgerSetPrice());
            if(Integer.parseInt(scanner.nextLine())==2) ((Hamburger) product).setBurgerSet(true);
        } else if (product instanceof Side) {
            System.out.println("케찹은 몇개가 필요하신가요?");
            ((Side) product).setKetchup(Integer.parseInt(scanner.nextLine()));
        }else if (product instanceof Drink){
            System.out.println("빨대가 필요하신가요? (1)_예 (2)_아니오");
            if(Integer.parseInt(scanner.nextLine())==2) ((Drink) product).setHasstraw(false);
        }







    }
    private BurgerSet composeSet(Hamburger hamburger){
        System.out.println("사이드를 골라주세요");
        menu.printSide();
        Side side = (Side) productRepository.findById(Integer.parseInt(scanner.nextLine()));
        chooseOption(side);

        System.out.println("음료를 골라주세요");
        menu.printDrink();
        Drink drink = (Drink) productRepository.findById(Integer.parseInt(scanner.nextLine()));
        chooseOption(drink);

        return new BurgerSet(
                hamburger.getName()+"세트",
                hamburger.getburgerSetPrice(),
                hamburger.getCal()+side.getCal()+drink.getCal(),
                hamburger,
                side,
                drink
        );

    }

}
