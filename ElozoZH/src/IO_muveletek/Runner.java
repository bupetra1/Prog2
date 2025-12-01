package IO_muveletek;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

public class Runner {
    static void main(String[] args) {
        ArrayList<Etel> lista = new ArrayList<>();

        lista.add(new Etel("Kenyér", "222", 350,LocalDate.of(2025, 12, 3), "Pékáru"));
        lista.add(new Etel("Tej", "111", 450, LocalDate.of(2025, 12, 10), "Hűtött"));
        lista.add(new Etel("Sajt", "333", 900, LocalDate.of(2026, 1, 20), "Hűtött"));
        lista.add(new Etel("Alma", "444", 200, LocalDate.of(2025, 12, 15), "Gyümölcs"));
        lista.add(new Etel("Jogurt", "555", 480, LocalDate.of(2025, 12, 8), "Hűtött"));

        lista.sort(Comparator.comparing(Etel::getEtelTipus).thenComparing(Etel::getLejaratDatuma, Comparator.reverseOrder()));
        lista.stream().forEach(System.out::println);

        try (FileWriter fw = new FileWriter("etel.txt")) {
            for (Etel e : lista) {
                fw.write(e.toCSV() + "\n");
            }
            System.out.println("\n✔ Fájlba írás kész: etel_lista.txt");
        } catch (IOException ex) {
            System.out.println("❌ Hiba történt a fájl írásakor: " + ex.getMessage());
        }
        ArrayList<Etel> beolvasott = new ArrayList<>();
        try (FileReader fr = new FileReader("etel_lista.txt");
             BufferedReader br = new BufferedReader(fr)) {

            String sor;
            while ((sor = br.readLine()) != null) {
                String[] tomb = sor.split(";");
                Etel egyetel = new Etel(tomb[0],tomb[1], Double.parseDouble(tomb[2]), LocalDate.parse(tomb[3]), tomb[4]);
                beolvasott.add(egyetel);
                System.out.println(sor);
            }

        } catch (IOException e) {
            System.out.println("Hiba a fájl olvasásakor: " + e.getMessage());
        }
        beolvasott.stream().forEach(System.out::println );
        System.out.println(args[0]);
    }
}
