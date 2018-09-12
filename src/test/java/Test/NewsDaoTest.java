package Test;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import bean.News;
import dao.DatabaseDao;
import dao.NewsDao;
import tag.LocalDateTimeTag;
import tools.PageInformation;

public class NewsDaoTest {

	
	@Test
	public void testAdd()throws Exception{
		NewsDao  newsDao = new NewsDao();
		News  news = new News();
		String timesString = "2018-09-11T10:30";
		LocalDateTime time=LocalDateTime.parse(timesString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);		
		
		DatabaseDao databaseDao = new DatabaseDao();
		news.setAuthor("hello");
		news.setCaption("测试！");
		news.setContent("test!");
		news.setNewsType("体育");
		news.setNewsTime(time);
		int flag = newsDao.add(news, databaseDao);
		assertEquals(1, flag);
	}
	
	@Test
	public void testUpdate()throws Exception{
		NewsDao  newsDao = new NewsDao();
		News  news = new News();
		DatabaseDao databaseDao = new DatabaseDao();
		
		String timesString = "2018-09-11T10:30";
		LocalDateTime time=LocalDateTime.parse(timesString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		news.setAuthor("hello");
		news.setContent("test!");
		news.setNewsType("体育");
		news.setNewsTime(time);
		news.setNewsId(19);
		int flag = newsDao.update(news, databaseDao);
		assertEquals(1, flag);
	}
	
	@Test
	public void testGetOnePage()throws Exception{
		NewsDao  newsDao = new NewsDao();
		PageInformation pageInformation = new PageInformation();
		DatabaseDao databaseDao = new DatabaseDao();
		
		pageInformation.setTableName("news");
		pageInformation.setPageSize(4);
		pageInformation.setPage(2);
		List<News> allNews=new ArrayList<News>();
		allNews = newsDao.getOnePage(pageInformation, databaseDao);
		assertNotNull(allNews);
	}
	
	@Test
	public void testGetById()throws Exception{
		NewsDao  newsDao = new NewsDao();
		
		News news = newsDao.getById(16);
		assertNotNull(news);
	}
	
	@Test
	public void testDeletes()throws Exception{
		NewsDao  newsDao = new NewsDao();
		DatabaseDao databaseDao = new DatabaseDao();
		
		int flag = newsDao.deletes("news", "20", databaseDao);
		assertEquals(1, flag);
	}
	
	@Test
	public void testGetByTypesTopN()throws Exception{
		NewsDao  newsDao = new NewsDao();
		DatabaseDao databaseDao = new DatabaseDao();
		List<News> news1=new ArrayList<News>();
		List<News> news2=new ArrayList<News>();
		
		news1 = newsDao.getByTypesTopN("all", 10, databaseDao);
		news2 = newsDao.getByTypesTopN("体育", 10, databaseDao);
		
		assertNotNull(news1);
		assertNotNull(news2);
	}
}
