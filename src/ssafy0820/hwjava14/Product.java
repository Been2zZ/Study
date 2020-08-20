package ssafy0820.hwjava14;

public class Product {
    private int num;            // 제품 번호
    private String name;        // 제품명
    private int price;          // 가격
    private int stock_count;    // 재고 수량

    public Product() {

    }

    public Product(int num, String name, int price) {
        this.num = num;
        this.name = name;
        this.price = price;
    }

    public Product(int num, String name, int price, int stock_count) {
        this.num = num;
        this.name = name;
        this.price = price;
        this.stock_count = stock_count;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock_count() {
        return stock_count;
    }

    public void setStock_count(int stock_count) {
        this.stock_count = stock_count;
    }

    @Override
    public String toString() {
        return "Product{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock_count=" + stock_count +
                '}';
    }
}
