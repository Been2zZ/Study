package ssafy0812.hwjava08;

import java.util.ArrayList;

public interface IProductMgr {
    void add(Product p) throws DuplicateException;       		// 상품 정보 저장
    ArrayList<Product> getAllProduct();     					// 상품 정보 전체 검색
    void searchNum(int num) throws CodeNotFoundException;		// 상품 번호로 상품 검색
    void searchName(String name);           					// 상품명으로 상품 검색
    ArrayList<Product> getAllTV();                   // TV 정보 검색
    ArrayList<Product> getAllRefrigerator();         // Refrigerator 정보 검색
    ArrayList<Product> getRefrigerator_400LUp()
    		throws ProductNotFoundException;    // 400L 이상의 Refrigerator 검색
    ArrayList<Product> getTV_50inchUp()
    		throws ProductNotFoundException;    // 50inch 이상의 TV 검색
    Product modPrice(int num, int newPrice);   	// 상품 가격 변경
    void delete(int num);                   	// 상품 번호로 상품 삭제
    long stockPrice();                       	// 전체 재고 상품 금액
}
