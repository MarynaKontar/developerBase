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




-- второй вариант, в котором я учла, что если разработчики работают над несколькими проектами, 
-- то и зарплату они получают разную на каждом проекте. Поєтому добавила в таблицу developer_project
-- поле SALARY. В первом варианте у разработчика біла какая-то общая зарплата со всех проектов в поле 
-- DEVELOPER_SALARY в таблице  developers
SELECT 
    PROJECT_ID, SUM(SALARY) sum_salary
FROM
    developer_project
GROUP BY PROJECT_ID
ORDER BY sum_salary DESC;
-- LIMIT 1;