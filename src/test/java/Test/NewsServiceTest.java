package Test;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

import bean.News;
import service.NewsService;
import tools.PageInformation;

public class NewsServiceTest {

	@Test
	public void testAdd()throws Exception{
		News news = new News();
		NewsService newsService = new NewsService();
		String timesString = "2018-09-11T10:30";
		LocalDateTime time=LocalDateTime.parse(timesString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		news.setAuthor("hello");
		news.setCaption("测试！");
		news.setContent("test!");
		news.setNewsType("体育");
		news.setNewsTime(time);
		
		int flag = newsService.add(news);
		assertEquals(1, flag);
	}
	
	@Test
	public void testGetOnePage()throws Exception{
		NewsService newsService = new NewsService();
		List<News> newses=new ArrayList<News>();
		PageInformation pageInformation = new PageInformation();
		pageInformation.setTableName("news");
		pageInformation.setPageSize(4);
		pageInformation.setPage(2);
		
		newses = newsService.getOnePage(pageInformation);
		
		assertNotNull(newses);
	}
	
	@Test
	public void testGetNewsById()throws Exception{
		NewsService newsService = new NewsService();
		News news = new News();
		
		news = newsService.getNewsById(30);
		
		assertNotNull(news);
	}

	@Test
	public void testDeletes()throws Exception{
		NewsService newsService = new NewsService();
		PageInformation pageInformation = new PageInformation();
		
		pageInformation.setTableName("news");
		pageInformation.setIds("21");
		
		List<News> newses=newsService.deletes(pageInformation);
		
		assertNotNull(newses);
	}
	
	@Test
	public void testGetByTypesTopN()throws Exception{
		NewsService newsService = new NewsService();
		List<List<News>>  newsesList=new ArrayList<List<News>>();
		
		String[] newsTypes ={"体育","社会"};
		
		newsesList = newsService.getByTypesTopN(newsTypes, 5);
		
		assertNotNull(newsesList);
	}
	
	@Test
	public void testGetByTypesTopN1()throws Exception{
		NewsService newsService = new NewsService();
		List<List<News>>  newsesList=new ArrayList<List<News>>();
		String[] newsTypes ={"体育"};
		List<List<String>> newsCaptionsList = new ArrayList<List<String>>();
		
		newsesList = newsService.getByTypesTopN1(newsTypes,2, newsCaptionsList);
		
		assertNotNull(newsesList);
		
	}
	
	@Test
	public void testUpdate()throws Exception{
		NewsService newsService = new NewsService();
		News news = new News();
		
		String timesString = "2018-09-11T10:30";
		LocalDateTime time=LocalDateTime.parse(timesString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		news.setAuthor("hello");
		news.setContent("test!");
		news.setNewsType("体育");
		news.setNewsTime(time);
		news.setNewsId(22);
		
		int flag = newsService.update(news);
		
		assertEquals(1, flag);
	}
}
