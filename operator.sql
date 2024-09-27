
create table oprator1(
col1 tinyint ,
col2 tinyint,
col3 tinyint);

insert into oprator1 values (0,1,NULL),(1,1,0),(NULL,0,1),(0,NULL,1);


drop table if exists set_one,set_two;
create table set_one(
	col1 varchar(20),
	col2 varchar(20),
	col3 varchar(20)
	);

create table set_two(
	col1 varchar(20),
	col2 varchar(20),
	col3 varchar(20)
	
	);

insert into set_one values('1','A','1'),('2','B','2');
insert into set_two values ('2','B','2'),('1','A','1');
insert into set_two values('2','B','2'),('3','C','3');
insert into set_two values('2','B'),('1','A');

drop table if exists audience,room;
create table audience(
	id int unsigned primary key auto_increment,
	name varchar(30) not null

	);

create table room(
	room_number int unsigned primary key auto_increment,
	seat int not null
);

insert into audience (name) values ('Isablela Merced'),('Shawn Paul'),('Geogre');
insert into room (seat) values (40),(90);


create table ship(

	location varchar(20),
	shippint int

);

create table airline(
	location varchar(20),
	aircargo int
	);

insert into ship values('BBK',23),('ToYoTa',234);
insert into airline values('BBK',23),('ToYoTa',234);

drop table if exists ship,airline;
create table ship(

	ship_location varchar(20),
	fee int

);

create table airline(
	airline_location varchar(20),
	fee decimal(8,2)
	);

insert into ship values('BBK',23),('ToYoTa',234);
insert into airline values('BBK',234),('ToYoTa',234);	


select * from 



