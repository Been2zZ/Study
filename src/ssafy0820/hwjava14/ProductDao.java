package ssafy0820.hwjava14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDao extends ProductDB{
    public ProductDao() {
        super();        // Product driver loading
    }

    public void addProduct(Product product) {
        /**
         * 상품 정보 저장 OK
         */
        String sql = "INSERT INTO product(num, name, price, stock_count) VALUES(?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement psmt = null;

        try {
            conn = getConnection();
            psmt = conn.prepareStatement(sql);
            int i = 1;
            psmt.setInt(i++, product.getNum());
            psmt.setString(i++, product.getName());
            psmt.setInt(i++, product.getPrice());
            psmt.setInt(i++, product.getStock_count());
            psmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            close(conn, psmt, null);
        }
    }

    public void searchAllProduct() {
        /**
         * 상품 전체 정보 검색 OK
         */
        String sql = "SELECT * FROM product";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        Product p = null;

        try {
            conn = getConnection();
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                p = new Product();
                int i = 1;
                p.setNum(rs.getInt(i++));
                p.setName(rs.getString(i++));
                p.setPrice(rs.getInt(i++));
                p.setStock_count(rs.getInt(i++));
                System.out.println(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            close(conn, psmt, rs);
        }
    }

    public void searchNameProduct(String pName) {
        /**
         * 상품명 검색 OK
         */
        String sql = "SELECT * FROM product WHERE name LIKE ?";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        Product p = null;

        try {
            conn = getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, "%" + pName + "%");
            rs = psmt.executeQuery();
            while (rs.next()) {
                p = new Product();
                int i = 1;
                p.setNum(rs.getInt(i++));
                p.setName(rs.getString(i++));
                p.setPrice(rs.getInt(i++));
                p.setStock_count(rs.getInt(i++));
                System.out.println(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            close(conn, psmt, rs);
        }
    }

    public void searchPriceProduct(int pPrice) {
        /**
         * 상품 가격 검색 OK
         */
        String sql = "SELECT * FROM product WHERE price<=?";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        Product p = null;

        try {
            conn = getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, pPrice);
            rs = psmt.executeQuery();
            while (rs.next()) {
                p = new Product();
                int i = 1;
                p.setNum(rs.getInt(i++));
                p.setName(rs.getString(i++));
                p.setPrice(rs.getInt(i++));
                p.setStock_count(rs.getInt(i++));
                System.out.println(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            close(conn, psmt, rs);
        }
    }

    public void searchNumProduct(int pNum) {
        /**
         * 제품 번호로 검색 OK
         */
        String sql = "SELECT * FROM product WHERE num=?";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        Product p = null;

        try {
            conn = getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, pNum);
            rs = psmt.executeQuery();
            while (rs.next()) {
                p = new Product();
                int i = 1;
                p.setNum(rs.getInt(i++));
                p.setName(rs.getString(i++));
                p.setPrice(rs.getInt(i++));
                p.setStock_count(rs.getInt(i++));
                System.out.println(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            close(conn, psmt, rs);
        }
    }

    public void deleteNumProduct(int pNum) {
        /**
         * 제품 번호로 삭제 OK
         */
        String sql = "DELETE FROM product WHERE num=?";

        Connection conn = null;
        PreparedStatement psmt = null;

        try {
            conn = getConnection();
            psmt = conn.prepareStatement(sql);
            int i = 1;
            psmt.setInt(i++, pNum);
            psmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updatePriceProduct(int pNum, int newPrice) {
        /**
         * 제품 번호와 가격으로 같은 번호를 찾아 가격 업데이트 OK
         */
        String sql = "UPDATE product SET price=? WHERE num=?";

        Connection conn = null;
        PreparedStatement psmt = null;

        try {
            conn = getConnection();
            psmt = conn.prepareStatement(sql);
            int i = 1;
            psmt.setInt(i++, newPrice);
            psmt.setInt(i++, pNum);
            psmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
