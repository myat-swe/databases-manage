use os10_db;


drop table if exists registration1;
drop table if exists student1;
drop table if exists course1;


create table student1 (
	id int primary key auto_increment,
	name varchar(20) not null,
	dob date not null,
	phone varchar(15),
	gender enum('Male','Female')
	);

create table course1 (
	course_seq int default 0,
	course_date datetime default(now()),
	name varchar(20) not null,
	fee decimal(9,2) not null,
	start_date date not null default (curdate()),
	duration tinyint not null default 3,
	level enum('Basic','Intermediate','Advance') not null default 'Basic',
	primary key(course_seq,course_date)
	);

create table registration1 (
	reg_seq int default 0,
	reg_date datetime not null default (now()),
	reg_fee decimal(9,2) not null,
	student_id int auto_increment,
	course_seq int not null,
	course_date datetime not null,
	primary key (reg_seq,reg_date),
	constraint student1_registration1_fk foreign key(student_id) references student(id),
	constraint course1_registration1_fk foreign key(course_seq,course_date) references course1(course_seq,course_date) 
	);

insert into student1 (name,dob,gender,phone) values ('SuSu','2020-2-8','Female','09-78789901');
insert into student1 (name,dob,gender,phone) values ('ThuThu','2020-2-9','Female','09-787892300');
insert into student1 (name,dob,gender,phone) values ('AungAung','2020-2-15','Female','09-78749900');

insert into course1 (name,fee,start_date,duration,level) values ('java SE','900000','2024-9-05',16,'Basic');
insert into course1 (name,fee,start_date,duration,level) values ('java EE','1900000','2023-08-06',06,'Intermediate');
insert into course1 (name,fee,start_date,duration,level) values ('java ME','2900000','2022-07-09',11,'Advance');



insert into registration1 (reg_fee,student_id,course_seq,course_date) values ('50000',3,0,'2024-8-22 insert into course1 (name,fee,start_date,duration,level) values ('java ME','2900000','2024-8-5',6,'Advance');23-57-19');