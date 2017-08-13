import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

	public class MoneyBagAddTest {
		private MoneyBag mb01;
		private Money m12CHF;
		private Money m14CHF;
		private Money m10CHF;
		private Money m12USD;
		
		@Before
		public void setupTest() {
			mb01 = new MoneyBag();
			m12CHF = new Money(12, new Currency("CHF"));
			m14CHF = new Money(14, new Currency("CHF"));
			m10CHF = new Money(10, new Currency("CHF"));
			m12USD = new Money(12, new Currency("USD"));
		}
		@Test
		public void testMoneyBagEmpty() {
			assertTrue(mb01.getMonies().size()==0);
		}
		@Test
		public void testMoneyBagAddOneTypeOfCurrency() {
			mb01.addMoney(m12CHF);
			assertTrue(mb01.getMonies().size()==1);
			assertTrue(mb01.getMonies().contains(m12CHF));
			assertTrue(mb01.getMonies().contains(new Money(12, new Currency("CHF"))));
		}
		@Test
		public void testMoneyBagAddTwoMoniesOfSameTypeOfCurrency() {
			mb01.addMoney(m12CHF);
			mb01.addMoney(m14CHF);
			assertTrue(mb01.getMonies().size()==1);
			assertFalse(mb01.getMonies().contains(m12CHF));
			assertFalse(mb01.getMonies().contains(m14CHF));
			assertTrue(mb01.getMonies().contains(new Money(26, new Currency("CHF"))));
		}
		@Test
		public void testMoneyBagAddThreeMoniesOfSameTypeOfCurrency() {
			mb01.addMoney(m12CHF);
			mb01.addMoney(m14CHF);
			mb01.addMoney(m10CHF);
			assertTrue(mb01.getMonies().size()==1);
			assertFalse(mb01.getMonies().contains(m12CHF));
			assertFalse(mb01.getMonies().contains(m14CHF));
			assertFalse(mb01.getMonies().contains(m10CHF));
			assertTrue(mb01.getMonies().contains(new Money(36, new Currency("CHF"))));
		}
		@Test
		public void testMoneyBagAddThreeMoniesOneDifferentTypeOfCurrency() {
			mb01.addMoney(m12USD);
			mb01.addMoney(m14CHF);
			mb01.addMoney(m10CHF);
			assertTrue(mb01.getMonies().size()==2);
			assertTrue(mb01.getMonies().contains(m12USD));
			assertFalse(mb01.getMonies().contains(m14CHF));
			assertFalse(mb01.getMonies().contains(m10CHF));
			Money expected = (Money) (m14CHF.add(m10CHF));
			Money actual = (Money) mb01.getMonies().get(1);
			assertEquals(expected, actual);
			expected = m12USD;
			actual = (Money) mb01.getMonies().get(0);
			assertEquals(expected, actual);
		}
		@Test
		public void testMoneyBagAddTwoMoniesOfDifferentTypesOfCurrency() {
			mb01.addMoney(m12USD);
			mb01.addMoney(m14CHF);
			IMoney mb02 = m12USD.add(m14CHF);
			assertEquals(mb01, mb02);
			assertEquals(m12USD.add(m14CHF), mb02);
		}
		@Test
		public void testMoneyBagAddOneMoneyBagToSimpleMoney() {
			mb01.addMoney(m12USD);
			mb01.addMoney(m14CHF);
			MoneyBag res = (MoneyBag)m12CHF.addMoneyBag(mb01);
			assertTrue(res.getMonies().contains(m12USD));
			Money expected = (Money) (m14CHF.add(m12CHF));
			assertTrue(res.getMonies().contains(expected));
		}
		
		@Test
		public void testMoneyBagAddTwoMoneyBag() {
			Money m20BRL = new Money(20, new Currency("BRL"));
			mb01.addMoney(m14CHF);
			mb01.addMoney(m20BRL);
			MoneyBag mb02 = new MoneyBag();
			mb02.addMoney(m12CHF);
			mb02.addMoney(m12USD);
			mb01.addMoneyBag(mb02);
			assertTrue(mb01.getMonies().size()==3);
			assertTrue(mb01.getMonies().contains(m12USD));
			assertTrue(mb01.getMonies().contains(m20BRL));
			assertTrue(mb01.getMonies().contains(  new Money(26, new Currency("CHF"))  ));
		}
	
	
	}//class MoneyBagAddTest
	
