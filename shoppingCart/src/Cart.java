import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>(); // 우유 2개, 화장지 3개

    public void addProduct(Product product, int count) {
        items.put(product, items.getOrDefault(product, 0) + count);

    }

    public void removeProduct(Product product, int count) {
        int currentCount = items.getOrDefault(product, 0);
        if (currentCount <= count) {
            items.remove(product);
        }
        else {
            items.put(product, currentCount - count);
        }
    }
    public void showItems() {
        System.out.println("=================상품 목록=====================");

        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey().getName() + " : " + entry.getValue() + "개");
        }

    }
//    public int totalPrice() {
//        int total = 0;
//        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
//            total += entry.getKey().getPrice() * entry.getValue();
//        }
//        return total;
//    }
    public void totalPrice() {
        int total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {

            total += entry.getKey().getPrice() * entry.getValue();

        }
        System.out.println("상품 총 가격 : " + total + "원");

    }


}
