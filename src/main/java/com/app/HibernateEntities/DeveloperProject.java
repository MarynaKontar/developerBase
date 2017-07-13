package com.app.HibernateEntities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by User on 30.06.2017.
 */
@Entity
//@Table(name = "developer_project")
public class DeveloperProject implements Serializable{
    @Id
    @ManyToOne
    private Developer developer;
    @Id
    @ManyToOne
    private Project project;

    private Integer salary;

    public DeveloperProject() {
    }

    public DeveloperProject(Developer developer, Project project) {
        this.developer = developer;
        this.project = project;
    }

    public DeveloperProject(Developer developer, Project project, Integer salary) {
        this.developer = developer;
        this.project = project;
        this.salary = salary;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeveloperProject that = (DeveloperProject) o;
        return Objects.equals(developer, that.developer) &&
                Objects.equals(project, that.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(developer, project);
    }

    @Override
    public String toString() {
        return "DeveloperProject{" +
                "developer=" + developer +
                ", project=" + project +
                ", salary=" + salary +
                '}';
    }
}
