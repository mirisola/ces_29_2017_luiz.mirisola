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
public class MoneyTestV1 {

	private Money m12CHF;
	private Money m14CHF;
	private Money m12BRL;
	private Money m14BRL;
	
	
	// a MoneyTest is constructed for each test. 
	// Then before calling the test, this method is called.
	@Before
	public void setUp() {
		m12CHF = new Money(12, "CHF");
		m14CHF = new Money(14, "CHF");
		m12BRL = new Money(12, "BRL");
		m14BRL = new Money(14, "BRL");
	}
	
	
	@Test
	public void testEqualsWithEqualMoneys() {
		
		Money actual = new Money(12, "CHF");
		// now, we tested all possible cases of (in)equality on currency and value
		assertEquals(m12CHF, actual); 
		assertNotEquals(m14CHF, actual); 
		assertNotEquals(m12BRL, actual);
		assertNotEquals(m14BRL, actual);
		
		// we also test if there is someproblem when equals works on itself
		assertSame(actual,actual); // checks if they are the same pointer
		assertEquals(actual,actual); // assertEquals is different form assertSame
		
		
		//these redundant tests are just to show alternative syntaxes.
		assertEquals(m12CHF, actual); // repeated 
		assertTrue(!m12CHF.equals(m14CHF)); // repeated
		assertFalse(m12CHF.equals(m14CHF)); // repeated
		}

	@Test
	public void testEqualsWithDifferentMoneys() {
		
		Money actual = new Money(12, "CHF");
		// now, we tested all possible cases of (in)equality on currency and value
		assertNotEquals(m14CHF, actual); 
		assertNotEquals(m12BRL, actual);
		assertNotEquals(m14BRL, actual);
		
		}

	@Test
	public void testEqualsWithPrefixCurrencies() {
		
		Money actual = new Money(12, "CHFrancs");
		// when comparing strings, a reasonable doubt is 
		// "if one string is prefix of another, are they equal?"
		// thus, this test answers this question, and serves as documentation
		assertNotEquals(m12CHF, actual); 
		}

	
}//class MoneyTestV0
