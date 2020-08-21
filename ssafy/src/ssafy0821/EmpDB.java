package ssafy0821;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpDB {
	String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/ssafyemp?useUniCode=yes&characterEncoding=UTF-8&serverTimezone=Asia/Seoul&useSSL=false";
    String user = "ssafy4";
    String pass = "ssafy4";
    
    public EmpDB() {
        try {
            Class.forName(driver);
           log("1/6 S");
        } catch (ClassNotFoundException e) {
        	log("1/6 F", e);
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, pass);
        return conn;
    }

    public void close(Connection conn, Statement psmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            	log("", e);
            }
        }
        if (psmt != null) {
            try {
                psmt.close();
            } catch (SQLException e) {
            	log("", e);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            	log("", e);
            }
        }
    }
    
    public void log(String msg) {
		System.out.println(this.getClass() + " : " + msg);
	}
    
    public void log(String msg, Exception e) {
		System.out.println(this.getClass() + " : " + msg + " : " + e);
	}
}
