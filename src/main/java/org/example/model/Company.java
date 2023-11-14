package org.example.model;

public class Company {
    private int id;
    private String name;
    private long capitalization;

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capitalization=" + capitalization +
                '}';
    }

    public Company(int id, String name, long capitalization) {
        this.id = id;
        this.name = name;
        this.capitalization = capitalization;
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

    public long getCapitalization() {
        return capitalization;
    }

    public void setCapitalization(int capitalization) {
        this.capitalization = capitalization;
    }
}
