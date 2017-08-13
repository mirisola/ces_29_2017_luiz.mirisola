
interface IMoney {
	public abstract IMoney add(Money aMoney);
	public abstract IMoney addMoneyBag(MoneyBag aMoneyBag);
}

class Money implements IMoney {
	public Money(int amount, Currency currency) {
		setAmount(amount);
		setCurrency(currency);
	}
	public IMoney add(Money aMoney) {
		if (aMoney.getCurrency().equals(getCurrency()) ){
			return new Money(getAmount() + aMoney.getAmount(), getCurrency());
		}
		MoneyBag moneyBag = new MoneyBag();
		moneyBag.addMoney(this);
		moneyBag.addMoney(aMoney);
		return moneyBag;
	}
	
	public IMoney addMoneyBag(MoneyBag aMoneyBag){
		return aMoneyBag.add(this);
	}
	public boolean equals(Object anObject) {
		if (anObject instanceof Money) {
			Money aMoney= (Money) anObject;
		return	aMoney.getCurrency().equals(getCurrency())
				&& getAmount() == aMoney.getAmount();
		}
		return false;
	}
	public String toString(){
		return "" + getAmount() + getCurrency();
	}
	public int getAmount() {
		return _amount;
	}
	public void setAmount(int amount) {
		this._amount = amount;
	}
	public Currency getCurrency() {
		return _currency;
	}
	public void setCurrency(Currency currency) {
		this._currency = currency;
	}
	private int _amount;
	private Currency _currency;
	
	 
}
	
