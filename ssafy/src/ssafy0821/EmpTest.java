package ssafy0821;

import java.util.ArrayList;
import java.util.List;

public class EmpTest {
	public static void main(String[] args) {
		EmpMgrImpl mgr = EmpMgrImpl.getInstance();
		
		List<Employee> list = new ArrayList<>();
		
		/**
		 * 저장
		 */
		System.out.println("======================================================");
		mgr.add(new Employee(1, "루루", "사장", "고양이부"));
		mgr.add(new Employee(2, "루토", "대표", "고양이부"));
		mgr.add(new Employee(3, "복희", "부장", "고양이부"));
		mgr.add(new Employee(4, "콩이", "이사", "강아지부"));
		mgr.add(new Employee(5, "구름이", "사원", "강아지부"));
		mgr.add(new Employee(6, "설이", "사원", "햄스터부"));
		
		
		/**
		 * 검색
		 */
		System.out.println("======================================================");
		// 전체 직원 검색
		list = mgr.search();
		for (Employee employee : list) 
			System.out.println(employee);
		
		System.out.println("======================================================");
		// 사번 2번 직원 검색
		Employee emp = null;
		if ((emp = mgr.search(2)) != null)
			System.out.println(emp);
		else
			System.out.println("입력한 사원 번호에 해당하는 사원이 존재하지 않습니다.");
		
		System.out.println("======================================================");
		// 글자 '이'가 포함된 이름을 가진 직원들 검색
		list.clear();
		list = mgr.search("이");
		for (Employee employee : list) 
			System.out.println(employee);	
		
		/**
		 * 수정 
		 */
		System.out.println("======================================================");
		// 5번 사원 부서 햄스터부로 수정
		if (mgr.update(5, "햄스터부"))
			System.out.println("수정 완료!!");
		else
			System.out.println("입력한 사원 번호에 해당하는 사원이 존재하지 않습니다.");
	
		
		/**
		 * 삭제
		 */
		System.out.println("======================================================");
		// 1번 사원 삭제
		if (mgr.delete(1))
			System.out.println("삭제 완료!!");
		else 
			System.out.println("입력한 사원 번호에 해당하는 사원이 존재하지 않습니다.");
		
	}
}
