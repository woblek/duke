import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    void testToString() {
        Integer[] date = {05,10,2019,1800};
        String eventName = "watch movies with friends";
        Event event = new Event(eventName, date);
        assertEquals("[E][✘] watch movies with friends (at: 5/10/2019 1800)", event.toString());
    }


    @Test
    void getDate() {
        Integer[] date = {05,10,2019,1800};
        String eventName = "watch movies with friends";
        Event event = new Event(eventName, date);
        assertEquals("5/10/2019 1800", event.getDate());
    }
}