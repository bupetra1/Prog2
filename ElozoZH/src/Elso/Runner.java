package Elso;

import java.util.*;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {

        // TreeSet, amely rendszám szerint rendezi az autókat
        TreeSet<Auto> autok = new TreeSet<>(Comparator.comparing(Auto::getRendszam));

        Scanner sc = new Scanner(System.in);

        System.out.println("Kérem adjon meg 6 autót a következő formában:");
        System.out.println("Rendszám;Márka;Típus;Évjárat;Tulajdonos név");
        System.out.println("Példa: XYZ-987;Volkswagen;Golf;2018;Nagy Anna\n");

        for (int i = 1; i <= 6; i++) {
            System.out.print(i + ". autó adatai: ");

            String sor = sc.nextLine().trim();
            String[] adat = sor.split(";");

            String rendszam = adat[0].trim();
            String marka = adat[1].trim();
            String tipus = adat[2].trim();
            int evjarat = Integer.parseInt(adat[3].trim());
            String tulajdonos = adat[4].trim();

            autok.add(new Auto(rendszam, marka, tipus, evjarat, tulajdonos));
        }

        for (Auto a : autok) {
            System.out.println(a);
        }
        List<Auto> szurtAutok = markaAlapuSzures(autok,"Volkswagen");
        System.out.println("-----------------------------");
        szurtAutok.stream().forEach(System.out::println);
        Collections.sort(szurtAutok, new AutoComparator());
        System.out.println("-----------------------------");
        szurtAutok.stream().forEach(System.out::println);
    }
    public static List<Auto> markaAlapuSzures(TreeSet<Auto> kollekcio, String markanev){
        double atlagEvjarat = kollekcio.stream().mapToInt(Auto::getEvjarat).average().orElse(0);
        return kollekcio.stream().filter(auto -> auto.getMarka().equals(markanev)).filter(auto -> auto.getEvjarat() > atlagEvjarat).collect(Collectors.toList());
    }
}
