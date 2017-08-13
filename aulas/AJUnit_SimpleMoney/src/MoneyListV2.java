import java.util.LinkedList;
import java.util.List;

// change default behavior: lists are equal even with different ordering
// can not use AbstractList.equals()
public class MoneyListV2 {
	
	private List<Money> _monies = new LinkedList<Money>( );

	public int size() { return _monies.size(); }
	
	public void add(Money m) { _monies.add(m); }
	public Money get(int i) { return _monies.get(i); }
	
	// EEEEEAAAASY! contains is smart and uses equals() for its elements
	public boolean contains(Money m) {return _monies.contains(m); }
	
	public boolean equals(Object anObject) {
		
		if (this == anObject) // this checks if they are the same pointer!
			return true; 
		if (!(anObject instanceof MoneyListV2))
			return false;
		MoneyListV2 otherlist = (MoneyListV2) anObject;
		if (!(otherlist.size() == this.size()))
			return false;
		
		for (int i=0; i < otherlist.size() ; i++) {
			if (!contains(otherlist.get(i)))
				return false;
		}//for
		return true;
		
	}//equals
	
}//class
