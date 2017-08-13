import java.util.LinkedList;
import java.util.List;

// Example to explain why to use equals()! 
public class MoneyList {
	
	private List<Money> _monies = new LinkedList<Money>( );

	public int size() { return _monies.size(); }
	
	public void add(Money m) { _monies.add(m); }
	
	// EEEEEAAAASY! contains is smart and uses equals() for its elements
	public boolean contains(Money m) {return _monies.contains(m); }
	
	public boolean equals(Object anObject) {
		

		// from https://docs.oracle.com/javase/7/docs/api/java/util/AbstractList.html#equals(java.lang.Object) 
		// class Abstract List
		// public boolean equals(Object o)
		// Compares the specified object with this list for equality. 
		// Returns true if and only if the specified object is also a list, 
		// both lists have the same size, and 
		// all corresponding pairs of elements in the two lists are equal. 
		// (Two elements e1 and e2 are equal if (e1==null ? e2==null : e1.equals(e2)).) 
		// In other words, two lists are defined to be equal if they contain the same elements
		// in the same order.

		// This implementation first checks if the specified object is this list.
		// If so, it returns true; if not, it checks if the specified object is a list. 
		// If not, it returns false; if so, it iterates over both lists, comparing corresponding pairs of elements. If any comparison returns false, this method returns false. If either iterator runs out of elements before the other it returns false (as the lists are of unequal length); otherwise it returns true when the iterations complete.
		
		if (!(anObject instanceof MoneyList))
			return false;
		MoneyList otherlist = (MoneyList) anObject;
		
		return this.equals(otherlist);
		// important question: does the line above makes sense if you do not trust
		// the method Money.equals()? 
		// but if you do trust Money.equals(), this is TOO EASY
		// problem: you must agree with the default behavior.
	}//equals
	
}//class
