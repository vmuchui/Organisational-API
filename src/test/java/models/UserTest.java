package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    public User setUpUser() {
        return new User("Muchui",2,"junior dev","tech-support","muchui@mycompany.com");
    }

    @Test
    public void getId() {
       User user = setUpUser();
       user.setId(0);
       assertEquals(0,user.getId());
    }

    @Test
    public void setId() {
        User user = setUpUser();
        user.setId(0);
        assertEquals(0,user.getId());
    }

    @Test
    public void getName() {
        User user = setUpUser();
        user.setId(0);
        assertEquals("Muchui",user.getName());
    }

    @Test
    public void setName() {
        User user = setUpUser();
        user.setName("Victor");
        assertEquals("Victor", user.getName());
    }

    @Test
    public void getDepartmentId() {
        User user = setUpUser();
        assertEquals(2, user.getDepartmentId());
    }

    @Test
    public void setDepartmentId() {
        User user = setUpUser();
        user.setDepartmentId(3);
        assertEquals(3, user.getDepartmentId());
    }

    @Test
    public void getRank() {
        User user = setUpUser();
        assertEquals("junior dev",user.getRank());

    }

    @Test
    public void setRank() {
        User user = setUpUser();
        user.setRank("senior");
        assertEquals("senior", user.getRank());
    }

    @Test
    public void getRole() {
        User user = setUpUser();
        assertEquals("tech-support", user.getRole());
    }

    @Test
    public void setRole() {
        User user = setUpUser();
        user.setRole("h-r");
        assertEquals("h-r", user.getRole());
    }

    @Test
    public void getEmail() {
        User user = setUpUser();
        assertEquals("muchui@mycompany.com",user.getEmail());
    }

    @Test
    public void setEmail() {
        User user = setUpUser();
        user.setEmail("amos@gmail");
        assertEquals("amos@gmail", user.getEmail());
    }
}