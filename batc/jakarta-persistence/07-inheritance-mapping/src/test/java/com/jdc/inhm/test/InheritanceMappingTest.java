package com.jdc.inhm.test;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.jdc.inhm.DailyWorker;
import com.jdc.inhm.OfficeStaff;
import com.jdc.inhm.Programmer;

import jakarta.persistence.Persistence;

public class InheritanceMappingTest {
	@Test
	void test() {
		try (var emf = Persistence.createEntityManagerFactory("inhm"); 
				var em = emf.createEntityManager()) {

			em.getTransaction().begin();

			var prog = new Programmer();
			prog.setName("Mg Thaw");
			prog.setAssignDate(LocalDate.of(2000, 3, 4));
			prog.setFeesPerProject(new BigDecimal(50_000_000));

			var dw = new DailyWorker();
			dw.setName("Mg Myint");
			dw.setAssignDate(LocalDate.of(2002, 9, 2));
			dw.setDailyFee(new BigDecimal(40_000));

			var ofs = new OfficeStaff();
			ofs.setName("Isacc Home");
			ofs.setAssignDate(LocalDate.of(2005, 9, 12));
			ofs.setSalary(new BigDecimal(4_000_000));

			em.persist(prog);
			em.persist(dw);
			em.persist(ofs);

			em.getTransaction().commit();
		}
	}
}
