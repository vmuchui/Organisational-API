package dao;

import models.DepartmentNews;
import models.GeneralNews;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oNewsDaoTest {

    public Sql2oNewsDao newsDao;
    public Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        newsDao = new Sql2oNewsDao();
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
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

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void clearAll() {
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