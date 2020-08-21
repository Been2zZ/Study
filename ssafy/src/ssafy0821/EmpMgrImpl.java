package ssafy0821;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpMgrImpl extends EmpDB implements EmpMgr {

	/** Singleton */
	private static EmpMgrImpl dao = new EmpMgrImpl();
	
	private EmpMgrImpl() {	super();	}
	
	public static EmpMgrImpl getInstance() {	return dao;	}
	/** Singleton */
	
	
	@Override
	public boolean add(Employee emp) {
		/**
		 * 매개변수로 전달된 직원정보를 DB에 저장한다.
		 */
		String sql = "INSERT INTO semp(empno, name, position, dept)"
				+ " VALUES(?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement psmt = null;
        int chk = 0;
        try {
            conn = getConnection();
//            log("2/6 boolean add()");
            psmt = conn.prepareStatement(sql);
            int i = 1;
            psmt.setInt(i++, emp.getEmpno());
            psmt.setString(i++, emp.getName());
            psmt.setString(i++, emp.getPosition());
            psmt.setString(i++, emp.getDept());
            chk = psmt.executeUpdate();
        } catch (SQLException e) {
            log("boolean add(Employee emp)", e);
        } finally {
            close(conn, psmt, null);
//            log("6/6 boolean add()");
        }
		return chk > 0 ? true : false;
	}

	@Override
	public List<Employee> search() {
		/**
		 * 저장된 모든 직원 정보를 리턴한다.
		 */
		String sql = "SELECT * FROM semp";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        Employee emp = null;

        List<Employee> empList = new ArrayList<>();
        
        try {
            conn = getConnection();
//            log("2/6 List<Employee> search()");
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                emp = new Employee();
                int i = 1;
                emp.setEmpno(rs.getInt(i++));
                emp.setName(rs.getString(i++));
                emp.setPosition(rs.getString(i++));
                emp.setDept(rs.getString(i++));
                empList.add(emp);
            }
        } catch (SQLException e) {
            log("List<Employee> search()", e);
        } finally {
            close(conn, psmt, rs);
//            log("6/6 List<Employee> search()");
        }
		return empList;
	}

	@Override
	public Employee search(int empNo) {
		/**
		 * 파라미터로 전달된 사번과 같은 직원 정보를 찾아서 리턴한다.
		 * (empNo이 존재하지 않을 시, null을 리턴한다.)
		 */
		String sql = "SELECT * FROM semp WHERE empno=?";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        Employee emp = null;
        
        try {
            conn = getConnection();
//            log("2/6 List<Employee> search(int empNo)");
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, empNo);
            rs = psmt.executeQuery();
            while (rs.next()) {
                emp = new Employee();
                int i = 1;
                emp.setEmpno(rs.getInt(i++));
                emp.setName(rs.getString(i++));
                emp.setPosition(rs.getString(i++));
                emp.setDept(rs.getString(i++));
            }
        } catch (SQLException e) {
            log("List<Employee> search()", e);
        } finally {
            close(conn, psmt, rs);
//            log("6/6 List<Employee> search(int empNo)");
        }
        
		return rs != null ? emp : null;
	}

	@Override
	public List<Employee> search(String name) {
		/**
		 * 매개변수로 전달된 글자를 이름에 포함한 모든 직원 정보를 찾아서 리턴한다.
		 */
		String sql = "SELECT * FROM semp WHERE name LiKE ?";

        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        Employee emp = null;

        List<Employee> empList = new ArrayList<>();
        
        try {
            conn = getConnection();
//            log("2/6 List<Employee> search(String name)");
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, "%" + name + "%");
            rs = psmt.executeQuery();
            while (rs.next()) {
                emp = new Employee();
                int i = 1;
                emp.setEmpno(rs.getInt(i++));
                emp.setName(rs.getString(i++));
                emp.setPosition(rs.getString(i++));
                emp.setDept(rs.getString(i++));
                empList.add(emp);
            }
        } catch (SQLException e) {
            log("List<Employee> search()", e);
        } finally {
            close(conn, psmt, rs);
//            log("6/6 List<Employee> search()");
        }
		return empList;
	}

	@Override
	public boolean update(int empno, String deptno) {
		/**
		 * 매개변수로 전달된 사번으로 직원을 찾아 부서를 수정한다.
		 * 정상적으로 직원을 찾아 수정했을 경우  true,
		 * 직원을 찾지 못했을 경우 false를 리턴한다.
		 */
		String sql = "UPDATE semp SET dept=? WHERE empno=?";

        Connection conn = null;
        PreparedStatement psmt = null;
        int chk = 0;
        
        try {
            conn = getConnection();
//            log("2/6 boolean update(int empno, String deptno)");
            psmt = conn.prepareStatement(sql);
            int i = 1;
            psmt.setString(i++, deptno);
            psmt.setInt(i++, empno);
            chk = psmt.executeUpdate();
        } catch (SQLException e) {
        	log("boolean update(int empno, String deptno)", e);
        } finally {
            close(conn, psmt, null);
//            log("6/6 boolean update(int empno, String deptno)");
        }
        
		return chk > 0 ? true : false;
	}

	@Override
	public boolean delete(int empno) {
		/**
		 * 매개변수의 사번과 같은 직원을 찾아 삭제한다.
		 * 직원 삭제 시, 배열의 값이 연속되도록 처리한다.
		 * (배열의 값이 null값을 갖지 않도록)
		 * 정상적으로 직원을 찾아 삭제했을 경우 true,
		 * 직원을 찾지 못했을 경우 false를 리턴한다.
		 */
		
		String sql = "DELETE FROM semp WHERE empno=?";

        Connection conn = null;
        PreparedStatement psmt = null;

        int chk = 0;
        
        try {
            conn = getConnection();
//            log("2/6 boolean delete(int empno)");
            psmt = conn.prepareStatement(sql);
            int i = 1;
            psmt.setInt(i++, empno);
            chk = psmt.executeUpdate();
        } catch (SQLException e) {
        	log("boolean delete(int empno)", e);
        } finally {
            close(conn, psmt, null);
//            log("6/6 boolean delete(int empno)");
        }
        
        return chk > 0 ? true : false;
	}

}
