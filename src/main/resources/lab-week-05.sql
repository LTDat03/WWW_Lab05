-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.2.0-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP DATABASE works;

-- Dumping database structure for works
CREATE DATABASE IF NOT EXISTS works /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE works;

-- Dumping structure for table works.address

CREATE TABLE IF NOT EXISTS address (
	  address_id bigint(20) NOT NULL AUTO_INCREMENT,
	  street varchar(150) DEFAULT NULL,
	  city varchar(50) DEFAULT NULL,
	  country smallint(6) DEFAULT NULL,
	  number varchar(20) DEFAULT NULL,
	  zipcode varchar(7) DEFAULT NULL,
	  PRIMARY KEY (address_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insert data into address table
INSERT INTO address (street, city, country, number, zipcode) 
VALUES 
('123 Main St', 'Hanoi', 1, '12A', '100000'),
('456 Oak Rd', 'Ho Chi Minh City', 1, '34B', '700000'),
('789 Pine Blvd', 'Da Nang', 1, '56C', '400000'),
('101 Elm St', 'Tokyo', 81, '78D', '1000001'),
('202 Birch Rd', 'New York', 1, '90E', '10001'),
('303 Maple Ave', 'London', 44, '45F', 'E1 6AN'),
('404 Cedar Ln', 'Seoul', 82, '67A', '04500'),
('505 Ash Rd', 'Paris', 33, '88B', '75001'),
('606 Willow Ave', 'Berlin', 49, '99C', '10115');

-- Dumping structure for table works.candidate
CREATE TABLE IF NOT EXISTS candidate (
  can_id bigint(20) NOT NULL AUTO_INCREMENT,
  dob DATE DEFAULT NULL,
  email varchar(255) NOT NULL,
  full_name varchar(255) NOT NULL,
  phone varchar(15) NOT NULL,
  address bigint(20) NOT NULL,
  PRIMARY KEY (can_id),
  UNIQUE KEY UK_qfut8ruekode092nlkipgl09g (email),
  UNIQUE KEY UK_9i5yt1gvm0chg5e10qkns7tll (phone),
  UNIQUE KEY UK_m8qhlm4wu215gr34dhxp0dour (address),
  CONSTRAINT FKa8gnyyhbb2qnhp94grci1n0o9 FOREIGN KEY (address) REFERENCES address (address_id),
  CONSTRAINT FKpxdl8mh82qxa11aftu6ev3rjg FOREIGN KEY (address) REFERENCES users (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insert data into candidate table
INSERT INTO candidate (dob, email, full_name, phone, address) 
VALUES 
('1985-01-15', 'john.doe@example.com', 'John Doe', '0987654321', 1),
('1990-06-25', 'jane.smith@example.com', 'Jane Smith', '0912345678', 2),
('1982-10-30', 'mark.johnson@example.com', 'Mark Johnson', '0923456789', 3),
('1988-05-14', 'emily.doe@example.com', 'Emily Doe', '0934567890', 4),
('1995-08-22', 'michael.jones@example.com', 'Michael Jones', '0945678901', 5),
('1992-02-28', 'alice.wang@example.com', 'Alice Wang', '0956784321', 6),
('1987-11-05', 'charles.brown@example.com', 'Charles Brown', '0971234567', 7),
('1998-07-19', 'diana.lee@example.com', 'Diana Lee', '0936789456', 8);

-- Dumping structure for table works.candidate_skill
CREATE TABLE IF NOT EXISTS candidate_skill (
  more_infos varchar(1000) DEFAULT NULL,
  skill_level tinyint(4) NOT NULL CHECK (skill_level between 0 AND 4),
  skill_id bigint(20) NOT NULL,
  can_id bigint(20) NOT NULL,
  PRIMARY KEY (can_id,skill_id),
  KEY FKb7cxhiqhcah7c20a2cdlvr1f8 (skill_id),
  CONSTRAINT FKb0m5tm3fi0upa3b3kjx3vrlxs FOREIGN KEY (can_id) REFERENCES candidate (can_id),
  CONSTRAINT FKb7cxhiqhcah7c20a2cdlvr1f8 FOREIGN KEY (skill_id) REFERENCES skill (skill_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insert data into candidate_skill table
INSERT INTO candidate_skill (more_infos, skill_level, skill_id, can_id) 
VALUES 
('Experienced in Java development', 4, 1, 1),
('Proficient in SQL and database design', 3, 2, 1),
('Basic knowledge of Python', 2, 3, 2),
('Advanced knowledge of data analysis tools', 4, 4, 3),
('Proficient in project management tools and methodologies', 3, 5, 5),
('Proficient in JavaScript and web development', 3, 6, 6),
('Experienced in cloud technologies and DevOps', 4, 7, 7),
('Basic knowledge of data science and R programming', 2, 8, 8);

-- Dumping structure for table works.company
CREATE TABLE IF NOT EXISTS company (
  comp_id bigint(20) NOT NULL AUTO_INCREMENT,
  about varchar(2000) DEFAULT NULL,
  email varchar(255) NOT NULL,
  comp_name varchar(255) NOT NULL,
  phone varchar(255) NOT NULL,
  web_url varchar(255) DEFAULT NULL,
  address bigint(20) NOT NULL,
  PRIMARY KEY (comp_id),
  UNIQUE KEY UK_rvp2hunsq4sgmpxe3a7i1ym3m (address),
  CONSTRAINT FKd5occp4cjwihejbxdbpvkp5tv FOREIGN KEY (address) REFERENCES address (address_id),
  CONSTRAINT FKka5mvh7njr6anbfailkwbln58 FOREIGN KEY (comp_id) REFERENCES users (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insert data into company table
INSERT INTO company (about, email, comp_name, phone, web_url, address) 
VALUES 
('A global software company specializing in enterprise solutions.', 'contact@softwareco.com', 'SoftwareCo', '0945678901', 'http://www.softwareco.com', 1),
('A leading consultancy firm with a focus on technology and management.', 'info@consultingfirm.com', 'ConsultingFirm', '0932123456', 'http://www.consultingfirm.com', 2),
('A fast-growing tech startup focused on mobile applications.', 'hello@techstart.com', 'TechStart', '0901234567', 'http://www.techstart.com', 3),
('A multinational corporation providing consulting services.', 'contact@corpconsult.com', 'CorpConsult', '0912345678', 'http://www.corpconsult.com', 4),
('An innovative tech company focusing on AI solutions.', 'sales@aitech.com', 'AITECH', '0923456789', 'http://www.aitech.com', 5),
('A creative agency specializing in digital marketing.', 'contact@creativeagency.com', 'Creative Agency', '0923456781', 'http://www.creativeagency.com', 6),
('A company providing cloud-based solutions for enterprises.', 'info@cloudsolutions.com', 'Cloud Solutions', '0909876543', 'http://www.cloudsolutions.com', 7),
('A startup focusing on big data and analytics.', 'hello@datatech.com', 'DataTech', '0943215678', 'http://www.datatech.com', 8);

-- Dumping structure for table works.job
CREATE TABLE IF NOT EXISTS job (
  job_id bigint(20) NOT NULL AUTO_INCREMENT,
  job_desc varchar(2000) NOT NULL,
  job_name varchar(255) NOT NULL,
  comp_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (job_id),
  KEY FKbaqlvluu78phmo9ld89um7wnm (comp_id),
  CONSTRAINT FKbaqlvluu78phmo9ld89um7wnm FOREIGN KEY (comp_id) REFERENCES company (comp_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insert data into job table
INSERT INTO job (job_desc, job_name, comp_id) 
VALUES 
('Responsible for developing and maintaining enterprise software applications.', 'Software Developer', 1),
('Consulting with clients on technology strategies and solutions.', 'Technology Consultant', 2),
('Developing mobile applications and user interfaces for Android and iOS.', 'Mobile App Developer', 3),
('Leading consulting projects and managing client relations.', 'Senior Consultant', 4),
('Developing and deploying AI-driven software solutions.', 'AI Developer', 5),
('Designing and implementing marketing campaigns.', 'Marketing Specialist', 6),
('Building and maintaining cloud infrastructure.', 'Cloud Engineer', 7),
('Analyzing and visualizing data for business insights.', 'Data Analyst', 8);

-- Dumping structure for table works.job_skill
CREATE TABLE IF NOT EXISTS job_skill (
  more_infos varchar(1000) DEFAULT NULL,
  skill_level tinyint(4) NOT NULL CHECK (skill_level between 0 AND 4),
  job_id bigint(20) NOT NULL,
  skill_id bigint(20) NOT NULL,
  PRIMARY KEY (job_id,skill_id),
  KEY FKj33qbbf3vk1lvhqpcosnh54u1 (skill_id),
  CONSTRAINT FK9ix4wg520ii2gu2felxdhdup6 FOREIGN KEY (job_id) REFERENCES job (job_id),
  CONSTRAINT FKj33qbbf3vk1lvhqpcosnh54u1 FOREIGN KEY (skill_id) REFERENCES skill (skill_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insert data into job_skill table
INSERT INTO job_skill (more_infos, skill_level, job_id, skill_id) 
VALUES 
('Required knowledge in Java and software engineering best practices.', 2, 1, 1),
('Strong communication skills for client interaction.', 1, 2, 2),
('Experience with Android SDK and iOS development.', 2, 3, 3),
('Expert in consulting practices and project management.', 2, 4, 5),
('Knowledge in machine learning and AI technologies.', 2, 5, 4),
('Knowledge of SEO and digital marketing tools.', 3, 6, 6),
('Expertise in AWS and Kubernetes.', 4, 7, 7),
('Proficiency in data visualization tools like Tableau.', 3, 8, 8);

-- Dumping structure for table works.skill
CREATE TABLE IF NOT EXISTS skill (
  skill_id bigint(20) NOT NULL AUTO_INCREMENT,
  skill_description varchar(255) DEFAULT NULL,
  skill_name varchar(255) DEFAULT NULL,
  type tinyint(4) DEFAULT NULL CHECK (type between 0 and 2),
  PRIMARY KEY (skill_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insert data into skill table
INSERT INTO skill (skill_description, skill_name, type) 
VALUES 
('Programming language used for enterprise software development.', 'Java', 0),
('Knowledge of relational databases and query optimization.', 'SQL', 1),
('A programming language commonly used for building mobile apps.', 'Python', 0),
('The art of designing the user interface and experience for mobile applications.', 'Mobile UI/UX', 2),
('Knowledge of artificial intelligence and machine learning techniques.', 'AI/ML', 0),
('Programming language for web development.', 'JavaScript', 0),
('Cloud computing and container orchestration.', 'AWS/Kubernetes', 1),
('Data science and visualization tools.', 'Data Science Tools', 2);


-- Dumping structure for table works.experience
CREATE TABLE IF NOT EXISTS experience (
  experience_id BIGINT(20) NOT NULL AUTO_INCREMENT,
  to_date DATE NOT NULL,
  from_date DATE NOT NULL,
  company_name VARCHAR(255) NOT NULL,
  role VARCHAR(255) NOT NULL,
  work_description VARCHAR(255) NOT NULL,
  can_id BIGINT(20) NOT NULL,
  PRIMARY KEY (experience_id),
  KEY FK0iojouhjkghkshgj (can_id),
  CONSTRAINT FK0iojouhjkghkshgj FOREIGN KEY (can_id) REFERENCES candidate (can_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=UTF8MB4_UNICODE_CI;

-- Insert data into experience table
INSERT INTO experience (to_date, from_date, company_name, role, work_description, can_id) 
VALUES 
('2024-06-01', '2021-05-01', 'Creative Agency', 'Marketing Specialist', 'Designed and executed digital campaigns.', 6),
('2023-12-01', '2020-03-01', 'Cloud Solutions', 'Cloud Engineer', 'Built cloud-based solutions for clients.', 7),
('2024-01-01', '2019-09-01', 'DataTech', 'Data Analyst', 'Analyzed large datasets for business insights.', 8),
('2023-01-01', '2020-06-01', 'TechCorp', 'Software Engineer', 'Developed scalable backend systems.', 1),
('2022-12-01', '2019-03-01', 'DesignHub', 'UI/UX Designer', 'Designed interactive user experiences.', 2);

CREATE TABLE IF NOT EXISTS users (
  user_id bigint(20) NOT NULL AUTO_INCREMENT,
  password varchar(255) NOT NULL,
  username varchar(255) NOT NULL,
  PRIMARY KEY (user_id),
  UNIQUE KEY UKr43af9ap4edm43mmtq01oddj6 (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=UTF8MB4_UNICODE_CI;

-- Insert data into users table
INSERT INTO users (username, password) 
VALUES 
('john.doe', '$2a$10$YVj1sbZtGGeDHAFrZqk2ceoy56BGBlc74z36iUJdMkZfEPWlMxTyi'),
('jane.smith', '$2a$10$YVj1sbZtGGeDHAFrZqk2ceoy56BGBlc74z36iUJdMkZfEPWlMxTyi'),
('alice.wang', '$2a$10$YVj1sbZtGGeDHAFrZqk2ceoy56BGBlc74z36iUJdMkZfEPWlMxTyi'),
('charles.brown', '$2a$10$YVj1sbZtGGeDHAFrZqk2ceoy56BGBlc74z36iUJdMkZfEPWlMxTyi'),
('diana.lee', '$2a$10$YVj1sbZtGGeDHAFrZqk2ceoy56BGBlc74z36iUJdMkZfEPWlMxTyi');

CREATE TABLE IF NOT EXISTS roles (
  role_id bigint(20) NOT NULL AUTO_INCREMENT,
  code varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=UTF8MB4_UNICODE_CI;

-- Insert data into roles table
INSERT INTO roles (code, name) 
VALUES 
	('COMPANY', 'Company'),
	('ADMIN', 'Admin'),
	('CANDIDATE', 'Candidate');

CREATE TABLE IF NOT EXISTS users_roles (
  user_id bigint(20) NOT NULL,
  role_id bigint(20) NOT NULL,
  KEY FKj6m8fwv7oqv74fcehir1a9ffy (role_id),
  KEY FK2o0jvgh89lemvvo17cbqvdxaa (user_id),
  CONSTRAINT FK2o0jvgh89lemvvo17cbqvdxaa FOREIGN KEY (user_id) REFERENCES users (user_id),
  CONSTRAINT FKj6m8fwv7oqv74fcehir1a9ffy FOREIGN KEY (role_id) REFERENCES roles (role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=UTF8MB4_UNICODE_CI;

-- Insert data into users_roles table
INSERT INTO users_roles (user_id, role_id) 
VALUES 
(1, 2), -- John Doe as Admin
(2, 3), -- Jane Smith as Candidate
(3, 1), -- Alice Wang as Company
(4, 3), -- Charles Brown as Candidate
(5, 1); -- Diana Lee as Company

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;works