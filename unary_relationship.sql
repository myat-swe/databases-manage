 

create database if not exists os10_db;
use os10_db;


drop table if exists category;

create table category (

	id int primary key auto_increment,
	name varchar(20) not null unique,
	type enum('Main','Sub') not null,
	created_at datetime(6) not null default (now(6)),
	description text,
	category_id int,
	
	constraint self_category_fk foreign key (category_id) references category(id)
	on delete cascade on update cascade
	);


insert into category(name,type,description,category_id) values ('Fashion','Main',null,null);
insert into category(name,type,description,category_id) values ('Menware','Sub','Fashoin for Men',1);
insert into category(name,type,description,category_id) values ('Fancy','Sub','Fashoin for Fancy',1);

insert into category(name,type,description,category_id) values ('Food','Main',null,null);
insert into category(name,type,description,category_id) values ('Donut','Sub','Food for everybody',4);

