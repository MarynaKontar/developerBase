CREATE DATABASE IF NOT EXISTS test;
use test;
-- есть  таблица с числами, надо составить таблицу с не повторяющимися комбинациями этих чисел
-- если без distinctrow,  то при повторяющихся числах в исходной таблице будут повторяться и пары чисел. 
-- В моем примере в таблице повторяются 7 и без distinctrow будет по две пары 2 7, 7 34, 7 56 и т.д.
-- Если нужны пары (1, 1), (2, 2), то t1.number<=t2.number

CREATE TABLE IF NOT EXISTS test_table(
id INT(11) NOT NULL auto_increment, 
number INT(11),
PRIMARY KEY (id)
);

INSERT INTO test_table (number) VALUES (34),(2),(56),(7),(11),(103),(7);


 SELECT distinctrow t1.number as n1, t2.number as n2
 FROM test_table t1
 INNER JOIN 
 test_table t2 ON t1.number<=t2.number;