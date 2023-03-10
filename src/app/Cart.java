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
        System.out.println("๐งบ ์ฅ๋ฐ๊ตฌ๋");
        printCartDetail();

        System.out.println("์ด์ ์ผ๋ก ๋์๊ฐ๋ ค๋ฉด ์ํฐ๋ฅผ ๋๋ฅด์ธ์. ");
        scanner.nextLine();

    }

    protected void printCartDetail() {
        System.out.println("-".repeat(50));

        for(Product item:items){
            if(item instanceof BurgerSet){
                BurgerSet burgerSet = (BurgerSet) item;
                System.out.printf("%-10s %d์ (%s(์ผ์ฒฉ %d๊ฐ), %s(๋นจ๋ %s))\n",
                        item.getName(),
                        item.getPrice(),
                        burgerSet.getSide().getName(),
                        burgerSet.getSide().getKetchup(),
                        burgerSet.getDrink().getName(),
                        burgerSet.getDrink().hasstraw() ? "์์" : "์์"
                );
            }
            else System.out.printf("%-10s %d์ ",item.getName(),item.getPrice());

            if(item instanceof Hamburger) System.out.printf("(๋จํ)\n");
            else if(item instanceof Side) System.out.printf("(์ผ์ฒฉ %d)\n",((Side) item).getKetchup());
            else if (item instanceof Drink) System.out.printf("(๋นจ๋ %s)\n",((Drink) item).hasstraw()?"์์":"์์");

            totalPrice += item.getPrice();
        }

        System.out.println("-".repeat(50));
        System.out.printf("๊ธ์ก ํฉ๊ณ : %d์\n", totalPrice);
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void addToCart(int productId){
        Product product = productRepository.findById(productId);


        // ๊ธฐ์กด์ ์ธ์คํด์ค๋ฅผ ์ฌ์ฉํ๊ฒ๋๋ฉด ์์ดํ์ ์ค๋ณต์ ํํ ์ ์ต์๊ฐ์ด ๋์ผํ๊ฒ ์ ์ฉ๋๋ค.
        // ๊ทธ๋ฌ๋ฏ๋ก ๊ธฐ์กด์ productRepository์ ์ ์ฅ๋ ์ธ์คํด์ค๊ฐ ์๋ ์๋ก์ด ์ธ์คํด์ค๋ฅผ ์์ฑํ์ฌ ์ฅ๋ฐ๊ตฌ๋์ ์ ์ฅ
        if(product instanceof Hamburger) product = new Hamburger((Hamburger) product);
        else if(product instanceof Side) product = new Side((Side) product);
        else if(product instanceof Drink) product = new Drink((Drink) product);

        chooseOption(product);

        if(product instanceof  Hamburger){
            Hamburger hamburger = (Hamburger) product;
            if(hamburger.isBurgerSet()) product = composeSet(hamburger);
        }

        items = Arrays.copyOf(items,items.length+1);
        items[items.length-1] = product;
        System.out.printf("[๐] %s๋ฅผ(์) ์ฅ๋ฐ๊ตฌ๋์ ๋ด์์ต๋๋ค. [enter]๋ฅผ ๋๋ฌ ์ด๊ธฐ๋ฉ๋ด๋ก ๋์๊ฐ์ฃผ์ธ์.\n",product.getName());
        scanner.nextLine();
    };



    private void chooseOption(Product product){
      // ๊ฐ ํด๋์ค๋ค์์ ๊ตฌํํด๋ณด๊ธฐ
        if(product instanceof Hamburger){
            System.out.printf("๋จํ์ผ๋ก ์ฃผ๋ฌธํ์๊ฒ ์ด์? (1)_๋จํ(%d์) (2)_์ธํธ(%d์)\n", product.getPrice(),((Hamburger) product).getburgerSetPrice());
            if(Integer.parseInt(scanner.nextLine())==2) ((Hamburger) product).setBurgerSet(true);
        } else if (product instanceof Side) {
            System.out.println("์ผ์ฐน์ ๋ช๊ฐ๊ฐ ํ์ํ์ ๊ฐ์?");
            ((Side) product).setKetchup(Integer.parseInt(scanner.nextLine()));
        }else if (product instanceof Drink){
            System.out.println("๋นจ๋๊ฐ ํ์ํ์ ๊ฐ์? (1)_์ (2)_์๋์ค");
            if(Integer.parseInt(scanner.nextLine())==2) ((Drink) product).setHasstraw(false);
        }
    }
    private BurgerSet composeSet(Hamburger hamburger){
        System.out.println("์ฌ์ด๋๋ฅผ ๊ณจ๋ผ์ฃผ์ธ์");
        menu.printSide();
        Side side = (Side) productRepository.findById(Integer.parseInt(scanner.nextLine()));
        side = new Side(side); // ๊ธฐ์กด์ productRepository์ ์ ์ฅ๋ ์ธ์คํด์ค๊ฐ ์๋ ์๋ก์ด ์ธ์คํด์ค๋ฅผ ์์ฑํ์ฌ ์ฅ๋ฐ๊ตฌ๋์ ์ ์ฅ
        chooseOption(side);

        System.out.println("์๋ฃ๋ฅผ ๊ณจ๋ผ์ฃผ์ธ์");
        menu.printDrink();
        Drink drink = (Drink) productRepository.findById(Integer.parseInt(scanner.nextLine()));
        drink = new Drink(drink);
        chooseOption(drink);

        return new BurgerSet(
                hamburger.getName()+"์ธํธ",
                hamburger.getCal()+side.getCal()+drink.getCal(),
                hamburger.getburgerSetPrice(),
                hamburger,
                side,
                drink
        );

    }

}
