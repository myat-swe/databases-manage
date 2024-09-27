package com.jdc.statements.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import com.jdc.statement.dto.Message;
import com.jdc.statements.ConnectionManager;


public class MessageDao {

	private ConnectionManager manager;

	public MessageDao(ConnectionManager manager) {
		super();
		this.manager = manager;
	}
	
	public int createMessages(List<Message> messages) {
		
		var sql = "insert into message (title,message) values ('%s','%s')";
		
		try (var conn = ConnectionManager.getInstance().getConnection();
				var stmt = conn.createStatement()){
			
			for(var m : messages) {
				stmt.addBatch(sql.formatted(m.title(),m.message()));
			}
			var result = stmt.executeBatch();
			
			return Arrays.stream(result).sum();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
 
	public Message createMessage(Message data) {
		
		var sql = "insert into message (title,message) values ('%s','%s')"
					.formatted(data.title(),data.message());
		 
		try (var conn = manager.getConnection();
				var stmt = conn.createStatement()){
			
			stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
			var rs = stmt.getGeneratedKeys();
			
			if(rs.next()) {
				var id = rs.getInt(1);
				return data.cloneWithId(id);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public Message findById(int id) {
		
		final var sql = "select * from message";
		
		try(var conn = manager.getConnection();
				var stmt = conn.createStatement()
						){
			
			var rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				return new Message (
						rs.getInt("id"),
						rs.getString("title"),
						rs.getString("message"),
						rs.getTimestamp("post_at").toLocalDateTime());
						
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int update(int id, String title, String message) {
		
		var sql = "update message set title = '%s', message = '%s' where id = %d"
				.formatted(title,message,id);
		
		try(var conn = ConnectionManager.getInstance().getConnection();
				var stmt = conn.createStatement()){
			
			return stmt.executeUpdate(sql);
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int delete(int id) {
		
		var sql = "delete from message where id = %d"
					.formatted(id);
		
		try(var conn = ConnectionManager.getInstance().getConnection();
				var stmt = conn.createStatement()){
			
			return stmt.executeUpdate(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
