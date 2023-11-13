import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * I/O 스트림을 사용하여 csv 파일로부터 상품 목록을 불러올 수 있도록 장바구니 앱을 수정
 */
public class Main2 {
    public static void main(String[] args) {
        // 상품 목록 생성
        Set<Product> productSet = new HashSet<>();

        // TODO : 상품 클래스를 생성하여 상품 목록에 넣는다.
        // CSV read
        BufferedReader br = null;
        String line;
        String path = "/Users/goorm/Desktop/과제/GoormTask/backend/shoppingCart/src/data.csv";
        List<Product> myProducts = new ArrayList<>(); // 추후 접근을 위해 선언

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
            // 한 줄씩 읽기
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");

                Product product = new Product(temp[0], temp[1], Integer.parseInt(temp[2]));
                productSet.add(product);

                myProducts.add(product);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        // 상품 목록 확인
        System.out.println("고유한 상품 목록 : ");
        for (Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice() + "원");
        }

        // 장바구니 생성
        Cart myCart = new Cart();

        // TODO : 상품을 장바구니에 추가
        myCart.addProduct(myProducts.get(0), 1);
        myCart.addProduct(myProducts.get(1), 4);
        myCart.addProduct(myProducts.get(2), 4);
        myCart.showItems();
        myCart.totalPrice();
        // TODO : 상품을 장바구니에서 제거

        myCart.removeProduct(myProducts.get(2), 3);
        // TODO : 장바구니에 현재 담긴 상품들을 출력(상품 이름, 각 상품의 갯수)
        myCart.showItems();
        myCart.totalPrice();


    }
}
