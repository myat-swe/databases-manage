
create database if not exists os10_db;
	use os10_db;
	drop table if exists passport;
	drop table if exists person;
	

	create table person(
		id int primary key auto_increment,
		name varchar(20) not null,
		dob date not null,
		phone varchar(13) not null,
		nrc varchar(20)
		);


	create table passport (
		id int primary key auto_increment,
		issue_date date not null default (now()),
		expired_date date not null default(date_add(issue_date,INTERVAL 5 year)),
		passport_id varchar(20) not null unique,
		person_id int not null unique,
		constraint person_passport_fk foreign key(person_id) references person(id)
		);

	insert into person (name,dob,nrc,phone) values ('MyatSwe','1998-11-15','5/yabana(N)224175','09-884804841');
	insert into person (name,dob,nrc,phone) values ('AungAung','1993-1-25','5/yabana(N)224145','09-884804840');
	insert into person (name,dob,nrc,phone) values ('SuSu','1990-5-5','5/yabana(N)224172','09-884804842');
	insert into passport(passport_id,person_id) values (22334455,1);