-- 5. Найти клиента (customer), которая приносит меньше всего
-- прибыли компании (company) для каждой из компаний.

use homework_1;

CREATE OR REPLACE VIEW task5 AS
    SELECT 
        customers.*, SUM(projects.PROJECT_COST) AS profit
    FROM
        projects
            JOIN
        customers ON projects.CUSTOMER_ID = customers.CUSTOMER_ID
    GROUP BY (projects.CUSTOMER_ID)
    ORDER BY profit DESC;
-- LIMIT 1;

SELECT * FROM task5;