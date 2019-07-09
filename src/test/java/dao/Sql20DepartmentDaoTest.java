package dao;

import models.Department;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql20DepartmentDaoTest {

    public Sql20DepartmentDao departmentDao;
    public Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        departmentDao = new Sql20DepartmentDao();
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    public Department setUpDepartment() {
        return new Department("technical","technical@mycompany.com");
    }

    @Test
    public void save() {
        Department department = setUpDepartment();
        departmentDao.save(department);
        Department fetched = departmentDao.find(department.getId());
        assertEquals(department.getName(), fetched.getName());
        assertEquals(department.getEmail(),fetched.getEmail());
    }

    @Test
    public void getAll() {
        Department department = setUpDepartment();
        Department another = setUpDepartment();
        departmentDao.save(department);
        departmentDao.save(another);
        assertTrue(departmentDao.getAll().contains(department));
        assertTrue(departmentDao.getAll().contains(another));
    }

    @Test
    public void find() {
        Department department = setUpDepartment();
        departmentDao.save(department);
        Department fetched = departmentDao.find(department.getId());
        assertEquals(department.getName(), fetched.getName());
    }

    @Test
    public void update() {
        Department department = setUpDepartment();
        departmentDao.save(department);
        Department another = new Department("Human Resource", "hr@mycompany.com");
        departmentDao.update(another,department.getId());
        Department fetched = departmentDao.find(department.getId());
        assertEquals(another.getName(),fetched.getName());
        assertEquals(another.getEmail(),fetched.getEmail());
    }

    @Test
    public void delete() {
        Department department = setUpDepartment();
        Department another = setUpDepartment();
        departmentDao.save(department);
        departmentDao.save(another);
        departmentDao.delete(department);
        assertFalse(departmentDao.getAll().contains(department));
        assertTrue(departmentDao.getAll().contains(another));
    }

    @Test
    public void clearAll() {
        Department department = setUpDepartment();
        Department another = setUpDepartment();
        departmentDao.save(department);
        departmentDao.save(another);
        departmentDao.clearAll();
        assertFalse(departmentDao.getAll().contains(department));
        assertFalse(departmentDao.getAll().contains(another));
    }


}