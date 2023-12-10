import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IsWellSortedTest {
    String[][] abhaengigkeit;
    SeqSorter seqSorter;

    @BeforeEach
    void setUp() {
        this.abhaengigkeit = new String[][]{{"A" , "C"}, {"C", "D"}, {"B", "C"}};
        this.seqSorter = new SeqSorter(abhaengigkeit);
    }
    @Test
    @DisplayName("Bei richtiger Eingabe 'True' zurückgeben")
    void Sorted_seq_true() {
        String[] expectedTrue = {"A", "B", "C", "D"};
        String[] expectedTrue2 = {"B", "A", "C", "D"};
       // String[] expectedFalse = {"A", "C", "B", "D"};

        assertTrue(seqSorter.isWellSorted(expectedTrue));
        assertTrue(seqSorter.isWellSorted(expectedTrue2));
}


    @Test
    @DisplayName("Bei leerer Eingabe eine Exception werfen")
    void isWellSorted_keineEingabe_Exception() {
        String[] empty = {};
        assertThrows(IllegalArgumentException.class, () -> {seqSorter.isWellSorted(empty);
        }, "Exception bei leerer Eingabe wurde nicht geworfen");
        System.out.println("Exception bei leerer Eingabe wurde geworfen");
    }

    @Test
    @DisplayName("Bei unsortierter Eingabe 'False' zurückgeben")
    void isWellSorted_seq_false() {
        String[] expectedFalse = {"A", "C", "B", "D"};
        assertFalse(seqSorter.isWellSorted(expectedFalse));
    }
}