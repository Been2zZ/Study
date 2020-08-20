package ssafy0820;

import java.sql.*;

public abstract class EmpDB {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/ssafy4?useUniCode=yes&characterEncoding=UTF-8&serverTimezone=Asia/Seoul&useSSL=false";
    String user = "ssafy4";
    String pass = "ssafy4";

    public EmpDB() {
        try {
            Class.forName(driver);
            System.out.println("1/6");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(url, user, pass);
        return conn;
    }

    public void close(Connection conn, Statement psmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        if (psmt != null) {
            try {
                psmt.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
