import java.util.Objects;

public class Product {
    private String productNo;
    private String name;
    private int price;

    public Product(String productNo, String name, int price) {
        this.productNo = productNo;
        this.name = name;
        this.price = price;
    }
    public String getProductNo() {
        return productNo;
    }
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(productNo, product.productNo) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, name, price);
    }
}
