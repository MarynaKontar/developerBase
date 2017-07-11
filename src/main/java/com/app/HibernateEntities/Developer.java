package com.app.HibernateEntities;

import javax.persistence.*;
import java.io.Serializable;
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
public class Developer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String lastName;

    @ManyToMany(cascade = {CascadeType.REFRESH})// если оставить LAZY, то не подтянет skills и, например при выводе  daoDeveloper.getAll().forEach(System.out::println) будет ошибка в toString() (skills)
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

//    public String toStringProjects() {
//        return "projects=" + projects;
//    }
}
