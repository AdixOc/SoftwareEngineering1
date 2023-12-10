import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class FancyListTest {


    @Test
    void testEven() {
        int[] arr = new int[]{1,2,2,3,7};
        FancyList fancyList = new FancyList(arr, true);
        Iterator<Integer> iterator = fancyList.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testOdd() {
        int[] arr = new int[]{1,2,2,3,7};
        FancyList fancyList = new FancyList(arr, false);
        Iterator<Integer> iterator = fancyList.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(7, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testHasNext(){
        int[] arr = new int[]{};
        FancyList fancyList = new FancyList(arr, true);
        Iterator<Integer> iterator = fancyList.iterator();
        assertFalse(iterator.hasNext());
        assertNull(iterator.next());
        assertFalse(iterator.hasNext());

        arr = new int[]{1};
        fancyList = new FancyList(arr, true);
        iterator = fancyList.iterator();
        assertFalse(iterator.hasNext());
        assertNull(iterator.next());
        assertFalse(iterator.hasNext());

        arr = new int[]{2};
        fancyList = new FancyList(arr, true);
        iterator = fancyList.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertFalse(iterator.hasNext());
        assertNull(iterator.next());

    }
}