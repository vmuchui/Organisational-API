package dao;

import models.User;

import java.util.List;

public interface UserDao {

    void save(User user);
    User find(int id);
    List<User> getAll();
    void update(User user, int id);
    void delete(User user);
    void clearAll();
}
