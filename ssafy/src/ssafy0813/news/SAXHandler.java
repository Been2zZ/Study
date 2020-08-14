package ssafy0813.news;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {
	private StringBuilder b = null;
	private boolean flag = false;
	private News n = new News();
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
	
	}
	@Override
	public void endDocument() throws SAXException {
	
	}
		
}
