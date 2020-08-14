package ssafy0813.news;

import java.util.ArrayList;
import java.util.List;

public class NewsDAODOMImpl implements INewsDAO {
	private List<News> list = new ArrayList<>();
	
	public List<News> getNewsList(String url) {
		return list;
		
	}
	
	public News search(int index) {
		return null;
		
	}
	
	private void connectNews(String url) {
		
	}
}
