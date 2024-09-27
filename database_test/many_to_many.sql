use os10_db;
drop table if exists registration;
drop table if exists course;
drop table if exists student;
create table student (
	id int primary key auto_increment,
	name varchar(50) not null,
	gender enum ('Male','Female'),
	dob date not null,
	phone varchar(15) not null);

create table course (
	id int primary key auto_increment,
	name varchar(50) not null,
	fees decimal(9,2) not null,
	start_date date not null default(date(6)),
	duration tinyint not null default 3,
	level enum('Basic','Intermediate','Advance') not null default 'Basic'
);

create table registration (
	reg_seq int default 0,
	reg_date datetime not null default (now(6)),
	reg_fees decimal(9,2) not null,
	student_id int not null,
	course_id int not null,
	foreign key(student_id) references student(id),
	foreign key(course_id) references course(id)

);

insert into student (name, gender, dob, phone) values
	('Myat Thu Kyaw', 'Male','2012-01-02','092343244');
insert into student (name, gender, dob, phone) values
	('Myat Lay', 'Female','2000-04-02','092343244');
insert into student (name, gender, dob, phone) values
	('Myat Thu', 'Male','2010-01-09','092343244');

insert into course (name,fees,start_date,duration,level) values
	('Java Basic',300000,'2024-09-20',3,'Basic');
insert into course (name,fees,start_date,duration,level) values
	('Java EE',400000,'2024-10-05',3,'Intermediate');
insert into course (name,fees,start_date,duration,level) values
	('Java Spring',500000,'2024-12-05',3,'Advance');

insert into registration(reg_date,reg_fees,student_id,course_id) values 
	(now(6), 50000, 1, 2);
insert into registration(reg_date,reg_fees,student_id,course_id) values
	(now(6), 50000, 3, 3);
insert into registration(reg_date,reg_fees,student_id,course_id) values
	(now(6), 50000, 2, 3);