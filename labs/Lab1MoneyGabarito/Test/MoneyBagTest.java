import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MoneyBagTest {
	private Money m12BRL;
	private Money m10USD;
	private Money m12CHF;
	private Money m14CHF;
	private MoneyBag mb01;
	
	@Before
	public void setUp() throws Exception {
		m12BRL = new Money(12, new Currency("BRL"));
		m10USD = new Money(10, new Currency("USD"));
		m12CHF = new Money(12, new Currency("CHF"));
		m14CHF = new Money(14, new Currency("CHF"));
		mb01 = new MoneyBag();
	}

	@Test
	public void testMoneyBagEmpty() {
		assertTrue(mb01.getMonies().size()==0);
	}
	@Test
	public void testMoneyBagOneTypeOfCurrency() {
		MoneyBag mb01 = new MoneyBag();
		mb01.addMoney(m14CHF);
		assertTrue(mb01.getMonies().size()==1);
		assertTrue(mb01.getMonies().contains(m14CHF));
		assertTrue(mb01.getMonies().contains(new Money(14, new Currency("CHF"))));
	}
	@Test
	public void testMoneyBagTwoTypesOfSameCurrency() {
		mb01.addMoney(m12CHF);
		mb01.addMoney(m14CHF);
		assertTrue(mb01.getMonies().size()==1);
		assertFalse(mb01.getMonies().contains(m12CHF));
		assertFalse(mb01.getMonies().contains(m14CHF));
		assertTrue(mb01.getMonies().contains( new Money(26, new Currency("CHF")) ));
		
	}
	
	@Test
	public void testMoneyBagTwoTypesOfDifferentCurrency() {
		mb01.addMoney(m12CHF);
		mb01.addMoney(m10USD);
		assertTrue(mb01.getMonies().size()==2);
		assertTrue(mb01.getMonies().contains(m12CHF));
		assertTrue(mb01.getMonies().contains(m10USD));
	}
	@Test
	public void testMoneyBagThreeTypesOfCurrencies() {
		
		mb01.addMoney(m12BRL);
		mb01.addMoney(m10USD);
		mb01.addMoney(m14CHF);
		assertTrue(mb01.getMonies().size()==3);
		assertTrue(mb01.getMonies().contains(m12BRL));
		assertTrue(mb01.getMonies().contains(m10USD));
		assertTrue(mb01.getMonies().contains(m14CHF));
	}
	@Test
	public void testMoneyBagFromThreeToTwoTypesOfCurrencies() {
		mb01.addMoney(m12BRL);
		mb01.addMoney(m10USD);
		mb01.addMoney(m14CHF);
		assertTrue(mb01.getMonies().size()==3);
		Money m26CHF = new Money(26, new Currency("CHF")) ;
		assertTrue(mb01.getMonies().contains(m10USD));
		assertFalse(mb01.getMonies().contains(m26CHF));
		assertTrue(mb01.getMonies().contains(m14CHF));
		assertTrue(mb01.getMonies().contains(m12BRL));
		mb01.removeMoney(m14CHF);
		assertTrue(mb01.getMonies().size()==2);
		assertFalse(mb01.getMonies().contains(m26CHF));
		assertTrue(mb01.getMonies().contains(m10USD));
		assertFalse(mb01.getMonies().contains(m14CHF));
		assertFalse(mb01.getMonies().contains(m12CHF));
		assertTrue(mb01.getMonies().contains(m12BRL));
	}
	@Test
	public void testMoneyBagFromTwoToOneTypeOfCurrency() {
		mb01.addMoney(m12CHF);
		mb01.addMoney(m10USD);
		mb01.addMoney(m14CHF);
		assertTrue(mb01.getMonies().size()==2);
		assertFalse(mb01.getMonies().contains(m12CHF));
		assertTrue(mb01.getMonies().contains(m10USD));
		Money m26CHF = new Money(26, new Currency("CHF")) ;
		assertTrue(mb01.getMonies().contains( m26CHF ));
		mb01.removeMoney(m26CHF);
		assertTrue(mb01.getMonies().size()==1);
		assertFalse(mb01.getMonies().contains(m12CHF));
		assertTrue(mb01.getMonies().contains(m10USD));
		assertFalse(mb01.getMonies().contains(m14CHF));
	}
	@Test
	public void testMoneyBagFromOneToZeroTypeOfCurrency() {
		
		mb01.addMoney(m12CHF);
		mb01.addMoney(m14CHF);
		assertTrue(mb01.getMonies().size()==1);
		Money m26CHF = new Money(26, new Currency("CHF")) ;
		assertTrue(mb01.getMonies().contains( m26CHF ));
		mb01.removeMoney(m26CHF);
		assertTrue(mb01.getMonies().size()==0);
		assertFalse(mb01.getMonies().contains(m12CHF));
		assertFalse(mb01.getMonies().contains(m14CHF));
		assertFalse(mb01.getMonies().contains(m26CHF));
	}
	@Test
	public void testMoneyBagGetMonies() {
		
		mb01.addMoney(m12BRL);
		mb01.addMoney(m10USD);
		mb01.addMoney(m14CHF);
		String expected = "12BRL10USD14CHF";
		String actual = "" + mb01.getMonies().get(0) + mb01.getMonies().get(1) + mb01.getMonies().get(2);
		assertEquals(expected, actual);
	}
}


