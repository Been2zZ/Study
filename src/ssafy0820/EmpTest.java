package ssafy0820;

public class EmpTest {
    public static void main(String[] args) {
        EmpDao dao = new EmpDao();
        dao.addEmp(new EmpDto(30, "홍길동", "s@n.com", "", 6, "사원", 10, 4000, 10));
    }
}
