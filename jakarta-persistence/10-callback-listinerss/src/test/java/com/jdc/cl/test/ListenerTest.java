package com.jdc.cl.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.cl.entity.Account;
import com.jdc.cl.entity.Contact;

@TestMethodOrder(OrderAnnotation.class)
public class ListenerTest extends BaseTest {

	@ParameterizedTest
	@DisplayName("Test for inserting account")
	@CsvFileSource(resources  = "/data/account.txt")
	@Order(1)
	void testOne(String name, int amount) {

		Account acc = new Account();
		acc.setName(name);
		acc.setAmount(amount);

		em.getTransaction().begin();

		em.persist(acc);

		em.getTransaction().commit();
	}

	@ParameterizedTest
	@CsvSource({"1, 500000"})
	@DisplayName("Test for update account")
	@Order(2)
	void test2(int id, int amount) {
		var account = em.getReference(Account.class, 1);
		account.setAmount(amount);

		em.getTransaction().begin();
		em.merge(account);
		em.getTransaction().commit();

	}
	
	@DisplayName("Test for delele account")
	@ParameterizedTest
	@Order(3)
	@ValueSource(ints = 1)
	void test3(int idForDelete) {
		
		var account = em.find(Account.class, idForDelete);
		account.setId(idForDelete);
		
		em.getTransaction().begin();
		
		em.remove(account);
		
		em.getTransaction().commit();
	}
	
	@DisplayName("test for contact")
	@Order(4)
	@ParameterizedTest
	@CsvSource({
		"someone@gmail.com, +9592352345",
		"divaa@gmail.com, +95923523234",
		})
	void test4(String email, String phone) {
		var contact = new Contact();
		contact.setEmail(email);
		contact.setPhone(phone);
		
		em.getTransaction().begin();
		em.persist(contact);
		em.getTransaction().commit();
	}

}


















