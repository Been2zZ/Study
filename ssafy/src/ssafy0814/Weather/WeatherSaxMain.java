package ssafy0814.Weather;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;


public class WeatherSaxMain {

	public static void main(String[] args) {
		String url = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=3020053000";
		
				SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			WeatherHandler handler = new WeatherHandler();
			
			saxParser.parse(url, handler);
			
			List<Weather> list = handler.getList();
			for (Weather weather : list) {
				System.out.println(weather);
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
