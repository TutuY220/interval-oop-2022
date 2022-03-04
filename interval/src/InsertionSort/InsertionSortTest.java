package InsertionSort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class InsertionSortTest {

	@Test
	void test() {
		int[] array = {1,4,2,5,3,6,7,3};
		InsertionSort sort = new InsertionSort(array);
		assert sort.getArray() == array;
		sort.insertionSort();
		int[] sortedArray = {1,2,3,3,4,5,6,7};
		assert Arrays.equals(sortedArray, sort.getArray());
		
		int[] array2 = {};
		InsertionSort sort2 = new InsertionSort(array2);
		assert Arrays.equals(sort2.getArray(), array2);
		sort.insertionSort();
		int[] sortedArray2 = {};
		assert Arrays.equals(sortedArray2, sort2.getArray());
	}

}
