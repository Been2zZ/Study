package ssafy0821;

import java.util.List;

public interface EmpMgr {
	boolean add(Employee emp);					// 직원 정보 저장
	List<Employee> search();					// 모든 직원 정보 리턴
	Employee search(int empNo);					// 입력 사번과 같은 직원 리턴
	List<Employee> search(String name);			// 입력 글자 포함된 직원 리턴
	boolean update(int empno, String deptno);	// 부서 수정
	boolean delete(int empno);					// 입력 사번과 같은 직원 삭제
}
