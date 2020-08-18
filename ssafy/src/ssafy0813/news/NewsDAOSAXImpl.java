package ssafy0813.news;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class NewsDAOSAXImpl implements INewsDAO {
	private List<News> list = new ArrayList<>();
	
	// ---------------------------------------------------------------
	/**
	 * Singleton
	 */
	private static NewsDAOSAXImpl dao = new NewsDAOSAXImpl();
	private NewsDAOSAXImpl() {
		list.clear();
	}
	public static NewsDAOSAXImpl getInstance() {
		return dao;
	}
	// ---------------------------------------------------------------
		
	
	public List<News> getNewsList(String url) {
		connectNews(url);
		return list;
		
	}
	
	public News search(int index) {
		return null;
		
	}
	
	private void connectNews(String url) {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			NewsSAXHandler handler = new NewsSAXHandler();
			
			saxParser.parse(url, handler);

			list = handler.getList();
			for (News news : list) 
				System.out.println(news);
			

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}
