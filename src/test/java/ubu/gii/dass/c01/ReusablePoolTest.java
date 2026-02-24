/**
 * 
 */
package ubu.gii.dass.c01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
	 * @author Sandro Martín
	 * @throws NotFreeInstanceException 
	 */
	@Test
        @DisplayName("testAcquireReusable")

	public void testAcquireReusable() throws NotFreeInstanceException {

		ReusablePool pool = ReusablePool.getInstance();
		
        Reusable reusable1 = pool.acquireReusable();
        assertNotNull(reusable1, "Primer objeto nulo");
        Reusable reusable2 = pool.acquireReusable();
        assertNotNull(reusable2, "Segundo objeto nulo");
        assertNotSame(reusable1, reusable2, "Objetos con misma instancia");
        Exception exception = assertThrows(NotFreeInstanceException.class, () -> {
            pool.acquireReusable();
        });
        assertEquals("No hay más instancias reutilizables disponibles. Reintentalo más tarde", exception.getMessage());
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
        @DisplayName("testReleaseReusable")

	public void testReleaseReusable() throws NotFreeInstanceException, DuplicatedInstanceException {
		//Se obtiene la instancia del pool.
		ReusablePool miPool4 = ReusablePool.getInstance();
		
		//Se intenta adquirir un objeto reusable del pool.
		Reusable r1 = miPool4.acquireReusable();

		
		//Se intenta liberar un objeto reusable del pool.  
		miPool4.releaseReusable(r1);
		
		//Se comprueba que tras intentar liberar el mismo objeto reusable lanza la excepción porque este ya ha sido liberada.
		assertThrows(DuplicatedInstanceException.class, () -> miPool4.releaseReusable(r1), "Ya se ha devuelto ese objeto reusable anteriormente, por lo que se lanza la excepción.");

	}


}
