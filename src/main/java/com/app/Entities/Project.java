package com.app.Entities;

/**
 * Created by User on 04.06.2017.
 */
public class Project {

    private int id;
    private String name;
    private int cost;
//    private Company company;
//    private Customer customer
    private int companyId;
    private int customerId;

    public Project() {
    }

    public Project(String name, int cost, int companyId, int customerId) {
        this.name = name;
        this.cost = cost;
        this.companyId = companyId;
        this.customerId = customerId;
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

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Project{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", cost=").append(cost);
        sb.append(", companyId=").append(companyId);
        sb.append(", customerId=").append(customerId);
        sb.append('}');
        return sb.toString();
    }
}
