SELECT 
    MIN(sumtable1.sum_cost) AS min_cost,
    sumtable1.customers_name,
    sumtable1.customers_surname
FROM
    (SELECT 
        SUM(cost) AS sum_cost,
            customers.name AS customers_name,
            customers.surname AS customers_surname,
            customers.id AS customers_id,
            companies.id AS companies_id
    FROM
        customers
    INNER JOIN customers_projects ON customers.id = customers_projects.customer_id
    INNER JOIN projects ON projects.id = customers_projects.project_id
    INNER JOIN companies_projects ON companies_projects.project_id = projects.id
    INNER JOIN companies ON companies_projects.company_id = companies.id
    GROUP BY companies_projects.company_id , customers.id) AS sumtable1
GROUP BY sumtable1.customers_id , sumtable1.companies_id;


SELECT
  customerName,
  companyName,
  MIN(projectCost)
FROM
  ((SELECT
      projects.name      AS projectName,
      SUM(projects.cost) AS projectCost,
      customers.name     AS customerName,
      companies.name     AS companyName
    FROM projects
      INNER JOIN projects_customers ON projects.id = projects_customers.project_id
      INNER JOIN customers ON customers.id = projects_customers.customers_id
      INNER JOIN project_company ON projects.id = project_company.project_id
      INNER JOIN companies ON companies.id = project_company.company_id

    GROUP BY companies.name, customers.name) AS Stat)

GROUP BY companyName