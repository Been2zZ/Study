package ssafy0814.Weather;

import java.util.List;

public class WeatherMain {

	public static void main(String[] args) {
		WeatherDAO dao = WeatherDAO.getInstance();
		List<Weather> list = dao.getWeatherList();
		
		for (Weather w : list) {
			System.out.println(w);
		}
	}

}
