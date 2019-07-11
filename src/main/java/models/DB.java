package models;

import org.sql2o.Sql2o;

public class DB {

    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/org_api", "victor", "Am0skwito");

//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-107-21-120-104.compute-1.amazonaws.com:5432/daojp9ukf7uf33","jyuplhwqlvrwsw","b248c32ba6d7c1c2f8ae6d09e44c4dc755150bf1be9664f5840e1496e5222500");
}
