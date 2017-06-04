-- 6. Вычислить, среднюю ЗП программистов в проекте, который приносит наименьшую прибыль.

use homework_1;

-- CREATE OR REPLACE VIEW task6 AS
    SELECT 
        projects.PROJECT_ID, projects.PROJECT_NAME, 
        projects.PROJECT_COST, AVG(developers.DEVELOPER_SALARY) average_salary
    FROM
        developers
            INNER JOIN
        developer_project
            INNER JOIN
        projects ON developers.DEVELOPER_ID = developer_project.DEVELOPER_ID
            AND developer_project.PROJECT_ID = projects.PROJECT_ID
    GROUP BY projects.PROJECT_ID
    ORDER BY PROJECT_COST;
    -- LIMIT 1;
    
SELECT * FROM task6;    
    