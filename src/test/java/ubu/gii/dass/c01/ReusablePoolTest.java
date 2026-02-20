/**
 * 
 */
package ubu.gii.dass.c01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;



/**
 * Clase de pruebas de código.
 * @author Lucía Martín Asenjo
 *
 */
public class ReusablePoolTest {

	
	@BeforeAll
	public static void setUp(){
		
	}

	
	@AfterAll
	public static void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 * @author Lucía Martín Asenjo
	 */
     @Test
        @DisplayName("testGetInstance")
	public void testGetInstance() {
        	try {
                ReusablePool pool1 = ReusablePool.getInstance();
                ReusablePool pool2 = ReusablePool.getInstance();
                assertNotNull(pool1, "La instancia pool1 no debe ser nula.");
                assertNotNull(pool2, "La instancia pool2 no debe ser nula.");
                assertSame(pool1, pool2, "Ambas instancias deben referir al mismo objeto.");
            } catch (Exception e) {
                fail("testGetInstance: " + e.getMessage());
            }
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
        @DisplayName("testAcquireReusable")
        @Disabled("Not implemented yet")

	public void testAcquireReusable() {
		
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
        @DisplayName("testReleaseReusable")
        @Disabled("Not implemented yet")
	public void testReleaseReusable() {
		
	}

}
