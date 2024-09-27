package com.jdc.statement.test;

import java.sql.SQLException;

import com.jdc.statements.ConnectionManager;

public class DbInitializer {

	public static void create() {
		
		var sql = """
				create table messages (
				id int auto_increment primary key, 
				title varchar(100) not null,
				message varchar(100) not null,
				post_at timestamp not null default (current_timestamp));
				""";
		
		try(var conn = ConnectionManager.getInstance().getConnection();
				var stmt = conn.createStatement()){
			
			stmt.execute(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void truncate(String...tables) {
		try(var conn = ConnectionManager.getInstance().getConnection();
				var stmt = conn.createStatement()
				){
			 
			for(var table : tables) {
				stmt.execute("set foreign_key_checks = 0");
				stmt.execute("drop table if exists %s".formatted(table));
				//stmt.execute("truncate table %s".formatted(table)); 
				stmt.execute("set foreign_key_checks = 1");
			} 
			
		}catch(SQLException e) {
			
		}
	}
}
