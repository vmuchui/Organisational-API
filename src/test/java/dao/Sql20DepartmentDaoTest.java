package dao;

import models.DB;
import models.Department;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql20DepartmentDaoTest {

    public static Sql20DepartmentDao departmentDao;
    public static Connection conn;

    @BeforeClass
    public static void setUp() throws Exception {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/org_api_test", "victor", "Am0skwito");
        departmentDao = new Sql20DepartmentDao();
        conn = DB.sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        departmentDao.clearAll();
    }
    @AfterClass
    public static void shutDown() throws Exception {
        conn.close();
        System.out.println("connection closed");
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