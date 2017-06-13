-- 3. Вычислить общую ЗП всех Java разработчиков. 

use homework_1;

-- CREATE OR REPLACE VIEW task3_Java_salaries AS
    SELECT 
        skills.SKILL_NAME, SUM(developers.DEVELOPER_SALARY) AS total_salary
    FROM
        developers
            INNER JOIN
        developer_skill ON developers.DEVELOPER_ID = developer_skill.DEVELOPER_ID
            INNER JOIN
        skills ON developer_skill.SKILL_ID = skills.SKILL_ID
    WHERE
        skills.SKILL_NAME = 'Java';
 

-- SELECT * FROM homework_1.task3_java_salaries;



-- второй вариант, в котором я учла, что если разработчики работают над несколькими проектами, 
-- то и зарплату они получают разную на каждом проекте. Поєтому добавила в таблицу developer_project
-- поле SALARY. В первом варианте у разработчика біла какая-то общая зарплата со всех проектов в поле 
-- DEVELOPER_SALARY в таблице  developers
SELECT 
    skills.SKILL_NAME, SUM(SALARY) AS total_salary
FROM
    developer_project
        JOIN
    developer_skill ON developer_project.DEVELOPER_ID = developer_skill.DEVELOPER_ID
        JOIN
    skills ON developer_skill.SKILL_ID = skills.SKILL_ID
GROUP BY skills.SKILL_ID;
-- WHERE SKILL_NAME = 'Java'
