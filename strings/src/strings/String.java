package strings;

import java.util.Arrays;

/**
 * Abstract state invariant
 * 
 * @invar | toCharArray() != null
 * @invar | length() == toCharArray().length
 *
 */

public class String {
	
	/**
	 * @invar | characters != null
	 * 
	 * @representationsObject
	 */
	
	private char[] characters;
	

	//this method does not mutate any object and does not start with getter, so we specify them as inspects?
	// immutable class so we do not mutate method
	
	/**
	 * @inspects | this
	 * @creates | result
	 */
	public char[] toCharArray() {
		return characters.clone();
		// don't return a pointer to the character to the client, but return a copy to them, therefore thay cannot change the obeject.
	}
	
	/**
	 * 
	 * @inspects | this
	 */
	
	public int length() {
		return characters.length;
	}
	

	
	private String(char[] characters) {
		this.characters = characters;
	}
	// put preconditions to make sure your post conditions don't crash
	// we cannot write private things in public documentation (eg: this.characters), after specify "@representation" in the documentation, we tehn can write private things.
	// @representation allows the inspectation of both the object and the replicate of that object
	/**
	 * @pre | 0 <= index && index < length()
	 * 
	 * @inspects | this
	 * 
	 * @post | result == toCharArray()[index]
	 */
	public char charAt(int index) { //
		return characters[index];
	}
	
	// mutators: set methods ---- mutates the objects
	
	private static String EMPTY = new String(new char[] {});
	
	// Factory method-----for immutable object
	// For comparing contents of two arrays, we cannot use ".equals" or "=="
	
	/**
	 * @post | result != null
	 * @post | Arrays.equals(result.toCharArray(), characters)
	 */
	public static String valueOf(char[] characters) {
		if(characters.length == 0)
			return EMPTY;
		else
			return new String(characters.clone());
		// representations exposure: the client has the reference(access) to the object, then the client can change the object, they can only have the copy of those objects.
	}
}
