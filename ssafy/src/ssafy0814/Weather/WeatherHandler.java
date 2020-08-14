package ssafy0814.Weather;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherHandler extends DefaultHandler   {

	private Weather weather = null;
	private List<Weather> list = new ArrayList<>();
	
	boolean bHour = false;
	boolean bTemp = false;
	boolean bWfKor = false;
	boolean bReh = false;
	
	private StringBuilder data = null;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) 
			throws SAXException {
		
		if(qName.equals("data")) {
			weather = new Weather();
		} else if (qName.equals("hour")) {
			bHour = true;
		} else if (qName.equals("temp")) {
			bTemp = true;
		} else if (qName.equals("wfKor")) {
			bWfKor = true;
		} else if (qName.equals("reh")) {
			bReh = true;
		}
		
		data = new StringBuilder();
	}

	@Override
	public void endElement(String uri, String localName, String qName) 
			throws SAXException {
		
		if (qName.equals("data")) {
			 list.add(weather);
		} else if (qName.equals("hour") && bHour) {
			weather.setHour(Integer.parseInt(data.toString()));
			bHour = false;
		} else if (qName.equals("temp") && bTemp) {
			weather.setTemp(Double.parseDouble(data.toString()));
			bTemp = false;
		} else if (qName.equals("wfKor") && bWfKor) {
			weather.setWfKor(data.toString());
			bWfKor = false;
		} else if (qName.equals("reh") && bReh) {
			weather.setReh(Integer.parseInt(data.toString()));
			bReh = false;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) 
			throws SAXException {
		data.append(new String(ch, start, length));
	}
	
	public Weather getWeather() {
		return weather;
	}

	public List<Weather> getList() {
		return list;
	}

}
