package dao;

import models.DB;
import models.Department;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql20DepartmentDao implements DepartmentDao {
    Sql2o sql2o = DB.sql2o;


    @Override
    public void save(Department department) {
        try (Connection con = sql2o.open()){
            String sql = "INSERT INTO departments (name, email) VALUES(:name, :email);";
            int id = (int) con.createQuery(sql, true)
                    .addParameter("name", department.getName())
                    .addParameter("email",department.getEmail())
                    .executeUpdate().getKey();
            department.setId(id);
        }


    }

    @Override
    public List<Department> getAll() {

        try (Connection conn = sql2o.open()){
           String sql = "SELECT * FROM departments;";
          return conn.createQuery(sql).executeAndFetch(Department.class);
        }
    }

    @Override
    public Department find(int id) {

        try (Connection con = sql2o.open()){
            String sql = "SELECT * FROM departments WHERE id =:id;";
           return con.createQuery(sql).addParameter("id", id).executeAndFetchFirst(Department.class);
        }catch (Sql2oException e) {
           return null;
        }
    }

    @Override
    public void update(Department department, int id) {
        try (Connection con = sql2o.open()){
            String sql = "UPDATE departments SET (name, email) = (:name, :email) WHERE id= :id;";
            con.createQuery(sql)
                    .addParameter("name", department.getName())
                    .addParameter("email", department.getEmail())
                    .addParameter("id", id)
                    .executeUpdate();
        }

    }

    @Override
    public void delete(Department department) {
        String sql = "DELETE FROM departments WHERE id= :id;";
        try (Connection con = sql2o.open()){
            con.createQuery(sql).addParameter("id", department.getId()).executeUpdate();
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE FROM departments";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        }

    }
}
