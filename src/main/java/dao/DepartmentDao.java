package dao;

import models.Department;

import java.util.List;

public interface DepartmentDao {

    void save(Department department);
    List<Department> getAll();
    Department find(int id);

    void update(Department department, int id);
    void delete(Department department);
    void clearAll();
}
