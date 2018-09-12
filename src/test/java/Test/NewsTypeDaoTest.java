package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bean.NewsType;
import dao.NewsTypeDao;

public class NewsTypeDaoTest {

	
	@Test
	public void testGetAll()throws Exception{
		NewsTypeDao newsTypeDao = new NewsTypeDao();
		List<NewsType> newsTypes=new ArrayList<NewsType>(); 
		newsTypes = newsTypeDao.getAll();
		
		assertNotNull(newsTypes);
	}
}
