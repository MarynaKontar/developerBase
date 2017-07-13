package com.app.HibernateEntities;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by User on 04.06.2017.
 */
@Entity
//@Table(name = "developer")
@NamedQueries({
        @NamedQuery(name = "Developer.getAll", query = "select d from Developer d"),
        @NamedQuery(name = "Developer.countAll", query = "select count(d) from Developer d")
})
public class Developer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String lastName;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})// если оставить LAZY, то не подтянет skills и, например при выводе  daoDeveloper.getAll().forEach(System.out::println) будет ошибка в toString() (skills)
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


    public void addSkill(Skill skill) {
        skills.add( skill );
        skill.getDevelopers().add( this );
    }

    public void removeSkill(Skill skill) {
        skills.remove(skill );
        skill.getDevelopers().remove( this );
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Developer developer = (Developer) o;
//        return Objects.equals(name, developer.name) &&
//                Objects.equals(lastName, developer.lastName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, lastName);
//    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
//                ", skills=" + skills +
//                ", projects=" + projects +
                '}';
    }
}
