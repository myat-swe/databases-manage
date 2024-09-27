package com.jdc.statement.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.statement.dto.Message;
import com.jdc.statements.ConnectionManager;
import com.jdc.statements.dao.MessageDao;

@TestMethodOrder(OrderAnnotation.class)
@SuppressWarnings("unused")
public class MessageDaoTest {
	static MessageDao dao;
	static Message ms = new Message("Myat", "Swe"); 
	Message message = new Message("Jhone", "Wich");

	@BeforeAll
	static void setUpBeforeClass() throws SQLException{
	
		DbInitializer.truncate("message");
		DbInitializer.create();
		
		
	}
	@BeforeEach
	void setUpBeforeEach() {
		dao = new MessageDao(ConnectionManager.getInstance());
	}
	@Test
	@Order(1)
	void testForCreateMessage() {
		
		var result = dao.createMessage(ms);
		var result1 = dao.createMessage(message);
		assertEquals(2, result1.id());
	
	
	}
	
	@Test
	@Order(3)
	void testFingByIdFound() {
		var result = dao.findById(1);
		assertNotNull(result);
		assertEquals(ms.title(), result.title());
		assertEquals(ms.message(), result.message());
		assertNotNull(result.postAt());
		
	}
	
	@Test
	@Order(2)
	void testFindByIdNotFound() {
		var result1 = dao.findById(9);
		//assertNull(result1);
		
	}
	
	@Test
	@Order(4)
	void testUpdateFound() {
		var title = " new title";
		var message = " new message";
		
		var count = dao.update(1, title, message);
		assertEquals(1, count);
		
		var result = dao.findById(1);
		assertEquals(title, result.title());
		assertEquals(message, result.message());
		assertNotNull(result.postAt());
	
	}
	
	@Test
	@Order(5)
	void testUpdateNotFound() {
		var title = " new title";
		var message = " new message";
		
		var count = dao.update(4, title, message);
		assertEquals(0, count);
		
		
	}
	
	@Test
	@Order(6)
	void testDeleteFound() {
		 
		
		var count = dao.delete(2);
		assertEquals(1, count);
		
		
	}
	
	@Test
	@Order(7)
	void testCreateMessages() {
		
		var mess = List.of(
				new Message("message1","messageOne"),
				new Message("message2","messageTwo"),
				new Message("message3","messageThree")
				);
		
		var count  = dao.createMessages(mess);
		
		assertEquals(3, count);
		
	}
}
