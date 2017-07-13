package com.app.DAO.HibernateDao;

import com.app.DAO.DAO;
import com.app.HibernateEntities.Developer;
import com.app.HibernateEntities.DeveloperProject;
import com.app.HibernateEntities.Project;

import java.util.List;

/**
 * Created by User on 30.06.2017.
 */
public interface HibernateDAOProject extends DAO<Integer, Project> {
    void addDeveloperToProject(Integer developerId, int salary, Integer projectId);
    void addDeveloperAndProject(Project project,Developer developer, int salary);

    void removeDeveloperFromProject(Integer developerId, Integer projectId);

    List<DeveloperProject> getAllDevelopersFromProject(Integer projectId);
}
