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
public class MoneyTestV0 {

	private Money m12CHF;
	private Money m14CHF;
	
	// a MoneyTest is constructed for each test. 
	// Then before calling the test, this method is called.
	@Before
	public void setUp() {
		m12CHF = new Money(12, "CHF");
		m14CHF = new Money(14, "CHF");
	}
	
	
	// enough testing? do you trust the Money.equals() method now?
	// list some problems with this test
	@Test
	public void testEquals() {
		
		Money actual = new Money(12, "CHF");
		assertEquals(m12CHF, actual); // (1)
		
		}

}//class MoneyTestV0
