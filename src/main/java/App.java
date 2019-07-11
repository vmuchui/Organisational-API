import com.google.gson.Gson;
import dao.DepartmentDao;
import dao.Sql20DepartmentDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUserDao;
import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import static spark.Spark.*;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.ModelAndView;

import java.util.HashMap;
import java.util.Map;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        Sql2oNewsDao newsDao;
        Sql2oUserDao userDao;
        Sql20DepartmentDao departmentDao;
        Sql2o sql2o = DB.sql2o;
        Connection conn = sql2o.open();
        Gson gson = new Gson();

        departmentDao = new Sql20DepartmentDao();
        userDao = new Sql2oUserDao();
        newsDao = new Sql2oNewsDao();

// routing API

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

        get("/users", "application/json",(request, response) -> {
            response.type("application/json");
            return gson.toJson(userDao.getAll());
        });

        get("/user/:id","application/json", (request, response) -> {
            User user = userDao.find(Integer.parseInt(request.params(":id")));
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

        get("/generalnews","application/json",(request, response) -> {
            response.type("application/json");
            return gson.toJson(newsDao.getAll());
        });

        get("/generalnews/:id","application/json",(request, response) -> {
            GeneralNews generalNews = (GeneralNews) newsDao.find(Integer.parseInt(request.params(":id")));
            response.type("application/json");
            return gson.toJson(generalNews);
        });

        post("/departmentnews","application/json", (request, response) -> {
            DepartmentNews departmentNews = gson.fromJson(request.body(),DepartmentNews.class);
            newsDao.save(departmentNews);
            response.status(201);
            response.type("application/json");
            return gson.toJson(departmentNews);
        });

        get("/departmentnews/:id", "application/json", (request, response) -> {
            response.type("application/json");
            return gson.toJson(newsDao.getDeptNews(Integer.parseInt(request.params(":id"))));
        });


//        routing using templates
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("general", newsDao.getAll());
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
