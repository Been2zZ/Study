package ssafy0819;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GsonTest {

	public static void main(String[] args) {
		Gson gson = new Gson();
		
		Staff st1 = new Staff();
		st1.setName("홍길동");
		st1.setAge(15);
		st1.setPosition(new String[] {"Founder", "CTO", "Writer"});
		Map<String, BigDecimal> salary = new HashMap<>();
		
		salary.put("2010", new BigDecimal(10000));
		salary.put("2012", new BigDecimal(12000));
		salary.put("2018", new BigDecimal(14000));
		
		st1.setSalary(salary);
		st1.setSkills(
				Arrays.asList("java", "python", "node", "kotlin"));
		
		 try (PrintWriter pw = new PrintWriter(
				 new FileWriter("staff1.json"))) {
	        gson.toJson(st1, pw);
	        System.out.println("저장");
	     } catch (IOException e) {
	    	 System.out.println(e);
	     }

        
	}
}

