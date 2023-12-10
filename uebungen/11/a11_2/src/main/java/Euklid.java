public class Euklid {
    public int ggT(int a, int b) {
        int counter = 0;
        if (a == 0) {
            return b;
        } else {
            while (b != 0) {
                ++counter;
                if (a > b) {
                    a -= b;
                } else {
                    b -= a;
                }
            }
        }

        return a;
    }
}
