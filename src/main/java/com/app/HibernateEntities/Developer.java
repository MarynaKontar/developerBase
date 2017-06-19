package com.app.HibernateEntities;

import java.util.List;
import java.util.Map;

/**
 * Created by User on 04.06.2017.
 */
public class  Developer {

    private int id;
    private String name;
    private String lastName;
//    private List<Skill> skills;
    private List<Integer> skillIdList;
    //Map of projects id and developer salaries on these projects
    private Map<Integer, Integer> projectIDSalary;

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

    public List<Integer> getSkillIdList() {
        return skillIdList;
    }

    public void setSkillIdList(List<Integer> skillIdList) {
        this.skillIdList = skillIdList;
    }

    public Map<Integer, Integer> getProjectIDSalary() {
        return projectIDSalary;
    }

    public void setProjectIDSalary(Map<Integer, Integer> projectIDSalary) {
        this.projectIDSalary = projectIDSalary;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Developer{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", skillIdList=").append(skillIdList);
        sb.append(", projectIDSalary=").append(projectIDSalary);
        sb.append('}');
        return sb.toString();
    }
}
