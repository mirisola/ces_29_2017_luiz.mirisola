import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MoneyBagConversionBRLTest {
	private Money m12USD;
	private Money m12BRL;
	private Money m14CHF;
	private Money m22CHF;
	private Money m34BRL;
	private MoneyBag mb01; 
	
	@Before
	public void setUp() throws Exception {
		m12BRL = new Money(12, new Currency("BRL"));
		m12USD = new Money(12, new Currency("USD"));
		m14CHF = new Money(14, new Currency("CHF"));
		m22CHF = new Money(22, new Currency("CHF"));
		m34BRL = new Money(34, new Currency("BRL"));
		
		mb01 = new MoneyBag();
	}
	@Test
	public void testConversionBRLMoneyBagEmpty() {
		int value = mb01.conversionBRL();
		assertEquals(0, value);
	}
	@Test
	public void testConversionBRLMoneyBagWithBRL() {
		mb01.addMoney(m12BRL);
		int value = mb01.conversionBRL();
		assertEquals(12, value);
	}
	@Test
	public void testConversionBRLMoneyBagWithBRLAndCHF() {
		mb01.addMoney(m14CHF);
		mb01.addMoney(m12BRL);
		int value = mb01.conversionBRL();
		assertEquals(40, value);
	}
	@Test
	public void testConversionBRLMoneyBagWithBRLAndUSD() {
		Money m10USD = new Money(10, new Currency("USD"));
		mb01.addMoney(m12BRL);
		mb01.addMoney(m12USD);
		mb01.addMoney(m10USD);
		int value = mb01.conversionBRL();
		assertEquals(78, value);
	}
	@Test
	public void testConversionMoneyBagWithBRLAndUSDAndCHF() {
		
		mb01.addMoney(m12USD);
		mb01.addMoney(m34BRL);
		mb01.addMoney(m14CHF);
		int value = mb01.conversionBRL();
		assertEquals(98, value);
	}
	@Test
	public void testConversionMoneyBagWithUSDAndCHF1() {
		
		IMoney mb02 = m12USD.add(m14CHF);
		MoneyBag mB02 = (MoneyBag) mb02;
		int value = mB02.conversionBRL();
		assertEquals(64, value);
	}
	@Test
	public void testConversionMoneyBagWithUSDAndCHFAndCHFAndBRL() {
		
		mb01.addMoney(m12USD);
		mb01.addMoney(m14CHF);
		mb01.addMoney(m22CHF);
		mb01.addMoney(m34BRL);
		int value = mb01.conversionBRL();
		assertEquals(142, value);
	}


}
