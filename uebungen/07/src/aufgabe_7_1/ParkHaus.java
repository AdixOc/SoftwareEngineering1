package aufgabe_7_1;

public class ParkHaus {
    public  int gebuehr;

    public ParkHaus(int gebuehr) {
        this.gebuehr = gebuehr;
    }

    protected int gebuehr(){
        return this.gebuehr;
    }
}
