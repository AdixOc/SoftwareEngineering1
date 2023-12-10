import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimestampTest {

    @Test
    void construct(){
        Timestamp test1 = new Timestamp(1, 255);
        assertEquals(5, test1.getHours());
        assertEquals(15, test1.getMinutes());
    }

    @Test
    void add() {
        Timestamp test1 = new Timestamp(1, 1);
        Timestamp test2 = new Timestamp(1, 1);
        test1.add(test2);
        assertEquals(2, test1.getHours());
        assertEquals(2, test1.getMinutes());
    }

    @Test
    void add2() {
        Timestamp test1 = new Timestamp(1, 30);
        Timestamp test2 = new Timestamp(1, 30);
        test1.add(test2);
        assertEquals(3, test1.getHours());
        assertEquals(0, test1.getMinutes());
    }

    @Test
    void addMinutes() {
        Timestamp test1 = new Timestamp(1, 1);
        test1.add(63);
        assertEquals(2, test1.getHours());
        assertEquals(4, test1.getMinutes());
    }

    @Test
    void subtractMinutes() {
        Timestamp test1 = new Timestamp(1, 1);
        test1.subtract(3);
        assertEquals(0, test1.getHours());
        assertEquals(58, test1.getMinutes());
    }

    @Test
    void subtract() {
        Timestamp test1 = new Timestamp(2, 1);
        Timestamp test2 = new Timestamp(1, 1);
        test1.subtract(test2);
        assertEquals(1, test1.getHours());
        assertEquals(0, test1.getMinutes());
    }

    @Test
    void getHours() {
        Timestamp test1 = new Timestamp(1, 1);
        assertEquals(1, test1.getHours());
    }

    @Test
    void getMinutes() {
        Timestamp test1 = new Timestamp(1, 1);
        assertEquals(1, test1.getMinutes());
    }
}