package com.app.HibernateEntities;

import javax.persistence.*;

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

    public Skill() {
    }

    public Skill(String name) {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Skill{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
