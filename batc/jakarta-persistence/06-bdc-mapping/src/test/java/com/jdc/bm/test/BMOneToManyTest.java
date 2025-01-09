package com.jdc.bm.test;

import java.io.Serializable;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.jdc.bm.entity.Player;
import com.jdc.bm.entity.Team;

public final class BMOneToManyTest extends BaseTest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Test
	void test_for_insert_one_to_many_bi() {

		var tx = em.getTransaction();
		tx.begin();

		var manu = new Team();
		manu.setName("Manchester United");
		manu.setFoundedAt(LocalDate.of(2002, 02, 22));

		var onana = new Player();
		onana.setName("Andre Onana");
		onana.setAge(28);
		onana.setJersyNo(1);
		onana.setPosition("GK");
		manu.addPlayer(onana);
		
		var onana1 = new Player();
		onana1.setName("Andre Onana");
		onana1.setAge(28);
		onana1.setJersyNo(1);
		onana1.setPosition("GK");
		manu.addPlayer(onana1);

		var maguire = new Player();
		maguire.setName("Harry Maguire");
		maguire.setAge(30);
		maguire.setJersyNo(5);
		maguire.setPosition("AMF");
		manu.addPlayer(maguire);

		var bruno = new Player();
		bruno.setName("Bruno");
		bruno.setAge(30);
		bruno.setJersyNo(7);
		bruno.setPosition("AMF");
		manu.addPlayer(bruno);

		em.persist(manu);

		tx.commit();
	}
}
