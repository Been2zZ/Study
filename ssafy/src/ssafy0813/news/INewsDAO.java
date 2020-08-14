package ssafy0813.news;

import java.util.List;

public interface INewsDAO {
	List<News> getNewsList(String url);
	News search(int index);
}
