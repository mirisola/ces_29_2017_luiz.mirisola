import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MoneyListV2TestV0 {

	private  MoneyListV2 ml;
	@Before
	public void setUp() throws Exception {
		ml = new MoneyListV2();
		ml.add(new Money(10,"BRL"));
		ml.add(new Money( 5,"CHF"));
		ml.add(new Money(15,"USD"));
	}

	// list all problems with this test.
	@Test
	public void testListEquals() {
		MoneyListV2 actual = new MoneyListV2();
		actual.add(new Money(10,"BRL"));
		actual.add(new Money( 5,"CHF"));
		actual.add(new Money(15,"USD"));
		assertEquals(ml,actual);
	}

}
