
use relation_db;

drop table if exists assigment;
drop table if exists computer;
drop table if exists employees;
drop table if exists project;


create table employees (
	id int primary key auto_increment,
	name varchar(20)
	);

create table project (
	id int primary key auto_increment,
	name varchar(20)
	);

create table computer (
	id int primary key auto_increment,
	name varchar(20)
	);

create table assigment (
	project_id int,
	computer_id int,
	employees_id int,
	primary key (project_id , computer_id, employees_id),
	constraint project_assigment_fk foreign key(project_id) references project(id),
	constraint employees_assigment_fk foreign key(employees_id) references employees(id),
	constraint computer_assigment_fk foreign key(computer_id) references computer(id)

	);


insert into employees (name) values ('Myat Swe');
insert into employees (name) values ('Kyaw Soe Naing');
insert into employees (name) values ('Hla Min Ko');

insert into computer (name) values ('Lenovo');	
insert into computer (name) values ('Acer');	
insert into computer (name) values ('Macbook M2');	


insert into project (name) values ('Booty');	
insert into project (name) values ('Fitnet');	
insert into project (name) values ('Drinking Beer');

insert into assigment (project_id,computer_id,employees_id) values (1,1,1);	
insert into assigment (project_id,computer_id,employees_id) values (1,2,1);	
insert into assigment (project_id,computer_id,employees_id) values (1,3,1);	
insert into assigment (project_id,computer_id,employees_id) values (1,1, );	


