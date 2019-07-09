package dao;

import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oUserDao implements UserDao {
    Sql2o sql2o = new Sql2o("jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'", "", "");

    @Override
    public void save(User user) {
        try (Connection con = sql2o.open()){
            String sql = "INSERT INTO users(name, role, rank, email, departmentId) VALUES (:name, :role, :rank, :email, :departmentId);";
            int id = (int) con.createQuery(sql, true)
                    .addParameter("name", user.getName())
                    .addParameter("role", user.getRole())
                    .addParameter("rank",user.getRank())
                    .addParameter("email", user.getEmail())
                    .addParameter("departmentId", user.getDepartmentId())
                    .executeUpdate().getKey();
            user.setId(id);
        }
    }

    @Override
    public User find(int id) {
        try (Connection con = sql2o.open()){
            String sql = "SELECT * FROM users WHERE id =:id;";
            return con.createQuery(sql).addParameter("id",id).executeAndFetchFirst(User.class);
        }
    }

    @Override
    public List<User> getAll() {
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM users;";
            return con.createQuery(sql).executeAndFetch(User.class);
        }
    }

    @Override
    public void update(User user, int id) {
        try (Connection con = sql2o.open()){
            String sql = "UPDATE users SET (name, role, rank, email, departmentId) = (:name, :role, :rank, :email, :departmentId) WHERE id=:id;";
            con.createQuery(sql).addParameter("name", user.getName())
                    .addParameter("role", user.getRole())
                    .addParameter("rank", user.getRank())
                    .addParameter("email", user.getEmail())
                    .addParameter("departmentId", user.getDepartmentId())
                    .addParameter("id", id).executeUpdate();
        }
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void clearAll() {

    }
}
