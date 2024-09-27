

use relation_db;

create table category (
	id int primary key auto_increment,
	name varchar(22) not null unique,
);

create table product (
	id int auto_increment,
	category_id int ,
	name varchar(20) not null,
	price int not null,
	primary key(id),
	foreign key(category_id) references category(id)
);

insert into category values('food');
insert into category values('drink');

insert into product values(2,'Tiger Beer', 3500);
insert into product values(1,'Burger', 2500);	