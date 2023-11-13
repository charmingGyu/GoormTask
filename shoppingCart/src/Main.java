import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Product> productSet = new HashSet<>();

        Product product1 = new Product("1", "바나나", 3000);
        Product product2 = new Product("2", "사과", 4000);
        Product product3 = new Product("3", "키위", 50000);

        productSet.add(product1);
        productSet.add(product2);
        productSet.add(product3);

        System.out.println("고유한 상품 목록 : ");
        for (Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
//            System.out.println("총 가격 : " + product.getPrice());
        }

        Cart myCart = new Cart();


        // TODO: 상품을 장바구니에 추가
        myCart.addProduct(product1, 5); // 바나나 5
        myCart.addProduct(product2, 4); // 사과 2개
//        myCart.addProduct(product2, 4); // 사과 4개 더 추가
        myCart.addProduct(product3, 4); // 사과 4개 더 추가

//        System.out.println("추가");
        myCart.showItems();
        myCart.totalPrice();



        // TODO : 상품을 장바구니에서 제거
        myCart.removeProduct(product2, 3); // 사과 3개 제거
//        System.out.println("제거");
        myCart.showItems();
        myCart.totalPrice();


        // TODO : 장바구니에 현재 담긴 상품들을 출력(상품이름, 각 상품의 갯수)
        myCart.showItems();
        myCart.totalPrice();

//        System.out.println("상품 총 가격 : " + myCart.totalPrice() + "원");
        }


    }
