import com.google.gson.Gson;
import dao.DepartmentDao;
import dao.Sql20DepartmentDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUserDao;
import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        Sql2oNewsDao newsDao;
        Sql2oUserDao userDao;
        Sql20DepartmentDao departmentDao;
        Sql2o sql2o = DB.sql2o;
        Connection conn = sql2o.open();
        Gson gson = new Gson();

        departmentDao = new Sql20DepartmentDao();
        userDao = new Sql2oUserDao();
        newsDao = new Sql2oNewsDao();



        post("/departments","application/json",(request, response) -> {
            Department department = gson.fromJson(request.body(),Department.class);
            departmentDao.save(department);
            response.status(201);
            response.type("application/json");
            return gson.toJson(department);
        });

        get("/departments","applications/json",(request, response) -> {
            response.type("application/json");
            return gson.toJson(departmentDao.getAll());
        });

        get("/department/:id", "application/json", (request, response) -> {
            Department department = departmentDao.find(Integer.parseInt(request.params(":id")));
            response.type("application/json");
            return gson.toJson(department);
        });

        post("/users","application/json",(request, response) -> {
            User user = gson.fromJson(request.body(),User.class);
            userDao.save(user);
            response.status(201);
            response.type("application/json");
            return gson.toJson(user);
        });

        post("/generalnews","application/json",(request, response) -> {
            GeneralNews generalNews = gson.fromJson(request.body(),GeneralNews.class);
            newsDao.save(generalNews);
            response.status(201);
            response.type("application/json");
            return gson.toJson(generalNews);
        });

        post("/departmentnews","application/json", (request, response) -> {
            DepartmentNews departmentNews = gson.fromJson(request.body(),DepartmentNews.class);
            newsDao.save(departmentDao);
            response.status(201);
            response.type("application/json");
            return gson.toJson(departmentNews);
        });
    }
}
