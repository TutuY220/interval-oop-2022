package strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class stirngTest {

	@Test
	void test() {
		char[] helloChars = {'H', 'e', 'l', 'l', 'o'};
		String hello = String.valueOf(helloChars);
		assertEquals(5, hello.length());
		assertEquals('H', hello.charAt(0));
		assertEquals('e', hello.charAt(1));
		assertArrayEquals(new char[] {'H', 'e', 'l', 'l', 'o'}, hello.toCharArray());
		
		// representations exposure: the client has the reference(access) to the object, then the client can change the object, they can only have the copy of those objects.
	char[] hello2 = hello.toCharArray();
	hello2[0] = 'Y';
	
	
	
	}

}
