package models;

import models.DB;
import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


public class DataBaseRule extends ExternalResource{
    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/org_api_test", "victor", "Am0skwito");

    }
    @Override
    protected void after() {
        try (Connection con = DB.sql2o.open()){
            String initializeusers = "DELETE FROM users *;";
            String initializedepartments = "DELETE FROM departments *;";
            String initializenews = "DELETE FROM news *;";
            con.createQuery(initializeusers).executeUpdate();
            con.createQuery(initializedepartments).executeUpdate();
            con.createQuery(initializenews).executeUpdate();
        }
    }

}
