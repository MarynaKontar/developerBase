package com.app.Entities;

/**
 * Created by User on 04.06.2017.
 */
public class Project {

    private long id;
    private String name;
    private int cost;
//    private Company company;
//    private Customer customer
    private long companyId;
    private long customerId;


    public Project(long id, String name, int cost, long companyId, long customerId) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.companyId = companyId;
        this.customerId = customerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
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
