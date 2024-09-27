create database if not exists os10_db;
use os10_db;


drop table if exists sale_tbl;

create table sale_tbl (
sale_id int default 0,
sale_date datetime default (now()),
unit_price decimal(9,2) not null,
quantity mediumint not null,
primary key(sale_id,sale_date)
);