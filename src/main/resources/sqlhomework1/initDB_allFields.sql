DROP DATABASE IF EXISTS homework_1;
CREATE DATABASE IF NOT EXISTS homework_1;

use homework_1;

-- developers
CREATE TABLE IF NOT EXISTS developers(
DEVELOPER_ID INT(11) UNSIGNED NOT NULL  auto_increment,
DEVELOPER_NAME VARCHAR(255) NOT NULL,
DEVELOPER_LASTNAME VARCHAR(255) NOT NULL,
PRIMARY KEY(DEVELOPER_ID)
);
 
 -- skills
 CREATE TABLE IF NOT EXISTS  skills(
 SKILL_ID INT(11) UNSIGNED NOT NULL auto_increment,
 SKILL_NAME VARCHAR(255) NOT NULL,
 PRIMARY KEY(SKILL_ID)
 );

-- companies
CREATE TABLE IF NOT EXISTS companies(
 COMPANY_ID INT(11) UNSIGNED NOT NULL auto_increment,
 COMPANY_NAME VARCHAR(255) NOT NULL,
 PRIMARY KEY(COMPANY_ID)
 );
 
 
 -- customers
CREATE TABLE IF NOT EXISTS customers(
 CUSTOMER_ID INT(11) UNSIGNED NOT NULL auto_increment,
 CUSTOMER_NAME VARCHAR(255) NOT NULL,
 PRIMARY KEY(CUSTOMER_ID)
 );
 
 
 -- projects
 CREATE TABLE IF NOT EXISTS projects(
 PROJECT_ID INT(11) UNSIGNED NOT NULL auto_increment,
 PROJECT_NAME VARCHAR(255) NOT NULL,
 PROJECT_COST INT(11) DEFAULT NULL,
 COMPANY_ID INT(11) UNSIGNED DEFAULT NULL,
 CUSTOMER_ID INT(11) UNSIGNED DEFAULT NULL,
 PRIMARY KEY(PROJECT_ID),
 FOREIGN KEY (COMPANY_ID) REFERENCES 
			companies(COMPANY_ID) ON DELETE CASCADE,
 FOREIGN KEY (CUSTOMER_ID) REFERENCES 
			customers(CUSTOMER_ID) ON DELETE SET NULL
 );
 
 CREATE TABLE IF NOT EXISTS developer_skill(
DEVELOPER_ID INT(11) UNSIGNED NOT NULL,
SKILL_ID INT(11) UNSIGNED NOT NULL,
 FOREIGN KEY (DEVELOPER_ID) REFERENCES developers(DEVELOPER_ID) ON DELETE CASCADE
  ON UPDATE CASCADE,
 FOREIGN KEY (SKILL_ID) REFERENCES skills(SKILL_ID) ON DELETE CASCADE
  ON UPDATE CASCADE,
 PRIMARY KEY(DEVELOPER_ID, SKILL_ID)
);

CREATE TABLE IF NOT EXISTS developer_project(
DEVELOPER_ID INT(11) UNSIGNED NOT NULL,
PROJECT_ID INT(11) UNSIGNED NOT NULL,
SALARY INT(6) DEFAULT NULL,
FOREIGN KEY (DEVELOPER_ID) REFERENCES developers(DEVELOPER_ID) ON DELETE CASCADE
  ON UPDATE CASCADE,
FOREIGN KEY (PROJECT_ID) REFERENCES projects(PROJECT_ID) ON DELETE CASCADE
  ON UPDATE CASCADE,
PRIMARY KEY(DEVELOPER_ID, PROJECT_ID)
);
