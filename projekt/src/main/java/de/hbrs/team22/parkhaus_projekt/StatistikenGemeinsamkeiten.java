package de.hbrs.team22.parkhaus_projekt;

public abstract class StatistikenGemeinsamkeiten {

    final public void statistikenBerechnen(double[] arrayPreis, double[] arrayParkDauer) { // Die finale Schablonenmethode, benutzt Einschubmethoden
        durchschnittMethode(arrayPreis);
        durchschnittMethode(arrayPreis);
        durchschnittMethode(arrayParkDauer);
        durchschnittMethode(arrayParkDauer);
    }



    /*
    Nun die Einschubmethoden, welche abstract und protected sind.
    Als Parameter werden double[] arrays genutzt

    SummeMethode, womit dann über eine bestimmte Zeit (mit den jeweiligen Werten in dem Zeitraum), wie zum Beispiel für
    einen Tag, die Summe wichtiger Werte berechnet werden kann
     */
    public abstract double durchschnittMethode(double[] array);
    public abstract double summeMethode(double[] array);

}
