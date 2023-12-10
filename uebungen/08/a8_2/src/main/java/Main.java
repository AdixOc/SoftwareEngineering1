public class Main {
    public static void main(String[] args) {
        PartielleOrdnung p = PartielleOrdnung.studentLife();
        PartielleOrdnung.TopSortIterator it = p.new TopSortIterator(p.liste);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
