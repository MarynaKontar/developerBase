-- 6. Вычислить, среднюю ЗП программистов в проекте, который приносит наименьшую прибыль.

use homework_1;

-- CREATE OR REPLACE VIEW task6 AS
    SELECT 
        projects.PROJECT_ID, projects.PROJECT_NAME, 
        projects.PROJECT_COST, AVG(developer_project.SALARY) average_salary -- developers.DEVELOPER_SALARY
    FROM 
        developers
            INNER JOIN
        developer_project ON developers.DEVELOPER_ID = developer_project.DEVELOPER_ID
            INNER JOIN
        projects ON developer_project.PROJECT_ID = projects.PROJECT_ID
    GROUP BY projects.PROJECT_ID
    ORDER BY PROJECT_COST;
    -- LIMIT 1;
    
-- SELECT * FROM task6;    
    
    
-- AVG(developer_project.SALARY) учитывает, что если разработчики работают над несколькими проектами, 
-- то и зарплату они получают разную на каждом проекте. Поэтому добавила в таблицу developer_project
-- поле SALARY. В первом варианте у разработчика была какая-то общая зарплата со всех проектов в поле 
-- DEVELOPER_SALARY в таблице  developers (AVG(developers.DEVELOPER_SALARY))