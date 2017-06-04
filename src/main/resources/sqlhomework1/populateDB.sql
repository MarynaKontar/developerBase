use homework_1;

INSERT INTO developers (DEVELOPER_NAME, DEVELOPER_LASTNAME) 
VALUES ('Ihor', 'Shylo');

INSERT INTO developers (DEVELOPER_NAME, DEVELOPER_LASTNAME) 
VALUES ('Anna', 'Olifer');

INSERT INTO developers (DEVELOPER_NAME, DEVELOPER_LASTNAME) 
VALUES ('Yrii', 'Hizun');

INSERT INTO developers (DEVELOPER_NAME, DEVELOPER_LASTNAME) 
VALUES ('Guilaume', 'Gingembre');

INSERT INTO developers (DEVELOPER_NAME, DEVELOPER_LASTNAME) 
VALUES ('Denis', 'Ivashkov');

INSERT INTO developers (DEVELOPER_NAME, DEVELOPER_LASTNAME) 
VALUES ('Pavel', 'Rosovskiy');

INSERT INTO developers (DEVELOPER_NAME, DEVELOPER_LASTNAME) 
VALUES ('Maryna', 'Kontar');

SELECT * FROM developers;


INSERT INTO skills (SKILL_NAME) VALUES ('Java');
INSERT INTO skills (SKILL_NAME) VALUES ('C++');
INSERT INTO skills (SKILL_NAME) VALUES ('JavaScript');
INSERT INTO skills (SKILL_NAME) VALUES ('Pithon');
INSERT INTO skills (SKILL_NAME) VALUES ('Go');
INSERT INTO skills (SKILL_NAME) VALUES ('SQL');
INSERT INTO skills (SKILL_NAME) VALUES ('JDBC');
INSERT INTO skills (SKILL_NAME) VALUES ('Hibernate');
INSERT INTO skills (SKILL_NAME) VALUES ('HTTP');
INSERT INTO skills (SKILL_NAME) VALUES ('Servlets');
INSERT INTO skills (SKILL_NAME) VALUES ('DI Ios');
INSERT INTO skills (SKILL_NAME) VALUES ('Spring');
INSERT INTO skills (SKILL_NAME) VALUES ('Maven');
INSERT INTO skills (SKILL_NAME) VALUES ('Junit');
INSERT INTO skills (SKILL_NAME) VALUES ('Mockito');
INSERT INTO skills (SKILL_NAME) VALUES ('Github');

SELECT * FROM skills;


INSERT INTO companies (COMPANY_NAME) VALUES ('EPAM');
INSERT INTO companies (COMPANY_NAME) VALUES ('SoftServe');
INSERT INTO companies (COMPANY_NAME) VALUES ('Luxoft');
INSERT INTO companies (COMPANY_NAME) VALUES ('GlobalLogic');
INSERT INTO companies (COMPANY_NAME) VALUES ('Ciklum');
INSERT INTO companies (COMPANY_NAME) VALUES ('Infopulse');
INSERT INTO companies (COMPANY_NAME) VALUES ('Netcracker');
INSERT INTO companies (COMPANY_NAME) VALUES ('DataArt');
INSERT INTO companies (COMPANY_NAME) VALUES ('ELEKS');
INSERT INTO companies (COMPANY_NAME) VALUES ('Terrasoft');

SELECT * FROM companies;


INSERT INTO customers (CUSTOMER_NAME) VALUES ('customer1');
INSERT INTO customers (CUSTOMER_NAME) VALUES ('customer2');
INSERT INTO customers (CUSTOMER_NAME) VALUES ('customer3');
INSERT INTO customers (CUSTOMER_NAME) VALUES ('customer4');

SELECT * FROM customers;


INSERT INTO projects (PROJECT_NAME, COMPANY_ID, CUSTOMER_ID) VALUES ('PROJECT1', 2, 4);
INSERT INTO projects (PROJECT_NAME, COMPANY_ID, CUSTOMER_ID) VALUES ('PROJECT2', 1, 2);
INSERT INTO projects (PROJECT_NAME, COMPANY_ID, CUSTOMER_ID) VALUES ('PROJECT3', 2, 2);
INSERT INTO projects (PROJECT_NAME, COMPANY_ID, CUSTOMER_ID) VALUES ('PROJECT4', 10, 4);
INSERT INTO projects (PROJECT_NAME, COMPANY_ID, CUSTOMER_ID) VALUES ('PROJECT5', 5, 1);

SELECT * FROM projects;


INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (1, 1);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (1, 16);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (1, 6);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (1, 7);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (2, 1);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (2, 2);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (2, 5);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (2, 9);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (3, 1);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (3, 4);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (3, 8);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (4, 2);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (4, 3);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (4, 4);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (5, 1);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (5, 12);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (5, 15);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (6, 13);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (6, 10);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (6, 5);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (7, 1);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (7, 6);
INSERT INTO developer_skill (DEVELOPER_ID, SKILL_ID) VALUES (7, 7);

SELECT * FROM developer_skill;


INSERT INTO developer_project (DEVELOPER_ID, PROJECT_ID) VALUES (1, 5);
INSERT INTO developer_project (DEVELOPER_ID, PROJECT_ID) VALUES (1, 1);
INSERT INTO developer_project (DEVELOPER_ID, PROJECT_ID) VALUES (2, 4);
INSERT INTO developer_project (DEVELOPER_ID, PROJECT_ID) VALUES (3, 2);
INSERT INTO developer_project (DEVELOPER_ID, PROJECT_ID) VALUES (3, 3);
INSERT INTO developer_project (DEVELOPER_ID, PROJECT_ID) VALUES (4, 5);
INSERT INTO developer_project (DEVELOPER_ID, PROJECT_ID) VALUES (5, 4);
INSERT INTO developer_project (DEVELOPER_ID, PROJECT_ID) VALUES (6, 5);
INSERT INTO developer_project (DEVELOPER_ID, PROJECT_ID) VALUES (7, 5);
INSERT INTO developer_project (DEVELOPER_ID, PROJECT_ID) VALUES (7, 1);

SELECT * FROM developer_project;
