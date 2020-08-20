package ssafy0820.hwjava14;

public class ProductTest {
    public static void main(String[] args) {
        ProductDao dao = new ProductDao();

        /**
         * 상품 정보 저장
         */
        dao.addProduct(new Product(1, "Galaxy A10", 100000, 31));
        dao.addProduct(new Product(2, "Galaxy A31", 200000, 27));
        dao.addProduct(new Product(3, "Galaxy A51", 300000, 129));
        dao.addProduct(new Product(4, "Galaxy A21s", 400000, 82));
        dao.addProduct(new Product(5, "Galaxy S20+", 500000, 118));
        dao.addProduct(new Product(6, "Galaxy S20", 600000, 213));
        dao.addProduct(new Product(7, "Galaxy Note9", 700000, 252));
        dao.addProduct(new Product(8, "Galaxy Note10", 800000, 11));
        dao.addProduct(new Product(9, "Galaxy Note20", 900000, 27));

        /**
         * 삼품 전체 정보 검색
         */
        dao.searchAllProduct();
        System.out.println("====================================================");
        /**
         * 상품명 검색
         */
        dao.searchNameProduct("Note");
        System.out.println("====================================================");

        /**
         * 상품 가격 검색
         */
        dao.searchPriceProduct(500000);
        System.out.println("====================================================");

        /**
         * 제품 번호 검색
         */
        dao.searchNumProduct(7);
        System.out.println("====================================================");

        /**
         * 제품 번호 삭제
         */
        dao.deleteNumProduct(3);
        dao.searchAllProduct();
        System.out.println("====================================================");

        /**
         * 제품 가격 업데이트
         */
        dao.updatePriceProduct(2, 99999);
        dao.searchAllProduct();
        System.out.println("====================================================");
    }
}
