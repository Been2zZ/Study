package ssafy0819;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

public class GsonTest2 {

	public static void main(String[] args) {
		BufferedReader br;
		
		try {
			br = new BufferedReader(
					new FileReader("staff.json"));
			Gson gson = new Gson();
			Staff st2 = gson.fromJson(br, Staff.class);
			System.out.println(st2.getName());
			Map<String, BigDecimal> map = st2.getSalary();
			
			for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext(); ) {
				String key = iterator.next();
				BigDecimal big = map.get(key);
				System.out.println(key + " " + big);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
}