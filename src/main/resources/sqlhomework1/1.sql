-- 1. Добавить разаработчикам поле (salary - зарплата). 

use homework_1;

-- ALTER TABLE developers 
-- 	ADD DEVELOPER_SALARY INT(6) DEFAULT NULL
-- 	AFTER DEVELOPER_LASTNAME;

-- UPDATE developers SET DEVELOPER_SALARY=2000 WHERE DEVELOPER_LASTNAME ='Shylo' AND DEVELOPER_NAME='Ihor';
-- UPDATE developers SET DEVELOPER_SALARY=1100 WHERE DEVELOPER_LASTNAME = 'Olifer' AND DEVELOPER_NAME LIKE 'Anna';
-- UPDATE developers SET DEVELOPER_SALARY=800 WHERE DEVELOPER_LASTNAME = 'Hizun' AND DEVELOPER_NAME LIKE 'Yrii';
-- UPDATE developers SET DEVELOPER_SALARY=850 WHERE DEVELOPER_LASTNAME = 'Gingembre' AND DEVELOPER_NAME LIKE 'Guilaume';
-- UPDATE developers SET DEVELOPER_SALARY=900 WHERE DEVELOPER_LASTNAME = 'Ivashkov' AND DEVELOPER_NAME LIKE 'Denis';
-- UPDATE developers SET DEVELOPER_SALARY=1000 WHERE DEVELOPER_LASTNAME = 'Rosovskiy' AND DEVELOPER_NAME LIKE 'Pavel';
-- UPDATE developers SET DEVELOPER_SALARY=1100 WHERE DEVELOPER_LASTNAME = 'Kontar' AND DEVELOPER_NAME LIKE 'Maryna';

-- SELECT * FROM developers;



-- второй вариант, в котором я учла, что если разработчики работают над несколькими проектами, 
-- то и зарплату они получают разную на каждом проекте. Поєтому добавила в таблицу developer_project
-- поле SALARY. В первом варианте у разработчика біла какая-то общая зарплата со всех проектов в поле 
-- DEVELOPER_SALARY в таблице  developers

-- ALTER TABLE developer_project ADD SALARY INT(6) DEFAULT NULL;

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
