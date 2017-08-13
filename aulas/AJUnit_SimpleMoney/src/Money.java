


// notice to mariners: THIS IS NOT THE FINAL VERSION OF THE MONEY CLASS. E.G., THERE IS NOT A CURRENCY CLASS
class Money  {
	public Money(int amount, String currency) {
		setAmount(amount);
		setCurrency(currency);
	}
	
	public String toString(){
		return "" + getAmount() +  getCurrency();
	}
	
	// example of java syntax for equals method!
	// WE WANT TO TEST THIS METHOD
	public boolean equals(Object anObject) {
		if (anObject instanceof Money) {
			Money aMoney= (Money) anObject;
		return	aMoney.getCurrency().equals(getCurrency())
				&& getAmount() == aMoney.getAmount();
		}
		return false;
	}
	
	
	public int getAmount() {
		return _amount;
	}
	public void setAmount(int amount) {
		this._amount = amount;
	}
	public String getCurrency() {
		return _currency;
	}
	public void setCurrency(String currency) {
		this._currency = currency;
	}
	
	
	
	private int _amount;
	private String _currency;
	
	 
}
	
