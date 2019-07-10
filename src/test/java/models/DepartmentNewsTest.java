package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentNewsTest {

    @Test
    public void getId() {
        DepartmentNews departmentNews = new DepartmentNews("TRAVEL DISCOUNT", "amadeus travels in association with it dept....", 2);
        departmentNews.setId(2);
        assertEquals(2,departmentNews.getId());
    }

    @Test
    public void setId() {
        DepartmentNews departmentNews = new DepartmentNews("TRAVEL DISCOUNT", "amadeus travels in association with it dept....", 2);
        departmentNews.setId(2);
        assertEquals(2,departmentNews.getId());
    }

    @Test
    public void getDepartmentId() {
        DepartmentNews departmentNews = new DepartmentNews("TRAVEL DISCOUNT", "amadeus travels in association with it dept....", 2);
        assertEquals(2,departmentNews.getDepartmentId());
    }

    @Test
    public void setDepartmentId() {
        DepartmentNews departmentNews = new DepartmentNews("TRAVEL DISCOUNT", "amadeus travels in association with it dept....", 2);
        departmentNews.setDepartmentId(3);
        assertEquals(3,departmentNews.getDepartmentId());
    }

    @Test
    public void getHeadlines() {
        DepartmentNews departmentNews = new DepartmentNews("TRAVEL DISCOUNT", "amadeus travels in association with it dept....", 2);
        assertEquals("TRAVEL DISCOUNT",departmentNews.getHeadlines());
    }
    @Test
    public void getContent() {
        DepartmentNews departmentNews = new DepartmentNews("TRAVEL DISCOUNT", "amadeus travels in association with it dept....", 2);
        assertEquals("amadeus travels in association with it dept....",departmentNews.getContent());
    }
}