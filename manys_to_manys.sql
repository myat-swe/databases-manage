

create database if not exists relation_db;
use relation_db;

drop table if exists registration2;
drop table if exists coursing;
drop table if exists student2;


create table student2 (
	id int primary key auto_increment,
	name varchar(20) not null,
	dob date not null,
	nrc varchar(20) not null,
	phone varchar(14)
	);

create table coursing (
	id int default 0,
	name varchar(20) not null,
	start_date datetime not null default (now()),
	fee decimal(9,2) not null,
	level1 enum('Basic','Intermediate','Advance') not null default 'Basic',
	duration tinyint not null default 3,
	primary key(id)
	);

create table registration2 (
	reg_fee decimal(9,2) not null,
	reg_seq int default 0,
	reg_date datetime (6) default(now(6)),
	student_id int auto_increment,
	course_id int not null,
	
	constraint student2_registration2_fk foreign key(student_id) references student2(id),
	constraint course2_registration2_fk foreign key(course_id) references coursing(id)
	);


insert into student2 (name,dob,nrc,phone) values ('MyatSwe','1998-11-15','5/224175','09-78982938');
insert into student2 (name,dob,nrc,phone) values ('Thidar','1990-5-10','5/224175','09-22334433');
insert into student2 (name,dob,nrc,phone) values ('ChitSu','1979-1-5','5/224175','09-22666444');
insert into student2 (name,dob,nrc,phone) values ('MyaMya','1979-5-15','5/224175','09-22666456');
insert into student2 (name,dob,nrc,phone) values ('AungAung','1989-10-5','5/224175','09-226669875');

insert into coursing (id,name,fee,level1) values (1,'java se','900000','basic');
insert into coursing (id,name,fee,level1) values (2,'java ee','950000','inter');
insert into coursing (id,name,fee,level1) values (3,'java me','1000000','adv');


insert into registration2 (reg_fee,course_id,reg_date,student_id) values ('50000',3,now(6),1);
insert into registration2 (reg_fee,course_id,reg_date,student_id) values ('50000',2,now(6),2);
insert into registration2 (reg_fee,course_id,reg_date,student_id) values ('50000',2,now(6),3);