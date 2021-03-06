use homework_1;

INSERT INTO developers (DEVELOPER_NAME, DEVELOPER_LASTNAME) VALUES 
('Ihor', 'Shylo'),('Anna', 'Olifer'), ('Yrii', 'Hizun'), 
('Guilaume', 'Gingembre'), ('Denis', 'Ivashkov'),
('Pavel', 'Rosovskiy'),('Maryna', 'Kontar');

SELECT * FROM developers;


INSERT INTO skills (SKILL_NAME) VALUES 
('Java'), ('C++'), ('JavaScript'), ('Pithon'), 
('Go'), ('SQL'), ('JDBC'), ('Hibernate'),
('HTTP'), ('Servlets'),  ('DI Ios'), ('Spring'),
('Maven'), ('Junit'), ('Mockito'), ('Github');

SELECT * FROM skills;


INSERT INTO companies (COMPANY_NAME) VALUES 
('EPAM'), ('SoftServe'), ('Luxoft'),
('GlobalLogic'), ('Ciklum'), ('Infopulse'),
('Netcracker'), ('DataArt'), ('ELEKS'), ('Terrasoft');

SELECT * FROM companies;


INSERT INTO customers (CUSTOMER_NAME) VALUES 
('customer1'), ('customer2'), ('customer3'), ('customer4');

SELECT * FROM customers;


INSERT INTO projects (PROJECT_NAME, COMPANY_ID, CUSTOMER_ID) VALUES 
('PROJECT1', 6, 1), ('PROJECT2', 7, 2), ('PROJECT3', 6, 2), 
('PROJECT4', 7, 4), ('PROJECT5', 5, 1), ('PROJECT6', 6, 4);


INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES 
(1, 1), (1, 16), (1, 6), (1, 7), (2, 1), (2, 2), (2, 5), 
(2, 9), (3, 1), (3, 4), (3, 8), (4, 2), (4, 3), (4, 4), 
(5, 1), (5, 12), (5, 15), (6, 13), (6, 10), (6, 5),
(7, 1), (7, 6), (7, 7);

SELECT * FROM developer_skill;


INSERT INTO developer_project (DEVELOPER_ID, PROJECT_ID) VALUES 
(1, 5), (1, 1), (2, 4), (2,6), (3, 2), (3, 3), 
(4, 5), (5, 4), (6, 5), (7, 5), (7, 1);




UPDATE developer_project SET SALARY = 1000 WHERE DEVELOPER_ID = 1 AND PROJECT_ID = 1;  
UPDATE developer_project SET SALARY = 1100 WHERE DEVELOPER_ID = 7 AND PROJECT_ID = 1;  
UPDATE developer_project SET SALARY = 1300 WHERE DEVELOPER_ID = 3 AND PROJECT_ID = 2;  
UPDATE developer_project SET SALARY = 1400 WHERE DEVELOPER_ID = 3 AND PROJECT_ID = 3;  
UPDATE developer_project SET SALARY = 900 WHERE DEVELOPER_ID = 2 AND PROJECT_ID = 4;  
UPDATE developer_project SET SALARY = 850 WHERE DEVELOPER_ID = 5 AND PROJECT_ID = 4;  
UPDATE developer_project SET SALARY = 700 WHERE DEVELOPER_ID = 1 AND PROJECT_ID = 5;  
UPDATE developer_project SET SALARY = 1500 WHERE DEVELOPER_ID = 4 AND PROJECT_ID = 5;  
UPDATE developer_project SET SALARY = 1350 WHERE DEVELOPER_ID = 6 AND PROJECT_ID = 5;  
UPDATE developer_project SET SALARY = 1200 WHERE DEVELOPER_ID = 7 AND PROJECT_ID = 5;  
UPDATE developer_project SET SALARY = 1100 WHERE DEVELOPER_ID = 2 AND PROJECT_ID = 6;  

SELECT * FROM developer_project;


UPDATE projects SET PROJECT_COST=50000 WHERE PROJECT_ID=1;
UPDATE projects SET PROJECT_COST=65000 WHERE PROJECT_ID=2;
UPDATE projects SET PROJECT_COST=20000 WHERE PROJECT_ID=3;
UPDATE projects SET PROJECT_COST=45000 WHERE PROJECT_ID=4;
UPDATE projects SET PROJECT_COST=105000 WHERE PROJECT_ID=5;
UPDATE projects SET PROJECT_COST=500 WHERE PROJECT_ID=6;

SELECT * FROM projects;