package InsertionSort;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * An object of this class stores an array with integers.
 * 
 * @invar This array should not be null.
 *      | getArray() != null
 */

public class InsertionSort {
	
	/**
	 * @invar This array of the InsertionSort class cannot be null
	 *      | array != null
	 */
	private int[] array;
	
	/**
	 * Initialize this InsertionSort class with the give integer array
	 * 
	 * @pre The given array cannot be null
	 *    | array != null
	 * @post This array equals the give array
	 *    | getArray() == array
	 */
	public InsertionSort(int[] array) {
		this.array = array;
	}
	
	/**
	 * Insert a number (v) in the position 0~n of the array so that the first n elements are sorted in ascending order, and all the numbers larger 
	 * than v in the first n position of the array moves to one position to the right.
	 * 
	 * @pre The input array must not be null
	 *    | array != null
	 * @pre The input length n must be larger than 0 and less than the length of the array
	 *    | n > 0 && n < array.length
	 * @post The length of the output array should be equal to the length of the input array
	 *    | array.length == result.length
	 * @post The number in the output array at index n should be larger or equal to the input number v
	 *    | v<=result[n]
	 *    
	 * 老师写的
	 *
	 * @pre array not null
	 *    | array != null
	 * @pre Array length should be grater than n
	 *    | array.length > n
	 * @pre n is not negative
	 *    | n > 0
	 * @pre The segment of the array between index 0 (inclusive) and n (exclusive) is in ascending order
	 *    | IntStream.range(0, n-1).allMatch(i -> array[i] <= array[i+1])
	 * @post Some element in the array equals v 
	 *    | Arrays.stream(array,0,n+1).anyMatch(e -> e == v)
	 * @post The segment of the array between index 0 (inclusive) and n (exclusive) is in ascending order
	 *    | IntStream.range(0, n).allMatch(i -> array[i] <= array[i+1])
	 * @post For each element in the new array, the number of times this element in the new array segment equals to number of times it appears in the old array 
	 * segment except if the element equals v, in which it appears one more time
	 *    | Arrays.stream(array, 0, n-1).allMatch(e ->
	 *    | Arrays.stream(array, 0, n+1).filter(e1 -> e1 == e).count() == 
	 *    | Arrays.stream(old(array.clone()), 0, n).filter(e1 -> e1 == e).count() + (e == v ? 1:0))
	 */
	// @pre 可以写成 @ throw IllegalArgumentException, and also add throw new statements in the insert method ------- defensive programming
	int[] insert(int[] array, int n, int v){
		if(array==null)
			throw new IllegalArgumentException("array is null");
		int count = 0;
		for(int i=0; i<n; i++){
			if(v>=array[i]){
				count++;
			}
		}

		for(int j=n; j>count; j--){
			array[j] = array[j-1];
		}
		array[count] = v;
		return array;
	}
	
	/**
	 * @Post The updated array should be the sorted version of the old array
	 *     | getArray == sort(old(getArray))
	 */
	void insertionSort(){
		for(int i=1; i<array.length; i++){
			insert(array, i, array[i]);
		}
	}

	public int[] getArray() {
		return array;
	}
	
}
