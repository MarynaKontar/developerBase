-- 2. Найти самый дорогой проект (исходя из ЗП разработчиков).

USE homework_1;

-- CREATE OR REPLACE VIEW task2_projects_salaries AS
    SELECT 
    projects.PROJECT_ID,
    projects.PROJECT_NAME,
    SUM(developers.DEVELOPER_SALARY) sum_salary
FROM
    developers
        INNER JOIN
    developer_project ON developers.DEVELOPER_ID = developer_project.DEVELOPER_ID
        INNER JOIN
    projects ON developer_project.PROJECT_ID = projects.PROJECT_ID
GROUP BY projects.PROJECT_ID
ORDER BY sum_salary DESC;
-- LIMIT 1;	



-- SELECT * FROM homework_1.task2_projects_salaries;