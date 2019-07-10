package dao;

import models.Department;
import models.DepartmentNews;
import models.GeneralNews;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oNewsDao implements NewsDao {

    Sql2o sql2o = new Sql2o("jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'", "", "");


    @Override
    public void save(Object o) {
        if (o instanceof GeneralNews){
            GeneralNews gen = (GeneralNews) o;
            try (Connection con = sql2o.open()){
                String sql = "INSERT INTO news(type,headlines, content, departmentId) VALUES(:type, :headlines, :content, :departmentId);";
                int id =(int) con.createQuery(sql, true).addParameter("type", gen.TYPE)
                        .addParameter("headlines", gen.getHeadlines())
                        .addParameter("content",gen.getContent()).addParameter("departmentId", gen.departmentId).executeUpdate().getKey();
                gen.setId(id);
            }
        }else if (o instanceof DepartmentNews) {
            DepartmentNews dep = (DepartmentNews) o;
            try (Connection con = sql2o.open()){
                String sql = "INSERT INTO news(type, headlines, content, departmentId) VALUES (:type, :headlines, :content, :departmentId);";
                int id = (int) con.createQuery(sql, true)
                        .addParameter("type", dep.TYPE)
                        .addParameter("headlines", dep.getHeadlines())
                        .addParameter("content",dep.getContent())
                        .addParameter("departmentId",dep.getDepartmentId()).executeUpdate().getKey();
            }
        }
    }

    @Override
    public Object find(int id) {
        try (Connection con= sql2o.open()){
            String sql = "SELECT * FROM news WHERE id = :id;";
            return con.createQuery(sql).addParameter("id",id).executeAndFetchFirst(GeneralNews.class);
        }
    }

    public DepartmentNews findDepNews(int id) {
        try (Connection con= sql2o.open()){
            String sql = "SELECT * FROM news WHERE id = :id;";
            return con.createQuery(sql).addParameter("id",id).executeAndFetchFirst(DepartmentNews.class);
        }
    }

    public void clearDepNews(int id) {
        try (Connection con = sql2o.open()){
            String sql = "DELETE FROM news WHERE id=:id;";
            con.createQuery(sql).addParameter("id",id).executeUpdate();
        }
    }

    @Override
    public List<DepartmentNews> getDeptNews(int id) {
        try (Connection con = sql2o.open()){
            String sql = "SELECT * FROM news WHERE departmentId = :departmentId;";
            return con.createQuery(sql).addParameter("departmentId", id).executeAndFetch(DepartmentNews.class);
        }
    }

    @Override
    public List<GeneralNews> getAll() {
        try (Connection con = sql2o.open()){
            String sql = "SELECT * FROM news WHERE departmentId = :departmentId;";
            return con.createQuery(sql).addParameter("departmentId", 0).executeAndFetch(GeneralNews.class);
        }

    }

    @Override
    public void update(Object o, int id) {
        if (o instanceof GeneralNews) {
            GeneralNews gen = (GeneralNews) o;
            try (Connection con = sql2o.open()){
                String sql = "UPDATE new SET (headlines, content)= (:headlines,:content) WHERE id= :id;";
                con.createQuery(sql).addParameter("headlines",gen.getHeadlines()).addParameter("content", gen.getContent()).addParameter("id",id).executeUpdate();
            }

        }
        if (o instanceof DepartmentNews) {
            DepartmentNews dep = (DepartmentNews) o;
            try (Connection con = sql2o.open()){
                String sql = "UPDATE new SET (headlines, content)= (:headlines,:content) WHERE id= :id;";
                con.createQuery(sql).addParameter("headlines",dep.getHeadlines()).addParameter("content", dep.getContent()).addParameter("id", id).executeUpdate();
            }
        }
    }

    @Override
    public void delete(Object o) {
        if (o instanceof GeneralNews) {
            GeneralNews gen = (GeneralNews) o;
            try (Connection con = sql2o.open()){
                String sql = "DELETE FROM news WHERE id=:id;";
                con.createQuery(sql).addParameter("id", gen.getId()).executeUpdate();
            }
        }else if (o instanceof DepartmentNews) {
            DepartmentNews dep = (DepartmentNews) o;
            try (Connection con = sql2o.open()){
                String sql = "DELETE FROM news WHERE id =:id;";
                con.createQuery(sql).addParameter("id",dep.getId()).executeUpdate();
            }
        }

    }

    @Override
    public void clearAll() {
        try (Connection con = sql2o.open()){
            con.createQuery("DELETE FROM news").executeUpdate();
        }
    }
}
