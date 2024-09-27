import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.jdc.ms.inher.DailyWorker;
import com.jdc.ms.inher.OfficeStaff;
import com.jdc.ms.inher.Programmer;

import jakarta.persistence.Persistence;

public class InheritanceMappingTest {

	@Test
	void test() {
		try(var emf = Persistence.createEntityManagerFactory("inhm"); 
				var em = emf.createEntityManager()){
			
			var tx = em.getTransaction();
			tx.begin();
			
			var pro = new Programmer();
			pro.setName("Sayar Min Lwin");
			pro.setAssignDate(LocalDate.of(2000, 2, 25));
			pro.setFeesPerProject(new BigDecimal(50_000_000));
			
			var daily = new DailyWorker();
			daily.setName("KO Mg Myint");
			daily.setAssignDate(LocalDate.of(2003, 10, 3));
			daily.setDailyFee(new BigDecimal(50_000));
			
			var office = new OfficeStaff();
			office.setName("Pyae Phyo");
			office.setAssignDate(LocalDate.of(2020, 9, 8));
			office.setSalary(new BigDecimal(500_000));
			
			em.persist(pro);
			em.persist(daily);
			em.persist(office);
			
			
			tx.commit();
			
		}
	}
}
