package models;

import java.util.Objects;

public class DepartmentNews extends News {
    public final String TYPE = "department";
    private int id;
    private int departmentId;

    public DepartmentNews(String headlines, String content, int departmentId) {
        this.setHeadlines(headlines);
        this.setContent(content);
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartmentId() {
        return departmentId;
    }


    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepartmentNews)) return false;
        DepartmentNews that = (DepartmentNews) o;
        return getId() == that.getId() &&
                getDepartmentId() == that.getDepartmentId() &&
                TYPE.equals(that.TYPE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TYPE, getId(), getDepartmentId());
    }
}
