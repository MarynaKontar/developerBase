-- 3. Вычислить общую ЗП всех Java разработчиков. 

use homework_1;

CREATE OR REPLACE VIEW task3_Java_salaries AS
    SELECT 
        skills.SKILL_NAME, SUM(developers.DEVELOPER_SALARY) AS total_salary
    FROM
        developers
            INNER JOIN
        developer_skill ON developers.DEVELOPER_ID = developer_skill.DEVELOPER_ID
            INNER JOIN
        skills ON developer_skill.SKILL_ID = skills.SKILL_ID
    WHERE
        skills.SKILL_NAME LIKE 'Java';
 

SELECT * FROM homework_1.task3_java_salaries;