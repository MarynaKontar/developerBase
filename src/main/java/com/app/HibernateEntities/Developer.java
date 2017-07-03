package com.app.HibernateEntities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 04.06.2017.
 */
@Entity
//@Table(name = "developer")
@NamedQueries({
        @NamedQuery(name = "Developer.getAll", query = "select d from Developer d"),
        @NamedQuery(name = "Developer.countAll", query = "select count(d) from Developer d")
})
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String lastName;

//    @ManyToMany(cascade = {CascadeType.ALL})
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Skill> skills;

//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    private List<Project> projects = new ArrayList<>();

    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeveloperProject> projects = new ArrayList<>();

    public Developer() {

    }

    public Developer(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<DeveloperProject> getProjects() {
        return projects;
    }

    public void setProjects(List<DeveloperProject> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", skills=" + skills +
                ", projects=" + projects +
                '}';
    }
}
