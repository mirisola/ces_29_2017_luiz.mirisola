

public class Currency {
	private String _currency;
	
	public Currency(String currency) {
		setCurrency(currency);
	}

	public String getCurrency() {
		return _currency;
	}
	protected void setCurrency(String currency) {
		this._currency = currency;
	}
	
	
		// Acrescentei equals() a Currency
	public boolean equals(Object anObject) {
		if (anObject instanceof Currency) {
			Currency aCurrency = (Currency) anObject;
		return	getCurrency() == aCurrency.getCurrency();
		}
		return false;
	}
		// Acrescentei toString() a Currency
	public String toString(){
		return _currency;
	}

}
