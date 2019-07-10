package dao;

import models.DB;
import models.DataBaseRule;
import models.DepartmentNews;
import models.GeneralNews;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oNewsDaoTest {

    public static Sql2oNewsDao newsDao;
    public static Connection conn;


    @BeforeClass
    public static void setUp() throws Exception {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/org_api_test", "victor", "Am0skwito");
        newsDao = new Sql2oNewsDao();
        conn = DB.sql2o.open();
    }
    @After
    public void tearDown() throws Exception {
        newsDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception {
        conn.close();
        System.out.println("connection closed");
    }

    @Test
    public void save() {
        GeneralNews generalNews = new GeneralNews("PAY RAISE","all employees ...");
        newsDao.save(generalNews);
        assertTrue(newsDao.getAll().contains(generalNews));
    }

    @Test
    public void find() {
        GeneralNews generalNews = new GeneralNews("PAY RAISE","all employees ...");
        newsDao.save(generalNews);
        GeneralNews fetch = (GeneralNews) newsDao.find(generalNews.getId());
        assertTrue(generalNews.equals(fetch));
    }

    @Test
    public void getAll() {
        GeneralNews generalNews = new GeneralNews("PAY RAISE","all employees ...");
        newsDao.save(generalNews);
        assertTrue(newsDao.getAll().contains(generalNews));
    }

//    @Test
//    public void update() {
//        DepartmentNews departmentNews = new DepartmentNews("TEAM BUILDING", "this week...", 2);
//        newsDao.save(departmentNews);
//        DepartmentNews another = new DepartmentNews("bring your child to work day", "that", 2);
//        newsDao.updateDepNews(another,departmentNews.getId());
//        DepartmentNews dep = (DepartmentNews) newsDao.find(departmentNews.getId());
//        assertEquals(another.getHeadlines(), dep.getHeadlines());
//    }

    @Test
    public void delete() {
        DepartmentNews departmentNews = new DepartmentNews("TEAM BUILDING", "this week...", 2);
        newsDao.save(departmentNews);
        DepartmentNews another = new DepartmentNews("TEAM BUILDING", "this week...", 2);
        newsDao.save(another);
        newsDao.delete(departmentNews);
        assertFalse(newsDao.getDeptNews(departmentNews.getId()).contains(departmentNews));
//        assertTrue(newsDao.getDeptNews(another.getId()).contains(another));
    }

    @Test
    public void clearAll() {
        DepartmentNews departmentNews = new DepartmentNews("TEAM BUILDING", "this week...", 2);
        newsDao.save(departmentNews);
        GeneralNews generalNews = new GeneralNews("PAY RAISE","all employees ...");
        newsDao.save(generalNews);
        newsDao.clearAll();
        assertFalse(newsDao.getAll().contains(generalNews));
        assertFalse(newsDao.getDeptNews(departmentNews.getId()).contains(departmentNews));
    }


    @Test
    public void getDeptNews() {
        DepartmentNews departmentNews = new DepartmentNews("TEAM BUILDING", "this week...", 2);
        newsDao.save(departmentNews);
        DepartmentNews another = new DepartmentNews("TEAM BUILDING", "this week...", 3);
        newsDao.save(another);
//        assertTrue(newsDao.getDeptNews(departmentNews.getId()).contains(departmentNews));
        assertFalse(newsDao.getDeptNews(departmentNews.getId()).contains(another));
//        assertTrue(newsDao.getDeptNews(another.getId()).contains(another));
    }
}