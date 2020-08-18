package ssafy0813.news;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsSAXHandler extends DefaultHandler {
	
	private News news = null;
	private List<News> list = new ArrayList<>();
	
	boolean bTitle = false;
	boolean bDesc = false;
	boolean bLink = false;
	
	private StringBuilder b = null;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) 
			throws SAXException {
		if (qName.equals("item")) {
			news = new News();
		} else if (qName.equals("title")) {
			bTitle = true;
		} else if (qName.equals("desc")) {
			bDesc = true;
		} else if (qName.equals("link")) {
			bLink = true;
		}
		
		b = new StringBuilder();
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) 
			throws SAXException {
		
		if (qName.equals("item")) {
			list.add(news);
		} else if (qName.equals("title") && bTitle) {
			news.setTitle(b.toString());
			bTitle = false;
		} else if (qName.equals("desc") && bDesc) {
			news.setDesc(b.toString());
			bDesc = false;
		} else if (qName.equals("link") && bLink) {
			news.setLink(b.toString());
			bLink = false;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) 
			throws SAXException {
		b.append(new String(ch, start, length));
	}
	
	public News getNews() {
		return news;
	}

	public List<News> getList() {
		return list;
	}
		
}
