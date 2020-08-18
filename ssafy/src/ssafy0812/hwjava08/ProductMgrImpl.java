package ssafy0812.hwjava08;

import java.util.ArrayList;

public class ProductMgrImpl implements IProductMgr {

    private static ProductMgrImpl mgr = new ProductMgrImpl();

    private ProductMgrImpl() {		}

    public static ProductMgrImpl getInstance() {	return mgr;	}

    /** Singleton */

    // 상품을 저장할 Product[] 생성
    private ArrayList<Product> products = new ArrayList<>();

    @Override
    public void add(Product p) throws DuplicateException {
        if (p == null) return;
        
	    if(products.contains(p)) 	// contains -> equals 
	        throw new DuplicateException(p.getName() + "은(는) 이미 존재하는 상품입니다.");
	 
        products.add(p);
    }

    @Override
    public ArrayList<Product> getAllProduct() {
        return products;
    }

    @Override
    public void searchNum(int num) throws CodeNotFoundException {
        // 상품번호로 검색하는 기능
        int chk = 0;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getNum() == num) {
                chk = 1;
                System.out.println(products.get(i).toString());
            }
        }

        if (chk != 1)
        	throw new CodeNotFoundException("상품번호 " + num + " 과(와) 일치하는 상품이 존재하지 않습니다.");
    }

    @Override
    public void searchName(String name) {
        // 상품명으로 상품을 검색하는 기능
        int chk = 0;

        for (int i = 0; i < products.size(); i++) {
            String productName = products.get(i).getName();
            if (productName.contains(name)) {
                chk = 1;
                System.out.println(products.get(i).toString());
            }
        }

        if (chk != 1)
            System.out.println("상품이름 " + name + " 과(와) 일치하는 상품이 존재하지 않습니다.");
    }

    @Override
    public ArrayList<Product> getAllTV() {
        int cnt = 0;

        ArrayList<Product> TV = new ArrayList<>();

        for (int i = 0; i < products.size(); i++)
            if (products.get(i) instanceof TV)
                TV.add(products.get(i));

        return TV;
    }

    @Override
    public ArrayList<Product> getAllRefrigerator() {
        int cnt = 0;

        ArrayList<Product> Refrigerator = new ArrayList<>();

        for (int i = 0; i < products.size(); i++)
            if (products.get(i) instanceof Refrigerator)
                Refrigerator.add(products.get(i));

        return Refrigerator;
    }

    @Override
    public ArrayList<Product> getRefrigerator_400LUp() throws ProductNotFoundException {
        ArrayList<Product> Refrigerator_400up = new ArrayList<>();

        int cnt = 0;
        
        for (int i = 0; i < products.size(); i++) 
            if (products.get(i) instanceof Refrigerator)
                if (((Refrigerator) products.get(i)).getVolume() >= 400) {
                	cnt++;
                    Refrigerator_400up.add(products.get(i));
                }

       if (cnt == 0)
    	   throw new ProductNotFoundException("400L 이상의 용량을 가진 냉장고가 존재하지 않습니다.");
            
        return Refrigerator_400up;
    }

    @Override
    public ArrayList<Product> getTV_50inchUp() throws ProductNotFoundException {
        ArrayList<Product> TV_50up = new ArrayList<>();

        int cnt = 0;
        
        for (int i = 0; i < products.size(); i++)
            if (products.get(i) instanceof TV)
	            if (((TV)(products.get(i))).getInch() >= 50) {
	            	cnt++;
	                TV_50up.add(products.get(i));
	             }
        
        if (cnt == 0)
     	   throw new ProductNotFoundException("50inch 이상의 디스플레이를 가진 TV가 존재하지 않습니다.");

        return TV_50up;
    }

    @Override
    public Product modPrice(int num, int newPrice) {
        int idx = -1;

        for (int i = 0; i < products.size(); i++)
            if (products.get(i).getNum() == num) {
                idx = i;
                products.get(i).setPrice(newPrice);
            }

        if (idx == -1)
            return null;

        return products.get(idx);
    }

    @Override
    public void delete(int num) {
        // 상품번호로 삭제하는 기능
        int j = 0, chk = 0;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getNum() == num) {
                chk = 1;
                j = i;
                products.remove(i);
                System.out.println("상품번호 " + num + " 에 해당하는 상품을 삭제하였습니다.");
            }
        }

        if (chk != 1)
            System.out.println("상품번호 " + num + " 과(와) 일치하는 상품이 존재하지 않습니다.");

    }

    @Override
    public long stockPrice() {
        long price = 0;

        for (int i = 0; i < products.size(); i++)
            price += products.get(i).getCnt() * products.get(i).getPrice();

        return price;
    }
}
