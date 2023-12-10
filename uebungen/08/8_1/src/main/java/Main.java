import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        FancyList fancyList = new FancyList(new int[]{2,4,6,8}, true);
        for (int i : fancyList) {
            System.out.println(i);
        }
        Iterator<Integer> iter = fancyList.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
