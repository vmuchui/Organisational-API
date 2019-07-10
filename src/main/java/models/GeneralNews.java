package models;

import java.util.Objects;

public class GeneralNews extends News {
    public final String TYPE = "general";
    private int id;
    public final int departmentId;
    public GeneralNews(String headlines, String content) {
        this.setHeadlines(headlines);
        this.setContent(content);
        this.departmentId = 0;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeneralNews)) return false;
        GeneralNews that = (GeneralNews) o;
        return getId() == that.getId() &&
                departmentId == that.departmentId &&
                TYPE.equals(that.TYPE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TYPE, getId(), departmentId);
    }
}
