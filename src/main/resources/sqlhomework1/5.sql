-- 5. Найти клиента (customer), которая приносит меньше всего
-- прибыли компании (company) для каждой из компаний.

use homework_1;

-- CREATE OR REPLACE VIEW task5 AS
    SELECT 
        companies.COMPANY_NAME, customers.CUSTOMER_NAME, MIN(projects.PROJECT_COST) AS profit
    FROM
        projects
            JOIN
        customers ON projects.CUSTOMER_ID = customers.CUSTOMER_ID
            JOIN
        companies ON projects.COMPANY_ID = companies.COMPANY_ID
    GROUP BY (projects.COMPANY_ID);
    

-- SELECT * FROM task5;