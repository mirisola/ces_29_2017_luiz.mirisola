import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


// assumption: we trust the Money class inclusive its Money.equals() method
public class MoneyListV2TestV1 {

	private  MoneyListV2 ml;
	private Money BRL10 ;
	private Money CHF05 ;
	private Money USD15 ;
	
	@Before
	public void setUp() throws Exception {
		ml = new MoneyListV2();
		BRL10 = new Money(10,"BRL");
		CHF05 = new Money( 5,"CHF");
		USD15 = new Money(15,"USD");
		ml.add(BRL10);
		ml.add(CHF05);
		ml.add(USD15);
	}

	

	@Test
	public void testAdd() {
		MoneyListV2 actual = new MoneyListV2();
		
		// problem: if add is broken, actual and ml still will be equal!
		// we need to test add too!
		assertTrue(ml.contains(BRL10));
		assertTrue(ml.contains(CHF05));
		assertTrue(ml.contains(USD15));
		assertEquals(ml.size(),3);
		
	}
	
	@Test
	public void testListEqualsSameOrderEqual() {
		MoneyListV2 actual = new MoneyListV2();
		
		actual.add(new Money(10,"BRL"));
		actual.add(new Money( 5,"CHF"));
		actual.add(new Money(15,"USD"));

		// problem: if add is broken, actual and ml still will be equal!
		// we need to test add too!
		assertTrue(actual.contains(BRL10));
		assertTrue(actual.contains(CHF05));
		assertTrue(actual.contains(USD15));
		assertEquals(actual.size(),3);
		// we know both lists have the same size, and contain the same elements
		// now we check that in this case, equals() actually returns true
		assertEquals(ml,actual);
		// another way to express the same thing (redundant, just as an example)
		assertTrue(ml.equals(actual));// repeated, redundant, alternative syntax, more explicit
	}

	@Test
	public void testListEqualsDifferentOrderEqual() {
		MoneyListV2 actual = new MoneyListV2();
		
		actual.add(CHF05);
		actual.add(USD15);
		actual.add(BRL10);

		// now we trust add()! no need to check elements again!
		
		assertEquals(ml,actual);	
	}

	@Test
	public void testListEqualsDifferentMoneys() {
		MoneyListV2 actual = new MoneyListV2();
		
		actual.add(BRL10);
		actual.add(new Money( 1,"CHF"));
		actual.add(USD15);

		
		// now we trust add()!
		
		assertNotEquals(ml,actual);	
	}

	
}//class
