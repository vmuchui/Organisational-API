package models;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private int departmentId;
    private String rank;
    private String role;
    private String email;

    public User(String name, int departmentId, String rank, String role, String email) {
        this.name = name;
        this.departmentId = departmentId;
        this.rank = rank;
        this.role = role;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                getDepartmentId() == user.getDepartmentId() &&
                getName().equals(user.getName()) &&
                getRank().equals(user.getRank()) &&
                getRole().equals(user.getRole()) &&
                getEmail().equals(user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDepartmentId(), getRank(), getRole(), getEmail());
    }

}
