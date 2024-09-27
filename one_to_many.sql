create database if not exists os10_db;
	use os10_db;
	drop table if exists voucher;
	drop table if exists customer;
	

	create table customer (
		id int  unsigned primary key auto_increment,
		name varchar(20),
		gender enum('Male','Female','Other'),
		phone varchar(12)
		);

	create table voucher (

		id int unsigned primary key auto_increment,
		issue_at datetime not null default now(),
		tax int not null,
		sub_total decimal(9,2) not null,
		customer_id int unsigned ,
		constraint customer_voucher_fk foreign key(customer_id) references customer(id) on update set null on delete restrict
	);

	insert into customer(name,gender,phone) values
		('Li Li','Female','09-884804843'),
		('Aye Aye','Female','09-44556677'),
		('Aung Aung','Male','09-33442244');

	insert into voucher(tax,sub_total,customer_id) values
	(200,30000,1),
	(20,4000,2),
	(100,20000,1);

	select * from customer;
	select * from voucher;	