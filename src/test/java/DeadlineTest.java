import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadlineTest {

    @Test
    void testToString() {
        Integer[] date = {05,10,2019,1800};
        String eventName = "send postcard to Malaysia";
        Deadline deadline = new Deadline(eventName, date);
        assertEquals("[D][✘] send postcard to Malaysia (by: 5/10/2019 1800)", deadline.toString());
    }

    @Test
    void getDate() {
        Integer[] date = {05,10,2019,1800};
        String eventName = "send postcard to Malaysia";
        Deadline deadline = new Deadline(eventName, date);
        assertEquals("5/10/2019 1800", deadline.getDate());
    }
}