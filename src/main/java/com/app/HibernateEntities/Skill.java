package com.app.HibernateEntities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 04.06.2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Skill.getAll", query = "select s from Skill s"),
        @NamedQuery(name = "Skill.countAll", query = "select count(s) from Skill s")
})
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

//    @ManyToMany(mappedBy = "skills", cascade = {CascadeType.REFRESH})
//    private List<Developer> developers = new ArrayList<>();

    public Skill() {
    }

    public Skill(String name) {
        this.name = name;
    }

    public Skill(int id, String name) {
        this.id = id ;
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

//    public List<Developer> getDevelopers() {
//        return developers;
//    }
//
//    public void setDevelopers(List<Developer> developers) {
//        this.developers = developers;
//    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", developers=" + developers +  //TODO будет StackOverflowError, если и в Skill и в Developer выводить соответственно developers и skills (будут циклически ссылаться друг на друга)
                '}';
    }
}
