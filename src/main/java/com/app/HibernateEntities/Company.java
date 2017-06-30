package com.app.HibernateEntities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 04.06.2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Company.getAll", query = "select c from Company c"),
        @NamedQuery(name = "Company.countAll", query = "select count(c) from Company c")
})
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Project> projects = new HashSet<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
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

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", projects=" + projects +
                '}';
    }
}
