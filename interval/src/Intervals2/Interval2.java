package Intervals2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Interval2 {

	@Test
	void test() {
		byte b = 127;
		short sh = 32767;
		int a = 7;
		long l = 1_000_000_000_000L;
		float f = 1e32f;
		double d = 1e100;
		char c = 'A';
		char e = 'Äã';//single character
		boolean bo = false;
		
		Interval myInterval = new Interval(10, 15);
		assertEquals(myInterval.getLowerBound(), 10);
		assertEquals(myInterval.getUpperBound(), 15);
		assertEquals(myInterval.getLength(), 5);
		
		//immutable abstraction: the value will not be changed, cannot change a variable by changing another variable
		//mutable abstraction: the value is stored in the object and can be altered, good for monitoring changing object
		
		myInterval.shift(100);
		assertEquals(myInterval.getLowerBound(), 110);
		assertEquals(myInterval.getUpperBound(), 115);
		assertEquals(myInterval.getLength(), 5);
	}

}
