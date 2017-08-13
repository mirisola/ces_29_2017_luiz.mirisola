import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author lgm
 *
 */
public class MoneyTest {

	private Money m12CHF;
	private Money m14CHF;
	
	// a MoneyTest is constructed for each test. 
	// Then before calling the test, this method is called.
	@Before
	public void setUp() {
		m12CHF = new Money(12, new Currency("CHF"));
		m14CHF = new Money(14, new Currency("CHF"));
	}
	@Test
	public void testSimpleAdd() {
		Money expected = new Money(26, new Currency("CHF"));
		Money result = (Money) m12CHF.add(m14CHF); // (2)
		assertTrue(expected.equals(result)); // (3)
	}
	@Test
	public void testEquals() {
		assertTrue(!m12CHF.equals(null));
		assertEquals(m12CHF, m12CHF);
		Money actual = new Money(12, new Currency("CHF"));
		assertEquals(m12CHF, actual); // (1)
		assertTrue(!m12CHF.equals(m14CHF));
		assertFalse(m12CHF.equals(m14CHF));
		}

}//class MoneyTest
