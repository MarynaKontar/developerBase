-- 5. Найти клиента (customer), которая приносит меньше всего
-- прибыли компании (company) для каждой из компаний.
-- SET sql_mode=(SELECT REPLACE(@@sql_mode, 'ONLY_FULL_GROUP_BY', ''));
use homework_1;

-- CREATE OR REPLACE VIEW task5 AS
  SELECT 
    projects.PROJECT_COST,
    companies.COMPANY_ID,
    customers.CUSTOMER_ID
FROM
    projects 
        JOIN
    (SELECT 
        companies.COMPANY_ID, @min_cost:=min(projects.PROJECT_COST)
    FROM
        companies co
    JOIN projects ON projects.COMPANY_ID = companies.COMPANY_ID
    GROUP BY companies.COMPANY_ID) as t1  
        JOIN
    customers ON  customers.CUSTOMER_ID Where projects.PROJECT_COST like @min_cost 
-- GROUP BY projects.COMPANY_ID
    

-- SELECT * FROM task5;


