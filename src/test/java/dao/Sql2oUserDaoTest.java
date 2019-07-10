package dao;

import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oUserDaoTest {
    public Sql2oUserDao userDao;
    public Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        userDao = new Sql2oUserDao();
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    public User setUpUser() {
        return new User("Muchui",2,"junior dev","tech-support","muchui@mycompany.com");
    }

    @Test
    public void save() {
        User user = setUpUser();
        userDao.save(user);
        User fetched = userDao.find(user.getId());
        assertEquals(user,fetched);
    }

    @Test
    public void find() {
        User user = setUpUser();
        userDao.save(user);
        User fetched = userDao.find(user.getId());
        assertEquals(user,fetched);
    }

    @Test
    public void getAll() {
        User user = setUpUser();
        userDao.save(user);
        User another = setUpUser();
        userDao.save(another);
        assertTrue(userDao.getAll().contains(another));
        assertTrue(userDao.getAll().contains(user));
    }

    @Test
    public void update() {
        User user = setUpUser();
        userDao.save(user);
        User another = new User("Victor", 3,"senior", "JHR","muchui@weus.com");
        userDao.update(another, user.getId());
        User fetched = userDao.find(user.getId());
        assertEquals(another.getName(),fetched.getName());
    }

    @Test
    public void delete() {
        User user = setUpUser();
        userDao.save(user);
        User another = setUpUser();
        userDao.save(another);
        userDao.delete(user);
        assertTrue(userDao.getAll().contains(another));
        assertFalse(userDao.getAll().contains(user));
    }

    @Test
    public void clearAll() {
        User user = setUpUser();
        userDao.save(user);
        User another = setUpUser();
        userDao.save(another);
        userDao.clearAll();
        assertFalse(userDao.getAll().contains(user));
        assertFalse(userDao.getAll().contains(another));
    }
}