package ssafy0820;

import java.sql.*;

public class EmpDao extends EmpDB {
    public EmpDao() {
        super();    // Emp driver loading
    }

    public void addEmp(EmpDto emp) {
        String sql = "INSERT INTO s_emp(id, name, mailid, " +
                "start_date, manager_id, title, dept_id, salary, commission_pct) " +
                "VALUES(?, ?, ?, now(), ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement psmt = null;

        try {
            conn = getConnection();
            psmt = conn.prepareStatement(sql);
            int i = 1;
            psmt.setInt(i++, emp.getId());
            psmt.setString(i++, emp.getName());
            psmt.setString(i++, emp.getMailid());
            psmt.setInt(i++, emp.getManager_id());
            psmt.setString(i++, emp.getTitle());
            psmt.setInt(i++, emp.getDept_id());
            psmt.setDouble(i++, emp.getSalary());
            psmt.setDouble(i++, emp.getCommission_pct());

            psmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
