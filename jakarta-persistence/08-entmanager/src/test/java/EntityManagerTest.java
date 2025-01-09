import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.em.entity.Course;
import com.jdc.em.entity.Course.Level;

@TestMethodOrder(OrderAnnotation.class)
public class EntityManagerTest extends BaseTest{

	@Test
	@Order(1)
	void test() {
		List<String> outlines = new ArrayList<>();
		Collections.addAll(outlines, "Angular Introduction",
				"About Component",
				"DataInding",
				"Angular Forms",
				"Router",
			    "Dependecy Injection",
			    "Angular Signal");
		//transient or new state
		var course = new Course();
		course.setName("Angular Framework");
		course.setFees(new BigDecimal(450_000d));
		course.setStartDate(LocalDate.of(2024, 10, 04));
		course.setLevel(Level.INTERMEDIATE);
		course.setDuration(4);
		//course.setOutline(outlines);
		em.getTransaction().begin();
	
		assertFalse(em.contains(course));
		em.persist(course);
		assertTrue(em.contains(course));
		course.setFees(new BigDecimal(500_000d));
		
		em.detach(course);
		assertFalse(em.contains(course));
		
		course.setDuration(3);
		
		var mergedCourse = em.merge(course);
		assertTrue(em.contains(mergedCourse));
		
		em.getTransaction().commit();
		
	}
	
	@Test
	@Order(2)
	void test2() {
		
		var findedCourse = em.find(Course.class, 1);
		assertTrue(em.contains(findedCourse));
		em.getTransaction().begin();
		em.remove(findedCourse);
		em.getTransaction().commit();
	}
	
	
}
