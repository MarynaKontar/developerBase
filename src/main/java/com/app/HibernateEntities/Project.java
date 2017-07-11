package com.app.HibernateEntities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 04.06.2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Project.getAll", query = "select p from com.app.HibernateEntities.Project p"),
        @NamedQuery(name = "Project.countAll", query = "select count(p) from Project p")
})
public class Project  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int cost;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Customer customer;

//    @ManyToMany(mappedBy = "projects")
//    private List<Developer> developers = new ArrayList<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeveloperProject> developers = new ArrayList<>();

    public Project() {
    }

    public Project(String name, int cost, Company company, Customer customer) {
        this.name = name;
        this.cost = cost;
        this.company = company;
        this.customer = customer;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<DeveloperProject> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<DeveloperProject> developerProjects) {
        this.developers = developerProjects;
    }

    public void addDeveloperWithSalary(Developer developer, int salary) {
        DeveloperProject developerProject = new DeveloperProject(developer, this, salary);
        developers.add(developerProject);
        developer
                .getProjects()
                .add(developerProject);
    }

    public void removeDeveloper(Developer developer){
        DeveloperProject developerProject = new DeveloperProject(developer, this);
        developer.getProjects().remove(developerProject);
        developerProject.setDeveloper(null);
        developerProject.setProject(null);
        developerProject.setSalary(0);//TODO как сделать, чтобы garbage collector знал, что ему надо удалить 'тот объект (developerProject)? Т.е. какое значение salary присвоить?
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", company=" + company +
                ", customer=" + customer +
//                ", developers=" + developers +
                '}';
    }
}
