package timeofday;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeOfDayTest {
	
	@Test
	void test() {
		TimeOfDay t = new TimeOfDay(12, 15);
		assert t.getHours() == 12 && t.getMinutes() == 15;	
		assert t.getMinutesSinceMidnight()==735;
		
		t.setHours(5);
		assertEquals(5, t.getHours());
		assertEquals(5*60+15, t.getMinutesSinceMidnight());

	}

}
