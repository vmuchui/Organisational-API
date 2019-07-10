package dao;

import models.DepartmentNews;
import models.GeneralNews;

import java.util.List;

public interface NewsDao  {
    void save(Object o);
    Object find(int id);
    List<GeneralNews> getAll();
    List<DepartmentNews> getDeptNews(int id);
    void update(GeneralNews gen, int id);
    void delete(Object o);
    void clearAll();
}
