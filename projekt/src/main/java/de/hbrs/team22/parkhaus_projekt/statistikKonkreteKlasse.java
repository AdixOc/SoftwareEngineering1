package de.hbrs.team22.parkhaus_projekt;

public class statistikKonkreteKlasse extends StatistikenGemeinsamkeiten{

    /*
    Nun die konkrete Klasse, welche die Einschubmethoden implementiert
    */


    @Override
    public double durchschnittMethode(double[] array) {
        double erg=0;
        for(int i=0; i<array.length; i++) {
            erg = erg + array[i];
        }
        erg=erg/array.length;
        return erg;
    }

    @Override
    public double summeMethode(double[] array) {
        double erg=0;
        for(int i=0; i<array.length; i++) {
            erg = erg+array[i];
        }
        return erg;
    }
}
