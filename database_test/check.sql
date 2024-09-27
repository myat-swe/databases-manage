use relation_db;

create table check_tbl (
	name varchar(20) not null check (char_length(name >= 5))
	
	);