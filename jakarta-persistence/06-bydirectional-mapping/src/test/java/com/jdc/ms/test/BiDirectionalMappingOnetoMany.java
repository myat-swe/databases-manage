package com.jdc.ms.test;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.jdc.ms.bm.entity.Player;
import com.jdc.ms.bm.entity.Team;

public final class BiDirectionalMappingOnetoMany extends BaseTest{

	@Test
	void test_for_insert_one_to_many() {
		
		var tx = em.getTransaction();
		
		tx.begin();
		
		var manu = new Team();
		manu.setName("Manchester United");
		manu.setFoundedAt(LocalDate.of(1950,02,22));
		manu.setTrophy(22);
		
		var onana = new Player();
		onana.setName("Andre Onana");
		onana.setAge(30);
		onana.setJersyNo(23);
		onana.setPosition("GK");
		manu.addPlayer(onana);
		
		var maguire = new Player();
		maguire.setName("Harry Maguire");
		maguire.setAge(29);
		maguire.setJersyNo(8);
		maguire.setPosition("AMF");
		manu.addPlayer(maguire);
		
		em.persist(manu);
		
		
		
		tx.commit();
		
	}
}
