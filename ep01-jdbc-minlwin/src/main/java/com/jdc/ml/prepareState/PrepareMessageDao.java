package com.jdc.ml.prepareState;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdc.statement.dto.Messages;
import com.jdc.statements.ConnectionManager;


public class PrepareMessageDao {
	
	private ConnectionManager manager;
	
	public PrepareMessageDao(ConnectionManager manager) {
		
		super();
		this.manager = manager;
	}
	
	public Messages create(Messages data) {
		
		var sql = "insert into messages (title,message) values (?,?)";
		
		try(var conn = manager.getConnection();
				var stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			
			stmt.setString(1, data.title());
			stmt.setString(2, data.message());
			
			stmt.executeUpdate();
			var result = stmt.getGeneratedKeys();
			
			if(result.next()) {
				var id = result.getInt(1);
				return data.cloneWithId(id);
				
						
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Messages findById(int id) {
		
		var sql = "select * from messages where id = ?";
		
		try(var conn = manager.getConnection();
				var stmt = conn.prepareStatement(sql)){
			
			stmt.setInt(1, id);
			
			var result = stmt.executeQuery();
			
			while(result.next()) {
				return new Messages(
					result.getInt("id"),
					result.getString("title"),
					result.getString("message"),
					result.getTimestamp("post_at").toLocalDateTime()
					);
						
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public int update(int id, String title, String message) {
		
		var sql = "update messages set title = ?,message = ? where id = ?";
		
		try(var conn = manager.getConnection(); 
				var stmt = conn.prepareStatement(sql)){
			
			stmt.setString(1, title);
			stmt.setString(2, message);
			stmt.setInt(3, id);
			
			return stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int deleteById(int id) {
		
		var sql = "delete from messages where id = ?";
		
		try(var conn = manager.getConnection(); 
				var stmt = conn.prepareStatement(sql)){
			
			stmt.setInt(1, id);
			
			return stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public List<Messages> createMessages(List<Messages> messages) {
		
		List<Messages> list = new ArrayList<>();
		
		if (null == messages) {
			return list;
		} 
		
		var sql = "insert into messages (title, message) values (?,?)";
		
		try(var conn = manager.getConnection(); 
				var stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			
			for(var m : messages) {
				stmt.setString(1, m.title());
				stmt.setString(2, m.message());
				stmt.addBatch();
			}
			stmt.executeBatch();
			 
			var keys = stmt.getGeneratedKeys();
			
			var index = 0;
			while(keys.next()) {
				
				list.add(messages.get(index).cloneWithId(keys.getInt(1)));
				index++;
				
				
			}
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
