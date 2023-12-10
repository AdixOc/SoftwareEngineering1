import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Bezahlautomat_ParkhausTest {

	Bezahlautomat_Parkhaus b1;
	Bezahlautomat_Parkhaus b2;
	
	@BeforeEach
	void setUp() throws Exception {
		b1 = Bezahlautomat_Parkhaus(10,3,20);
		b2 = Bezahlautomat_Parkhaus(10,3,2);
	}

	@AfterEach
	void tearDown() throws Exception {
		b1 = null;
		b2 = null;
	}

	@Test
	void testBerechne() {
		assertEquals(19,b1.berechne(3));
		assertEquals(2,b2.berechne(3)); // Limit von 2 wird hierbei erreicht 
	}

}
