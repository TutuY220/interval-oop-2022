package Intervals2;

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
	//1. define data API (what are the methods (getters, constructors...))
	
	public int getLowerBound() {
		throw new IllegalArgumentException("Not yet implement");
	}
	public int getUpperBound() {
		throw new IllegalArgumentException("Not yet implement");
	}
	
	// If it is mutable, we have to consider also the state
	
	public int getLength() {
		throw new IllegalArgumentException("Not yet implement");
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
		throw new IllegalArgumentException("Not yet implement");

	}
	
	/**
	 * Shifts the interval stored by this object to the right by the given amount
	 * 
	 * @post | getLowerBound() == old(getLowerBound()) + amount
	 * @post | getUpperBound() == old(getUpperBound()) + amount
	 */
	
	//mutator
	public void shift(int amount) {
		throw new IllegalArgumentException("Not yet implement");
	}
}
