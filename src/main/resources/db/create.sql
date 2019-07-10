SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS departments (

    id int PRIMARY KEY auto_increment,
    name VARCHAR,
    email VARCHAR

);

CREATE TABLE IF NOT EXISTS users (
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
    role VARCHAR,
    rank VARCHAR,
    email VARCHAR,
    departmentId int

);

CREATE TABLE IF NOT EXISTS news (
    id int PRIMARY KEY auto_increment,
    type VARCHAR,
    headlines VARCHAR,
    content VARCHAR,
    departmentId int

);