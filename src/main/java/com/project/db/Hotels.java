package com.project.db;

public class Hotels {
    private Long id;
    private String name;
    private String country;
    private int stars;

    public Hotels() {
    }

    public Hotels(Long id, String name, String country, int stars) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.stars = stars;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "Hotels{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", stars=" + stars +
                '}';
    }
}
