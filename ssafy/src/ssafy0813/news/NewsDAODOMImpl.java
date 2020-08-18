package ssafy0813.news;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class NewsDAODOMImpl implements INewsDAO {
	private List<News> list = new ArrayList<>();
	
	// ---------------------------------------------------------------
	/**
	 * Singleton
	 */
	private static NewsDAODOMImpl dao = new NewsDAODOMImpl();
	private NewsDAODOMImpl() {
		list.clear();
	}
	public static NewsDAODOMImpl getInstance() {
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
		list.clear();
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(url);
			
			// <rss> root
			Element rss = doc.getDocumentElement();	
						
			// item tag
			NodeList items = rss.getElementsByTagName("item");
			for (int i = 0; i < items.getLength(); i++) {
				News news = new News();
				
				Element inItem = (Element)items.item(i);
				NodeList tags = inItem.getChildNodes();	
				
				for (int j = 0; j < tags.getLength(); j++) {
					Node node = tags.item(j);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element tag = (Element)node;
						
						if (tag.getNodeName().equalsIgnoreCase("title")) {
							news.setTitle(tag.getTextContent().trim());
						} else if (tag.getNodeName().equalsIgnoreCase("description")) {
							news.setDesc(tag.getTextContent().trim());
						} else if (tag.getNodeName().equalsIgnoreCase("link")) {
							news.setLink(tag.getTextContent().trim());
						}
					}
				}
				list.add(news);
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}
