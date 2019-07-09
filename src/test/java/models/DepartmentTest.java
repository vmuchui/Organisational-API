package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {
    public Department setUpDepartment() {
        return new Department("technical","technical@mycompany.com");
    }

    @Test
    public void getEmail() {
        Department testdepartment = setUpDepartment();
        assertEquals("technical@mycompany.com", testdepartment.getEmail());
    }

    @Test
    public void setEmail() {
        Department testdepartment = setUpDepartment();
        testdepartment.setEmail("techs@mycompany.com");
        assertEquals("techs@mycompany.com", testdepartment.getEmail());
    }

    @Test
    public void getId() {
        Department testdepartment = setUpDepartment();
        testdepartment.setId(0);
        assertEquals(0, testdepartment.getId());
    }

    @Test
    public void setId() {
        Department testdepartment = setUpDepartment();
        testdepartment.setId(0);
        assertEquals(0, testdepartment.getId());
    }

    @Test
    public void getName() {
        Department testdepartment = setUpDepartment();
        assertEquals("technical", testdepartment.getName());
    }

    @Test
    public void setName() {
        Department testdepartment = setUpDepartment();
        testdepartment.setName("human resource");
        assertEquals("human resource", testdepartment.getName());
    }
}