import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TimestampTest {
    Timestamp ts;
    Timestamp ts2;

    @BeforeEach
    void setUp() {
        this.ts = new Timestamp(15,10);
        this.ts2 = new Timestamp(5,0);
    }

    @Test
    void substractSimple() {
        ts.substract(ts2);

        assertEquals(10, ts.getHour());
        assertEquals(10, ts.getMinute());
    }

    @Test
    void substractWithOverflow(){
        ts2.setMinute(11);
        ts.substract(ts2);

        assertEquals(9, ts.getHour());
        assertEquals(59, ts.getMinute());

        ts.setHour(5);
        ts.setMinute(25);
        ts2.setHour(2);
        ts2.setMinute(31);

        ts.substract(ts2);

        assertEquals(2, ts.getHour());
        assertEquals(54, ts.getMinute());
    }

    @Test
    void addSimple(){
        ts.add(ts2);

        assertEquals(20, ts.getHour());
        assertEquals(10, ts.getMinute());
    }

    @Test
    void addWithOverflow(){
        ts2.setMinute(55);
        ts.add(ts2);

        assertEquals(21, ts.getHour());
        assertEquals(5, ts.getMinute());

        setUp();
        ts.setHour(20);
        ts2.setHour(4);
        ts.add(ts2);

        assertEquals(23, ts.getHour());
        assertEquals(10, ts.getMinute());
    }
}