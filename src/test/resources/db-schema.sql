DROP TABLE IF EXISTS people;
CREATE TABLE `people` (
  `employee_id` int(11) NOT NULL,
  `full_name` varchar(30) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `position_id` int(11) DEFAULT NULL,
  `position_title` varchar(30) DEFAULT NULL,
  `store_id` int(11) NOT NULL,
  `department_id` int(11) NOT NULL,
  `birth_date` date NOT NULL,
  `hire_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `salary` decimal(10,4) NOT NULL,
  `supervisor_id` int(11) DEFAULT NULL,
  `education_level` varchar(30) NOT NULL,
  `marital_status` varchar(30) NOT NULL,
  `gender` varchar(30) NOT NULL,
  `management_role` varchar(30) DEFAULT NULL,
  UNIQUE KEY `i_employee_id` (`employee_id`)
);

DROP TABLE IF EXISTS dept;
CREATE TABLE `dept` (
  `department_id` int(11) NOT NULL,
  `department_description` varchar(30) NOT NULL,
  UNIQUE KEY `i_department_id` (`department_id`)
);

DROP TABLE IF EXISTS roletype;
CREATE TABLE `roletype` (
  `position_id` int(11) NOT NULL,
  `position_title` varchar(30) NOT NULL,
  `pay_type` varchar(30) NOT NULL,
  `min_scale` decimal(10,4) NOT NULL,
  `max_scale` decimal(10,4) NOT NULL,
  `management_role` varchar(30) NOT NULL,
  UNIQUE KEY `i_position_id` (`position_id`)
);