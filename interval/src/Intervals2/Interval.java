package Intervals2;

// First merge the work your partner did, then push

/**
 * 
 * Each instance of this class stores an interval with integer bounds.
 * Abstract state invariants
 * 
 * @invar | getLength() == getUpperBound() - getLowerBound()
 * @invar | getLowerBound() <= getUpperBound()
 *
 */
public class Interval {

	//Defining data abstraction
	//1. Define data API (what are the methods (getters, constructors...))
	
	/**
	 * Representation invariants
	 * 
	 * @invar | lowerBound <= upperBound
	 */
	
	private int lowerBound;
	private int upperBound;
	
	//map concrete state to abstract state
	
	public int getLowerBound() {
		return lowerBound;
	}
	public int getUpperBound() {
		return upperBound;
	}
	
	// If it is mutable, we have to consider also the state
	
	public int getLength() {
		return upperBound - lowerBound;
	}
	
	/**
	 * Initialize this object to store the interval with the given lower bound and upper bound.
	 * 
	 * 
	 * @throws IllegalArgumentException | upperBound < lowerBound
	 * @post | getLowerBound() == lowerBound
	 * @post | getUpperBound() == upperBound
	 */
	public Interval(int lowerBound, int upperBound) {
		if(lowerBound > upperBound) {
			throw new IllegalArgumentException("upperBound is less than the lowerBound");
		}
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;

	}
	
	/**
	 * Shifts the interval stored by this object to the right by the given amount
	 * 
	 * @post | getLowerBound() == old(getLowerBound()) + amount
	 * @post | getUpperBound() == old(getUpperBound()) + amount
	 */
	
	//mutator
	public void shift(int amount) {
		lowerBound += amount;
		upperBound += amount;
	}
	
	//abstract state is determined by the return value of the getters
}
