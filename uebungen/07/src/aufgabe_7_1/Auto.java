package aufgabe_7_1;

public class Auto {
    private boolean hatTurbo;
    private Kunde kunde;
    private int parkdauer;

    public Auto(boolean hatTurbo, Kunde kunde, int parkdauer) {
        this.hatTurbo = hatTurbo;
        this.kunde = kunde;
        this.parkdauer = parkdauer;
    }

    public boolean hatTurbo(){
        return this.hatTurbo;
    }
    public Kunde kunde(){
        return this.kunde;
    }
    public int parkdauer(){
        return this.parkdauer;
    }
}
