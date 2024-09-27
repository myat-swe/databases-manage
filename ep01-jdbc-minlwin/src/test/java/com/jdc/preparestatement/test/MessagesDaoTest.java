package com.jdc.preparestatement.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.ml.prepareState.PrepareMessageDao;
import com.jdc.statement.dto.Messages;
import com.jdc.statement.test.DbInitializer;
import com.jdc.statements.ConnectionManager;


@TestMethodOrder(OrderAnnotation.class)
public class MessagesDaoTest {

	PrepareMessageDao dao;
	Messages mess = new Messages("Myat Swe","Love Phue Ngone Soe");
	Messages messOne = new Messages("but", "Missing her");
	
	@BeforeAll
	static void setUpBeforeAll() {
		System.out.println("At first running");
		DbInitializer.truncate("messages");
		DbInitializer.create();
	}
	
	@BeforeEach
	void setUpBeforeEachClass() {
		System.out.println("Start each one");
		dao = new PrepareMessageDao(ConnectionManager.getInstance());
	}
	
	@Test
	@Order(1)
	void testForCreateMessages() {
		
		var result = dao.create(mess);
		var result1 = dao.create(messOne);
		
		assertEquals(1, result.id());
		assertEquals(2, result1.id());
	}
	
	@Test
	@Order(2)
	void testFindById() {
		var result = dao.findById(2);
		assertNotNull(result);
		assertEquals(messOne.title(),result.title());
		assertEquals(messOne.message(),result.message());
		assertNotEquals(messOne.postAt(),result.postAt());
	}
	
	@Test
	@Order(3)
	void testUpdateFound() {
		
		var title = "Maung";
		var message = "Ma Ma";
		
		var count = dao.update(1, title, message);
		assertEquals(1, count);
		
		var result = dao.findById(1);
		
		assertEquals(title, result.title());
		assertEquals(message, result.message());
		assertNotNull(result.postAt());
		
	}
	
	@Test
	@Order(4)
	void testForDelete() {
		
		var result = dao.deleteById(2);
		assertEquals(1, result);
		
	}
	
	@Test
	@Order(5)
	void testCreateMessages() {
		
		var messages = List.of(
				new Messages("KyiMayKaung","Friend"),
				new Messages("LayLayMyint", "MyLove"),
				new Messages("KhineZinKyaw", "NotLove")
				
		);
		
		var list = dao.createMessages(messages);
		
		assertEquals(3, list.get(0).id());
		assertEquals(4, list.get(1).id());
		assertEquals(5, list.get(2).id());
	}
	
	
}
