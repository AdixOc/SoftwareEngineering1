public class Person {
    public String anrede;
    public String titel;
    public String name;
    public String vorname;
    public String organisation;
    public String abteilung;
    public String straße;
    public String hausnummer;
    public String plz;
    public String stadt;

    public Person(String input) {
        String[] teile = input.split("(,\\s)");
        String[] nameTeile = teile[0].split("\\s");
        String[] strasseTeile = teile[3].split("\\s");
        String[] ortTeile = teile[4].split("\\s");
        anrede = nameTeile[0];
        titel = nameTeile[1];
        name = nameTeile[3];
        vorname = nameTeile[2];
        organisation = teile[1];
        abteilung = teile[2];
        straße = strasseTeile[0];
        hausnummer = strasseTeile[1];
        plz = ortTeile[0];

        StringBuilder stadtBuilder = new StringBuilder();
        for (int i = 1; i < ortTeile.length; ++i) {
            stadtBuilder.append(ortTeile[i]);
            stadtBuilder.append(" ");
        }
        stadt = stadtBuilder.toString();
    }
}
