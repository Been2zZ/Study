package ssafy0814.Weather;
//Data Access Object

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class WeatherDAO {
	
	/**
	 * Singleton
	 */
	private static WeatherDAO dao = new WeatherDAO();
	private WeatherDAO() {
		list.clear();
	}
	public static WeatherDAO getInstance() {
		return dao;
	}
	
	private List<Weather> list = new ArrayList<>();
	
	public void connectXML() {
		list.clear();
		String url = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=3020053000";
	
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(url);
			
			// <rss> root
			Element rss = doc.getDocumentElement();	
//			System.out.println(rss.getNodeName());		
			
			// -------------------- 날짜 출력
			// <tm> 찾기
			NodeList tms = rss.getElementsByTagName("tm");		
			
			String str ="";
			for (int i = 0; i < tms.getLength(); i++) {
				Node tmitem = tms.item(i);
				if (tmitem.getNodeType() == Node.ELEMENT_NODE) {
					if (tmitem.getNodeName().equalsIgnoreCase("tm")) {
						str = tmitem.getTextContent().trim();
						if (str != null && !str.equals("")) {
							break;
						}
					}
				}
			}
			System.out.println(str);
			
			
			// data tag
			NodeList datas = rss.getElementsByTagName("data");		
			for (int i = 0; i < datas.getLength(); i++) {
				// seq
//				System.out.println(datas.item(i).getAttributes());
//				System.out.println(datas.item(i).getNodeName());
				
				// data 만큼 weather객체 생성
				Weather weather = new Weather();			
				
				Element dataItem = (Element)datas.item(i);
//				System.out.println(dataItem.getNodeName());
				// <data>
				NodeList data = dataItem.getChildNodes();	
				for (int j = 0; j < data.getLength(); j++) {
					// data 아래 태그 
//					System.out.println(data.item(j).getNodeName());		
					Node node = data.item(j);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element item = (Element)node;
					
						if (item.getNodeName().equalsIgnoreCase("hour")) {
							weather.setHour(Integer.parseInt(item.getTextContent().trim()));
						} else if (item.getNodeName().equalsIgnoreCase("temp")) {
							weather.setTemp(Double.parseDouble(item.getTextContent().trim()));
						} else if (item.getNodeName().equalsIgnoreCase("wfKor")) {
							weather.setWfKor(item.getTextContent().trim());
						} else if (item.getNodeName().equalsIgnoreCase("reh")) {
							weather.setReh(Integer.parseInt(item.getTextContent().trim()));
						}
					}
					
				}
//				System.out.println(weather);
				list.add(weather);
			
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Weather> getWeatherList() {
		connectXML();
		return list;
	}
}
