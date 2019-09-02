package com.cactus.reservationclient.domin;

public class User {
    private Long id;

    private String name;

    private String other;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public User(String name, String other) {
        this.name = name;
        this.other = other;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}
