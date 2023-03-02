package app.product;

public abstract class Product {
    private int id;
    private String name;
    private int cal;
    private int price;

    public Product(int id, String name, int cal, int price) {
        this.id = id;
        this.name = name;
        this.cal = cal;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCal() {
        return cal;
    }

    public int getPrice() {
        return price;
    }

}
