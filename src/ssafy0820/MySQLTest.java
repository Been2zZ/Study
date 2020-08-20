package ssafy0820;

import java.sql.*;

/**
 * spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
 * spring.datasource.url=jdbc:mysql://localhost:3306/ssafyhrm?useUniCode=yes&characterEncoding=UTF-8&serverTimezone=Asia/Seoul
 * spring.datasource.username=ssafy
 * spring.datasource.password=ssafy
 */
public class MySQLTest {
    public static void main(String[] args) {
        // 1. Driver loading
        // 2. DB 연결
        // 3. 쿼리 준비
        // 4. 쿼리 날려
        // 5. 결과
        // 6. close
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("1/6");
            String url = "jdbc:mysql://localhost:3306/ssafy4?useUniCode=yes&characterEncoding=UTF-8&serverTimezone=Asia/Seoul&useSSL=false";
            String user = "ssafy4";
            String pass = "ssafy4";
            Connection conn = DriverManager.getConnection(url, user, pass);
            System.out.println("2/6");
            String sql = "SELECT * FROM EMP";
            PreparedStatement psmt = conn.prepareStatement(sql);
            System.out.println("3/6");
            ResultSet rs = psmt.executeQuery();
            System.out.println("4/6");
            while (rs.next()) {
                String empno = rs.getString(1);
                String ename = rs.getString(2);
                System.out.println(empno + "\t" + ename);
            }
            System.out.println("5/6");
            if (rs != null) {
                rs.close();
            }
            if (psmt != null) {
                psmt.close();
            }
            if (conn != null) {
                conn.close();
            }
            System.out.println("6/6");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
