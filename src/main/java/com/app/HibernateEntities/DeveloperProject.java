package com.app.HibernateEntities;

import javax.persistence.*;
import java.io.Serializable;

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

    private int salary;

    public DeveloperProject() {
    }

    public DeveloperProject(Developer developer, Project project) {
        this.developer = developer;
        this.project = project;
    }

    public DeveloperProject(Developer developer, Project project, int salary) {
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeveloperProject that = (DeveloperProject) o;

        if (salary != that.salary) return false;
        if (!developer.equals(that.developer)) return false;
        return project.equals(that.project);
    }

    @Override
    public int hashCode() {
        int result = developer.hashCode();
        result = 31 * result + project.hashCode();
        result = 31 * result + salary;
        return result;
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
