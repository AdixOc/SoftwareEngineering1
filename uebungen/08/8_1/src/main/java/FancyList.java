import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class FancyList implements Iterable<Integer>{
    private final boolean even;
    private final int[] integers;

    public FancyList(int[] integers, boolean even) {
        this.even = even;
        this.integers = integers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new EvenOddIterator(integers, even);
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return Iterable.super.spliterator();
    }

    class EvenOddIterator implements Iterator<Integer>{
        private int cursor;
        private final boolean even;
        private final int[] integers;

        public EvenOddIterator(int[] integers, boolean even) {
            this.cursor = 0;
            this.even = even;
            this.integers = integers;
        }

        @Override
        public boolean hasNext() {
            if (integers.length>cursor-1){
                for (int i = cursor; i < integers.length; i++) {
                    if ((integers[i] % 2 == 0) == even){
                        return true;
                    }
                }
            }else {
                return false;
            }
            return false;
        }

        @Override
        public Integer next() {
            for (int i = cursor; i < integers.length; i++) {
                if ((integers[i] % 2 == 0) == even) {
                    this.cursor = i+1;
                    return integers[i];
                }
            }
            return null;
        }
    }
}
