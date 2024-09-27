SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `student_db` DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `student_db`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `township` VARCHAR(255) NOT NULL,
  `state` VARCHAR(255) not null,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `student_db`.`contact` (
  `phone` VARCHAR(13) NOT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`phone`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `student_db`.`course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `duration_in_hour` INT NOT NULL,
  `fees` DECIMAL(10,2) NOT NULL,
  `start_date` DATE NOT NULL DEFAULT (curdate()),
  `level` ENUM('Novice', 'Advance', 'Professional') NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `student_db`.`module` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `course_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_module_course1_idx` (`course_id` ASC) VISIBLE,
  CONSTRAINT `fk_module_course1`
    FOREIGN KEY (`course_id`)
    REFERENCES `student_db`.`course` (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `student_db`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `gender` ENUM('Male', 'Female') NOT NULL,
  `address_id` INT NOT NULL,
  `contact_id` VARCHAR(13) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_student_address1_idx` (`address_id` ASC) VISIBLE,
  INDEX `fk_student_contact1_idx` (`contact_id` ASC) VISIBLE,
  CONSTRAINT `fk_student_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `student_db`.`address` (`id`),
  CONSTRAINT `fk_student_contact1`
    FOREIGN KEY (`contact_id`)
    REFERENCES `student_db`.`contact` (`phone`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `student_db`.`registration` (
  `student_id` INT NOT NULL,
  `course_id` INT NOT NULL,
  `reg_fees` DECIMAL(9,2) NOT NULL,
  `reg_date` DATE NOT NULL DEFAULT (curdate()),
  PRIMARY KEY (`student_id`, `course_id`),
  INDEX `fk_student_has_course_student1_idx` (`student_id` ASC) VISIBLE,
  INDEX `fk_registration_course1_idx` (`course_id` ASC) VISIBLE,
  CONSTRAINT `fk_registration_course1`
    FOREIGN KEY (`course_id`)
    REFERENCES `student_db`.`course` (`id`),
  CONSTRAINT `fk_student_has_course_student1`
    FOREIGN KEY (`student_id`)
    REFERENCES `student_db`.`student` (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO `address` (`township`,`state`) VALUES
('Tamwe Township', 'Yangon'),
('Bahan Township', 'Yangon'),
('Ahlone Township', 'Yangon'),
('Chanayethazan Township', 'Mandalay'),
('Aungmyethazan Township', 'Mandalay'),
('Mogok Township', 'Mandalay'),
('Pathein Township', 'Ayeyarwady'),
('Hinthada Township', 'Ayeyarwady'),
('Bogale Township', 'Ayeyarwady'),
('Myitkyina Township', 'Kachin'),
('Bhamo Township', 'Kachin'),
('Myeik Township', 'Tanintharyi'),
('Dawei Township', 'Tanintharyi'),
('Kawthoung Township', 'Tanintharyi'),
('Hpa-An Township', 'Kayin'),
('Myawaddy Township', 'Kayin'),
('Loikaw Township', 'Kayah'),
('Taunggyi Township', 'Shan'),
('Nyaung Shwe Township', 'Shan'),
('Lashio Township', 'Shan'),
('Kalaw Township', 'Shan'),
('Pyin Oo Lwin Township', 'Mandalay'),
('Mawlamyine Township', 'Mon'),
('Thaton Township', 'Mon'),
('Kyaikmaraw Township', 'Mon'),
('Sittwe Township', 'Rakhine'),
('Thandwe Township', 'Rakhine'),
('Mrauk U Township', 'Rakhine'),
('Magway Township', 'Magway'),
('Pakokku Township', 'Magway'),
('Chauk Township', 'Magway'),
('Naypyidaw Township', 'Naypyidaw Union Territory'),
('Pyinmana Township', 'Naypyidaw Union Territory'),
('Zabuthiri Township', 'Naypyidaw Union Territory'),
('Yangon Downtown', 'Yangon'),
('Thingangyun Township', 'Yangon'),
('Hlaing Township', 'Yangon'),
('Insein Township', 'Yangon'),
('Dagon Township', 'Yangon');

INSERT INTO `contact` (`phone`, `email`) VALUES
('09123456789', 'aungaung@yahoo.com'),
('09345678901', 'myothant@gmail.com'),
('09456789012', NULL),
('09567890123', 'zawmin@microsoft.com'),
('09678901234', 'phyuphyu@microsoft.com'),
('09789012345', NULL),
('09890123456', 'waizin@yahoo.com'),
('09901234567', NULL),
('09123456788', 'myatnoe@microsoft.com'),
('09234567889', 'tuntun@gmail.com'),
('09345678900', 'susu@gmail.com'),
('09456789011', 'soesoe@microsoft.com'),
('09567890122', 'nyeinchan@microsoft.com'),
('09678901233', NULL),
('09789012344', NULL),
('09890123455', NULL),
('09901234566', 'kyawkyaw@gmail.com'),
('09123456777', 'yadanarhlaing@microsoft.com'),
('09234567898', 'hlainghtet@microsoft.com'),
('09345678909', 'myamya@microsoft.com'),
('09456789021', 'ayeaye@yahoo.com'),
('09567890132', 'htetyadanar@yahoo.com'),
('09678901243', NULL),
('09789012354', NULL),
('09890123465', 'zinzin@microsoft.com'),
('09901234576', 'htetko@gmail.com'),
('09123456766', 'kyawmin@microsoft.com'),
('09234567897', 'myatmin@yahoo.com'),
('09345678908', 'ayethidar@microsoft.com'),
('09456789020', 'moemoe@gmail.com'),
('09567890131', 'tuntun@yahoo.com'),
('09678901242', 'nandarnandar@microsoft.com'),
('09789012353', NULL),
('09890123464', NULL),
('09901234575', 'myomyo@yahoo.com'),
('09123456755', 'phyophyo@microsoft.com'),
('09234567896', 'myintmyint@yahoo.com'),
('09345678907', 'naingnaing@gmail.com'),
('09456789019', 'sandasanda@microsoft.com'),
('09567890120', 'chitchit@gmail.com'),
('09678901241', 'htettun@microsoft.com'),
('09789012352', 'htuthtut@microsoft.com'),
('09890123463', 'phyowai@gmail.com'),
('09901234574', 'soemoe@yahoo.com'),
('09123456754', 'pyaephyo@yahoo.com'),
('09234567895', 'soemoe@microsoft.com'),
('09345678906', 'myozaw@microsoft.com'),
('09456789018', 'moemoe@microsoft.com'),
('09567890119', 'htetaung@yahoo.com'),
('09678901230', 'hlamoe@yahoo.com'),
('09789012350', 'yaminyamin@yahoo.com'),
('09890123461', 'winmyint@yahoo.com'),
('09901234573', 'nyinyi@gmail.com'),
('09123456750', NULL),
('09234567890', 'htuthtet@microsoft.com'),
('09345678902', 'pyaepyaephyo@yahoo.com'),
('09456789014', 'tuntun@gmail.com'),
('09567890125', 'htetko@microsoft.com'),
('09678901236', NULL),
('09789012347', 'kyawmin@yahoo.com'),
('09890123458', 'moemyint@yahoo.com'),
('09901234579', 'aungkyaw@microsoft.com'),
('09123456753', NULL),
('09234567894', 'moethandar@yahoo.com'),
('09345678905', 'htetwin@yahoo.com'),
('09456789016', 'phyothant@microsoft.com'),
('09567890127', 'minaung@gmail.com'),
('09678901239', 'kyawmin@yahoo.com'),
('09789012348', 'ayemyint@yahoo.com'),
('09890123460', 'moesanda@microsoft.com'),
('09901234578', 'htutnay@microsoft.com'),
('09123456751', NULL),
('09234567891', 'phyomyint@yahoo.com'),
('09345678903', 'ayephyu@yahoo.com'),
('09456789015', NULL),
('09567890126', 'kyawphyo@microsoft.com'),
('09678901237', NULL),
('09789012349', NULL),
('09890123457', 'moemyint@gmail.com');

INSERT INTO `student` (`name`, `gender`, `contact_id`, `address_id`) VALUES
('Aung Aung', 'Male', '09123456789', 1),
('Moe Myint', 'Female', '09890123457', 2),
('Myo Thant', 'Male', '09345678901', 3),
('Nay Chi', 'Female', '09456789012', 4),
('Zaw Min', 'Male', '09567890123', 5),
('Phyu Phyu', 'Female', '09678901234', 6),
('Kyaw Zaw', 'Male', '09789012345', 7),
('Wai Zin', 'Female', '09890123456', 8),
('Hla Hla', 'Female', '09901234567', 9),
('Myat Noe', 'Female', '09123456788', 10),
('Tun Tun', 'Male', '09234567889', 11),
('Su Su', 'Female', '09345678900', 12),
('Soe Soe', 'Male', '09456789011', 13),
('Nyein Chan', 'Male', '09567890122', 14),
('Thin Thin', 'Female', '09678901233', 15),
('Htet Htet', 'Male', '09789012344', 16),
('Ko Ko', 'Male', '09890123455', 17),
('Kyaw Kyaw', 'Male', '09901234566', 18),
('Yadanar Hlaing', 'Female', '09123456777', 19),
('Hlaing Htet', 'Male', '09234567898', 20),
('Mya Mya', 'Female', '09345678909', 21),
('Aye Aye', 'Female', '09456789021', 22),
('Htet Yadanar', 'Female', '09567890132', 23),
('Min Min', 'Male', '09678901243', 24),
('Win Win', 'Female', '09789012354', 25),
('Zin Zin', 'Female', '09890123465', 26),
('Htet Ko', 'Male', '09901234576', 27),
('Kyaw Min', 'Male', '09123456766', 28),
('Myat Min', 'Male', '09234567897', 29),
('Aye Thidar', 'Female', '09345678908', 30),
('Moe Moe', 'Female', '09456789020', 31),
('Tun Tun', 'Male', '09567890131', 32),
('Nandar Nandar', 'Female', '09678901242', 33),
('Su Su', 'Female', '09789012353', 34),
('Zaw Zaw', 'Male', '09890123464', 35),
('Myo Myo', 'Male', '09901234575', 36),
('Phyo Phyo', 'Female', '09123456755', 37),
('Myint Myint', 'Female', '09234567896', 38),
('Naing Naing', 'Male', '09345678907', 39),
('Sanda Sanda', 'Female', '09456789019', 39),
('Chit Chit', 'Female', '09567890120', 38),
('Htet Tun', 'Male', '09678901241', 37),
('Htut Htut', 'Male', '09789012352', 36),
('Phyo Wai', 'Male', '09890123463', 35),
('Soe Moe', 'Male', '09901234574', 34),
('Pyae Phyo', 'Male', '09123456754', 33),
('Soe Moe', 'Male', '09234567895', 32),
('Myo Zaw', 'Male', '09345678906', 31),
('Moe Moe', 'Female', '09456789018', 30),
('Htet Aung', 'Male', '09567890119', 29),
('Hla Moe', 'Male', '09678901230', 28),
('Yamin Yamin', 'Female', '09789012350', 27),
('Win Myint', 'Male', '09890123461', 26),
('Nyi Nyi', 'Male', '09901234573', 25),
('Ei Ei', 'Female', '09123456750', 24),
('Htut Htet', 'Male', '09234567890', 23),
('Phyo Phyo', 'Female', '09345678902', 22),
('Tun Tun', 'Male', '09456789014', 21),
('Htet Ko', 'Male', '09567890125', 20),
('Nay Chi', 'Female', '09678901236', 19),
('Kyaw Min', 'Male', '09789012347', 18),
('Moe Myint', 'Female', '09890123458', 17),
('Aung Kyaw', 'Male', '09901234579', 16),
('Hla Hla', 'Female', '09123456753', 15),
('Moe Thandar', 'Female', '09234567894', 14),
('Htet Win', 'Male', '09345678905', 13),
('Phyo Thant', 'Male', '09456789016', 12),
('Min Aung', 'Male', '09567890127', 11),
('Kyaw Min', 'Male', '09678901239', 10),
('Aye Myint', 'Female', '09789012348', 9),
('Moe Sanda', 'Female', '09890123460', 8),
('Htut Nay', 'Male', '09901234578', 7),
('Min Min', 'Male', '09123456751', 6),
('Phyo Myint', 'Male', '09234567891', 5),
('Aye Phyu', 'Female', '09345678903', 4),
('Min Thandar', 'Female', '09456789015', 3),
('Kyaw Phyo', 'Male', '09567890126', 2),
('Aung Myint', 'Male', '09678901237', 1),
('Win Moe', 'Female', '09789012349', 20);

INSERT INTO `course` (`name`, `fees`, `start_date`, `duration_in_hour`, `level`, `description`) VALUES
('Java Programming', 500000.00, '2020-01-15', 100, 'Novice', 'Learn the basics of Java programming.'),
('Spring Framework', 600000.00, '2020-02-20', 120, 'Advance', 'Deep dive into Spring Framework for enterprise applications.'),
('JavaScript Basics', 400000.00, '2020-03-10', 90, 'Novice', 'Introduction to JavaScript for web development.'),
('Angular Development', 700000.00, '2020-04-25', 110, 'Professional', 'Build dynamic web applications with Angular.'),
('ReactJS Essentials', 650000.00, '2020-05-30', 115, 'Advance', 'Learn to create interactive UIs with ReactJS.'),
('Python for Data Science', 800000.00, '2020-06-15', 140, 'Professional', 'Data analysis and machine learning with Python.'),
('Advanced Java Programming', 550000.00, '2020-07-20', 130, 'Advance', NULL),
('Spring Boot Microservices', 750000.00, '2020-08-10', 125, 'Professional', 'Develop microservices using Spring Boot.'),
('JavaScript for Web Apps', 420000.00, '2020-09-05', 100, 'Novice', 'JavaScript techniques for modern web applications.'),
('Angular Architecture', 690000.00, '2020-10-15', 140, 'Professional', 'Architect large-scale applications with Angular.'),
('React Native Basics', 620000.00, '2020-11-01', 105, 'Novice', 'Build mobile apps with React Native.'),
('Python Web Development', 730000.00, '2020-12-01', 135, 'Advance', NULL),
('Java and Spring Boot', 710000.00, '2021-01-10', 150, 'Professional', 'Integrated course on Java and Spring Boot.'),
('JavaScript Frameworks', 460000.00, '2021-02-20', 110, 'Advance', 'Explore popular JavaScript frameworks and libraries.'),
('Angular for Beginners', 560000.00, '2021-03-15', 95, 'Novice', 'Beginner course for Angular development.'),
('React for Beginners', 570000.00, '2021-04-25', 100, 'Novice', 'Introduction to React development.'),
('Python Programming', 620000.00, '2021-05-30', 120, 'Advance', NULL),
('Java Web Development', 650000.00, '2021-06-20', 140, 'Advance', 'Develop web applications using Java.'),
('Spring Boot Advanced', 700000.00, '2021-07-15', 130, 'Professional', 'Advanced techniques in Spring Boot.'),
('JavaScript for Full Stack', 480000.00, '2021-08-01', 115, 'Advance', 'Full stack development with JavaScript.'),
('Angular Deep Dive', 740000.00, '2021-09-10', 125, 'Professional', 'In-depth course on Angular.'),
('React Native Advanced', 670000.00, '2021-10-25', 120, 'Advance', 'Advanced topics in React Native.'),
('Python Data Analysis', 750000.00, '2021-11-15', 140, 'Professional', NULL),
('Java Basics', 300000.00, '2021-12-01', 90, 'Novice', 'Introduction to Java programming.'),
('Spring Framework Basics', 320000.00, '2022-01-10', 95, 'Novice', 'Basic concepts of Spring Framework.'),
('JavaScript Fundamentals', 340000.00, '2022-02-20', 100, 'Novice', 'Fundamentals of JavaScript programming.'),
('Angular for Web', 360000.00, '2022-03-10', 110, 'Novice', 'Learn Angular for web development.'),
('React for Web', 380000.00, '2022-04-20', 115, 'Novice', 'React development for web applications.'),
('Python for Beginners', 400000.00, '2022-05-30', 120, 'Novice', NULL),
('Java Intermediate', 420000.00, '2022-06-15', 130, 'Advance', 'Intermediate Java programming concepts.'),
('Spring Boot Basics', 440000.00, '2022-07-25', 135, 'Novice', 'Basic course on Spring Boot.'),
('JavaScript for React', 460000.00, '2022-08-30', 110, 'Advance', 'JavaScript for developing React applications.'),
('Angular Advanced', 480000.00, '2022-09-20', 140, 'Advance', 'Advanced Angular concepts and techniques.'),
('React Advanced', 500000.00, '2022-10-10', 125, 'Advance', NULL),
('Python for Web', 520000.00, '2022-11-01', 135, 'Advance', 'Web development with Python.'),
('Java Full Stack', 540000.00, '2022-12-20', 150, 'Professional', 'Full stack Java development.'),
('Spring Boot Full Stack', 560000.00, '2023-01-15', 140, 'Professional', NULL),
('JavaScript Full Stack', 580000.00, '2023-02-20', 145, 'Professional', 'Full stack development using JavaScript.'),
('Angular Full Stack', 600000.00, '2023-03-15', 150, 'Professional', 'Complete course on Angular for full stack development.'),
('React Full Stack', 620000.00, '2023-04-10', 155, 'Professional', 'Full stack development with React.'),
('Python Full Stack', 640000.00, '2023-05-01', 160, 'Professional', NULL),
('Java Advanced', 660000.00, '2023-06-20', 140, 'Professional', 'Advanced Java programming.'),
('Spring Boot for Web', 680000.00, '2023-07-25', 150, 'Professional', 'Web development with Spring Boot.'),
('JavaScript Deep Dive', 700000.00, '2023-08-30', 160, 'Professional', NULL),
('Angular Deep Dive', 720000.00, '2023-09-20', 145, 'Professional', 'Advanced Angular development.'),
('React Deep Dive', 740000.00, '2023-10-10', 150, 'Professional', 'In-depth React development.'),
('Python Advanced', 760000.00, '2023-11-01', 155, 'Professional', NULL);

INSERT INTO `module` (`name`, `course_id`) VALUES
-- Modules for 'Java Programming'
('Java Basics', 1),
('Java OOP Concepts', 1),
('Java Collections', 1),
('Java Streams', 1),
('Java File I/O', 1),
('Java Exceptions', 1),

-- Modules for 'Spring Framework'
('Introduction to Spring', 2),
('Spring Core', 2),
('Spring AOP', 2),
('Spring MVC', 2),
('Spring Data JPA', 2),
('Spring Security', 2),
('Spring Boot Basics', 2),

-- Modules for 'JavaScript Basics'
('JavaScript Syntax', 3),
('JavaScript DOM Manipulation', 3),
('JavaScript Event Handling', 3),
('JavaScript ES6 Features', 3),
('JavaScript AJAX', 3),

-- Modules for 'Angular Development'
('Angular Basics', 4),
('Angular Components', 4),
('Angular Services', 4),
('Angular Directives', 4),
('Angular Routing', 4),
('Angular Forms', 4),
('Angular HTTP Client', 4),
('Angular Testing', 4),

-- Modules for 'ReactJS Essentials'
('React Basics', 5),
('React Components', 5),
('React Hooks', 5),
('React Router', 5),
('React State Management', 5),
('React Context API', 5),
('React Testing', 5),

-- Modules for 'Python for Data Science'
('Introduction to Python', 6),
('Data Analysis with Pandas', 6),
('Data Visualization with Matplotlib', 6),
('Machine Learning with Scikit-Learn', 6),
('Deep Learning with TensorFlow', 6),
('Python for Web Scraping', 6),

-- Modules for 'Advanced Java Programming'
('Java Multithreading', 7),
('Java Concurrency', 7),
('Java Networking', 7),
('Java JDBC', 7),
('Java Design Patterns', 7),

-- Modules for 'Spring Boot Microservices'
('Introduction to Microservices', 8),
('Spring Boot Overview', 8),
('Building RESTful Services', 8),
('Microservices Communication', 8),
('Service Discovery', 8),
('Config Server', 8),
('API Gateway', 8),

-- Modules for 'JavaScript for Web Apps'
('JavaScript Fundamentals', 9),
('JavaScript Frameworks', 9),
('JavaScript for Async Programming', 9),
('JavaScript Build Tools', 9),
('JavaScript Testing', 9),

-- Modules for 'Angular Architecture'
('Angular Architecture Patterns', 10),
('State Management in Angular', 10),
('Angular Performance Optimization', 10),
('Angular Modular Design', 10),
('Angular Custom Libraries', 10),

-- Modules for 'React Native Basics'
('React Native Basics', 11),
('React Native Components', 11),
('React Native Navigation', 11),
('React Native Styling', 11),
('React Native APIs', 11),

-- Modules for 'Python Web Development'
('Python Web Frameworks', 12),
('Building Web Apps with Django', 12),
('Building Web Apps with Flask', 12),
('Python REST APIs', 12),
('Python Web Scraping', 12),

-- Modules for 'Java and Spring Boot'
('Java and Spring Boot Overview', 13),
('Spring Boot Configuration', 13),
('Java Persistence with Spring Boot', 13),
('Spring Boot RESTful Services', 13),
('Spring Boot Security', 13),
('Spring Boot Testing', 13),

-- Modules for 'JavaScript Frameworks'
('JavaScript Frameworks Overview', 14),
('React Framework', 14),
('Vue.js Framework', 14),
('Angular Framework', 14),
('Svelte Framework', 14),

-- Modules for 'Angular for Beginners'
('Angular Introduction', 15),
('Angular Components and Modules', 15),
('Angular Directives and Pipes', 15),
('Angular Forms', 15),
('Angular HTTP Client', 15),

-- Modules for 'React for Beginners'
('Introduction to React', 16),
('React Components and Props', 16),
('React State Management', 16),
('React Lifecycle Methods', 16),
('React Forms', 16),

-- Modules for 'Python for Beginners'
('Introduction to Python', 17),
('Python Variables and Data Types', 17),
('Python Control Flow', 17),
('Python Functions', 17),
('Python Modules and Packages', 17),

-- Modules for 'Java Intermediate'
('Java Generics', 18),
('Java Streams API', 18),
('Java Functional Programming', 18),
('Java I/O', 18),
('Java Concurrency Utilities', 18),

-- Modules for 'Spring Boot Basics'
('Introduction to Spring Boot', 19),
('Spring Boot Configuration', 19),
('Building REST APIs with Spring Boot', 19),
('Spring Boot Data Access', 19),
('Spring Boot Security Basics', 19),

-- Modules for 'JavaScript for React'
('JavaScript Essentials for React', 20),
('JSX and React Elements', 20),
('React Hooks and State Management', 20),
('React Router Basics', 20),
('React Performance Optimization', 20),

-- Modules for 'Angular Advanced'
('Advanced Angular Concepts', 21),
('Angular State Management', 21),
('Angular Dynamic Components', 21),
('Angular Security', 21),
('Angular Internationalization', 21),

-- Modules for 'React Advanced'
('Advanced React Patterns', 22),
('React Performance Tuning', 22),
('React Server-Side Rendering', 22),
('React Native Advanced Topics', 22),
('React with GraphQL', 22),

-- Modules for 'Python for Web'
('Python Web Development Overview', 23),
('Building Web Apps with Flask', 23),
('Building Web Apps with Django', 23),
('Python Web APIs', 23),
('Python with SQL Databases', 23),

-- Modules for 'Java Full Stack'
('Java Full Stack Overview', 24),
('Spring Boot for Backend', 24),
('JavaScript for Frontend', 24),
('Integrating Frontend and Backend', 24),
('Full Stack Testing', 24),

-- Modules for 'Spring Boot Full Stack'
('Spring Boot Full Stack Overview', 25),
('Spring Boot REST APIs', 25),
('Spring Security and OAuth', 25),
('Frontend Development with Angular', 25),
('Full Stack Deployment', 25),

-- Modules for 'JavaScript Deep Dive'
('JavaScript Internals', 26),
('Advanced JavaScript Patterns', 26),
('JavaScript for Large Applications', 26),
('JavaScript and WebAssembly', 26),
('JavaScript and TypeScript', 26),

-- Modules for 'Angular Deep Dive'
('Angular Deep Dive Overview', 27),
('Advanced Angular Forms', 27),
('Angular Change Detection', 27),
('Angular Performance Optimization', 27),
('Angular Custom Components', 27),

-- Modules for 'React Deep Dive'
('React Deep Dive Overview', 28),
('Advanced React Hooks', 28),
('React Concurrent Mode', 28),
('React Suspense', 28),
('React Patterns and Practices', 28),

-- Modules for 'Python Advanced'
('Advanced Python Programming', 29),
('Python Asynchronous Programming', 29),
('Python Advanced Libraries', 29),
('Python for Data Engineering', 29),
('Python Best Practices', 29);

-- Insert registrations for the 'Java Programming' course (course_id = 1)
INSERT INTO `registration` (`student_id`, `course_id`, `reg_fees`, `reg_date`) VALUES
(1, 1, 50000.00, '2024-01-15'),
(2, 1, 50000.00, '2024-01-16'),
(3, 1, 50000.00, '2024-01-17'),
(4, 1, 50000.00, '2024-01-18'),
(5, 1, 50000.00, '2024-01-19'),
(6, 1, 50000.00, '2024-01-20'),
(7, 1, 50000.00, '2024-01-21'),
(8, 1, 50000.00, '2024-01-22'),
(9, 1, 50000.00, '2024-01-23'),
(10, 1, 50000.00, '2024-01-24');

-- Insert registrations for the 'Spring Framework' course (course_id = 2)
INSERT INTO `registration` (`student_id`, `course_id`, `reg_fees`, `reg_date`) VALUES
(11, 2, 60000.00, '2024-02-01'),
(12, 2, 60000.00, '2024-02-02'),
(13, 2, 60000.00, '2024-02-03'),
(14, 2, 60000.00, '2024-02-04'),
(15, 2, 60000.00, '2024-02-05'),
(16, 2, 60000.00, '2024-02-06'),
(17, 2, 60000.00, '2024-02-07'),
(18, 2, 60000.00, '2024-02-08'),
(19, 2, 60000.00, '2024-02-09'),
(20, 2, 60000.00, '2024-02-10');

-- Insert registrations for the 'JavaScript Basics' course (course_id = 3)
INSERT INTO `registration` (`student_id`, `course_id`, `reg_fees`, `reg_date`) VALUES
(21, 3, 40000.00, '2024-03-01'),
(22, 3, 40000.00, '2024-03-02'),
(23, 3, 40000.00, '2024-03-03'),
(24, 3, 40000.00, '2024-03-04'),
(25, 3, 40000.00, '2024-03-05'),
(26, 3, 40000.00, '2024-03-06'),
(27, 3, 40000.00, '2024-03-07'),
(28, 3, 40000.00, '2024-03-08'),
(29, 3, 40000.00, '2024-03-09'),
(30, 3, 40000.00, '2024-03-10');

-- Insert registrations for the 'Angular Development' course (course_id = 4)
INSERT INTO `registration` (`student_id`, `course_id`, `reg_fees`, `reg_date`) VALUES
(31, 4, 70000.00, '2024-04-01'),
(32, 4, 70000.00, '2024-04-02'),
(33, 4, 70000.00, '2024-04-03'),
(34, 4, 70000.00, '2024-04-04'),
(35, 4, 70000.00, '2024-04-05'),
(36, 4, 70000.00, '2024-04-06'),
(37, 4, 70000.00, '2024-04-07'),
(38, 4, 70000.00, '2024-04-08'),
(39, 4, 70000.00, '2024-04-09'),
(40, 4, 70000.00, '2024-04-10');

-- Insert registrations for the 'Python for Data Science' course (course_id = 6)
INSERT INTO `registration` (`student_id`, `course_id`, `reg_fees`, `reg_date`) VALUES
(41, 6, 80000.00, '2024-05-01'),
(42, 6, 80000.00, '2024-05-02'),
(43, 6, 80000.00, '2024-05-03'),
(44, 6, 80000.00, '2024-05-04'),
(45, 6, 80000.00, '2024-05-05'),
(46, 6, 80000.00, '2024-05-06'),
(47, 6, 80000.00, '2024-05-07'),
(48, 6, 80000.00, '2024-05-08'),
(49, 6, 80000.00, '2024-05-09'),
(50, 6, 80000.00, '2024-05-10');

-- Insert registrations for the 'Java and Spring Boot' course (course_id = 13)
INSERT INTO `registration` (`student_id`, `course_id`, `reg_fees`, `reg_date`) VALUES
(51, 13, 71000.00, '2024-06-01'),
(52, 13, 71000.00, '2024-06-02'),
(53, 13, 71000.00, '2024-06-03'),
(54, 13, 71000.00, '2024-06-04'),
(55, 13, 71000.00, '2024-06-05'),
(56, 13, 71000.00, '2024-06-06'),
(57, 13, 71000.00, '2024-06-07'),
(58, 13, 71000.00, '2024-06-08'),
(59, 13, 71000.00, '2024-06-09'),
(60, 13, 71000.00, '2024-06-10');

-- Insert registrations for the 'JavaScript Frameworks' course (course_id = 14)
INSERT INTO `registration` (`student_id`, `course_id`, `reg_fees`, `reg_date`) VALUES
(61, 14, 46000.00, '2024-07-01'),
(62, 14, 46000.00, '2024-07-02'),
(63, 14, 46000.00, '2024-07-03'),
(64, 14, 46000.00, '2024-07-04'),
(65, 14, 46000.00, '2024-07-05'),
(66, 14, 46000.00, '2024-07-06'),
(67, 14, 46000.00, '2024-07-07'),
(68, 14, 46000.00, '2024-07-08'),
(69, 14, 46000.00, '2024-07-09'),
(70, 14, 46000.00, '2024-07-10');

-- Insert registrations for the 'React for Beginners' course (course_id = 16)
INSERT INTO `registration` (`student_id`, `course_id`, `reg_fees`, `reg_date`) VALUES
(71, 16, 57000.00, '2024-08-01'),
(72, 16, 57000.00, '2024-08-02'),
(73, 16, 57000.00, '2024-08-03'),
(74, 16, 57000.00, '2024-08-04'),
(75, 16, 57000.00, '2024-08-05'),
(76, 16, 57000.00, '2024-08-06'),
(77, 16, 57000.00, '2024-08-07'),
(78, 16, 57000.00, '2024-08-08'),
(79, 16, 57000.00, '2024-08-09');

-- Insert registrations for the 'Python for Web' course (course_id = 23)
INSERT INTO `registration` (`student_id`, `course_id`, `reg_fees`, `reg_date`) VALUES
(1, 23, 65000.00, '2024-09-01'),
(11, 23, 65000.00, '2024-09-02'),
(21, 23, 65000.00, '2024-09-03'),
(31, 23, 65000.00, '2024-09-04'),
(41, 23, 65000.00, '2024-09-05'),
(51, 23, 65000.00, '2024-09-06'),
(61, 23, 65000.00, '2024-09-07'),
(71, 23, 65000.00, '2024-09-08'),
(43, 23, 65000.00, '2024-09-09'),
(57, 23, 65000.00, '2024-09-10');