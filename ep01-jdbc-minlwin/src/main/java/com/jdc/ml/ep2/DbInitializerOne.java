package com.jdc.ml.ep2;

import java.sql.SQLException;

public class DbInitializerOne {
	
	private static ConnectionManagerOne one;
	
	static final String member = """
			create table member (
			email varchar(100) primary key,
			name varchar(100) not null,
			password varchar(100) not null,
			dob date not null,
			role enum ('Admin', 'Member'));
			""";
	
	static final String message = """
			id int auto_increment primary key,
			email varchar(100) not null,
			title varchar(100) not null,
			message varchar(100) not null,
			post_at timestamp default current_timestamp,
			foreign key(email) references member(email));
			""";
	
	public static void create() {
		try(var conn = one.getConnection();  
				var stmt = conn.createStatement()){
			
			stmt.execute(member);
			stmt.execute(message);
			
		}catch(SQLException e) {
			
		}
	}
	
	public static  void drop (String...tables) {
		try(var conn = one.getConnection();
				var stmt = conn.createStatement()){
			stmt.execute("set foreign_key_checks = 0");
			
			for(var table : tables) {
				
				stmt.execute("drop table if exists %s".formatted(table));
				
			}
			
			stmt.execute("set foreign_key_checks = 1");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
