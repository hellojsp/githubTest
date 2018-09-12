package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bean.NewsType;
import service.NewsTypeService;

public class NewsTypeServiceTest {

	@Test
	public void testGetAll()throws Exception{
		NewsTypeService newsTypeService = new NewsTypeService();
		List<NewsType> NewsTypes=new ArrayList<NewsType>();
		
		NewsTypes = newsTypeService.getAll();
		
		assertNotNull(NewsTypes);
	}

}
