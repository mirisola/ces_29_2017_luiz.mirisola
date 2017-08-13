


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MoneyBag implements IMoney{
	public MoneyBag( ) { }

	public void addMoney(Money money){
		boolean notFoundMoneySameCurrency = true;
		for (int i = 0; notFoundMoneySameCurrency && (i < this.size()); i++) {
			IMoney moneySameCurrency = _monies.get(i);
			Money aMoneySameCurrency = (Money) moneySameCurrency;
			if (aMoneySameCurrency.getCurrency().equals(money.getCurrency()) ){
				_monies.add(money.add(aMoneySameCurrency));
				_monies.remove(aMoneySameCurrency);
				notFoundMoneySameCurrency = false;
			}
		}
		if ((this.size() == 0) || (notFoundMoneySameCurrency)) {
			_monies.add(money);}
	}
	
	public void removeMoney(Money money) {
		_monies.remove(money);
	}
	public IMoney addMoneyBag(MoneyBag aMoneyBag){
		for (int i = 0; i < aMoneyBag.size(); i++) {
			IMoney currentMoney = aMoneyBag.getMonies().get(i);
			Money aCurrentMoney = (Money) currentMoney;
			this.add(aCurrentMoney);
		}
		return this;
	}
	public IMoney add(Money aMoney){
		this.addMoney(aMoney);
		return this;
	}
	public int size(){
		return _monies.size();
	}
	public boolean equals(Object anObject) {
		if (!(anObject instanceof MoneyBag))
			return false;
		MoneyBag moneyBag = (MoneyBag) anObject;
		if (!(moneyBag.size() == this.size()))
			return false;
		List<IMoney> moniesBag = moneyBag.getMonies();
		IMoney currentMoney0 = _monies.get(0);
		Money aCurrentMoney0 = (Money) currentMoney0;
		IMoney amoney0 = moniesBag.get(0);
		Money aMoney0 = (Money) amoney0;
		IMoney currentMoney1 = _monies.get(1);
		Money aCurrentMoney1 = (Money) currentMoney1;
		IMoney amoney1 = moniesBag.get(1);
		Money aMoney1 = (Money) amoney1;
		return aCurrentMoney0.equals(aMoney0)
				&& aCurrentMoney1.equals(aMoney1);
		}
					
	public String toString(){
		String s = "[";
		for (int i = 0; i < this.size(); i++) {
			IMoney currentMoney = _monies.get(i);
			if (currentMoney != null) {
				Money aCurrentMoney = (Money) currentMoney;
				s = s + aCurrentMoney +" ";
			} else { s = s + "NULL "; }
		}
		return s + "]";
	}
	public List<IMoney> getMonies( ) {
		return Collections.unmodifiableList(_monies); 
	}

	public int conversionBRL(){
		int valueBRL = 0;
		for (int i = 0; i < this.size(); i++) {
			IMoney moneySameCurrency = _monies.get(i);
			Money aMoneySameCurrency = (Money) moneySameCurrency;
			if (aMoneySameCurrency.getCurrency().getCurrency() == "BRL")
				valueBRL = valueBRL + aMoneySameCurrency.getAmount();
			if (aMoneySameCurrency.getCurrency().getCurrency() == "USD")
				valueBRL = valueBRL + 3 * aMoneySameCurrency.getAmount();
			if (aMoneySameCurrency.getCurrency().getCurrency() == "CHF")
				valueBRL = valueBRL + 2 * aMoneySameCurrency.getAmount();
		}
		return valueBRL;
	}
	
	private List<IMoney> _monies = new LinkedList<IMoney>( );

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Money m10USD = new Money(10, new Currency("USD"));
		Money m12CHF = new Money(12, new Currency("CHF"));
		Money m14CHF = new Money(14, new Currency("CHF"));
		Money m20BRL = new Money(20, new Currency("BRL"));
		MoneyBag mb01 = new MoneyBag();
		MoneyBag mb02 = new MoneyBag();
		
		mb01.addMoney(m12CHF);
		mb01.addMoney(m10USD);
		System.out.println("MB1 "+mb01);
		mb02.addMoney(m14CHF);
		mb02.addMoney(m20BRL);
		System.out.println("MB2 "+mb02);
		mb02.addMoneyBag(mb01);
		System.out.println(mb02);
		
		
	}

}//class MoneyBag