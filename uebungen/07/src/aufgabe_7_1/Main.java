package aufgabe_7_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ParkHaus parkHaus = new ParkHaus(210);
        Random random = new Random();
        List<Auto> autos = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            Kunde kunde = new Kunde(random.nextBoolean());
            autos.add(new Auto(random.nextBoolean(), kunde, random.nextInt(0, 7*24*60)));
        }
        int res_7_1_a = autos.stream().filter(Auto::hatTurbo).filter(auto -> auto.kunde().istFirma()).mapToInt(x -> x.parkdauer() * parkHaus.gebuehr()).reduce(Integer::sum).getAsInt();
        List<Auto> autos_7_1_b = autos.stream().filter(auto -> auto.parkdauer() > 24*60).toList();
        System.out.println(res_7_1_a);
        System.out.println(autos_7_1_b);
    }
}