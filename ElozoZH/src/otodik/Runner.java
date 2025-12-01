package otodik;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Runner {
    static void main() {
        ArrayList<Telepules> telepulesek = new ArrayList<>();

        telepulesek.add(new Telepules("Miskolc", "3597",
                new Megye("BAZ", "Borsod-Abaúj-Zemplén")));
        telepulesek.add(new Telepules("Nyíregyháza", "4400",
               new Megye("SzSzB","Szabolcs-Szatmár-Bereg")));

        telepulesek.add(new Telepules("Debrecen", "4024",
                new Megye("HB", "Hajdú-Bihar")));

        telepulesek.add(new Telepules("Budapest", "1011",
                new Megye("HB", "Hajdú-Bihar")));

        telepulesek.add(new Telepules("Eger", "3300",
                new Megye("HE", "Heves")));

        telepulesek.add(new Telepules("Sopron", "9400",
                new Megye("GS", "Győr-Moson-Sopron")));

        telepulesek.add(new Telepules("Zalaegerszeg", "8900",
                new Megye("ZA", "Zala")));

        telepulesek.add(new Telepules("Veszprém", "8200",
                new Megye("VE", "Veszprém")));

        telepulesek.add(new Telepules("Szeged", "6720",
                new Megye("CS", "Csongrád-Csanád")));

        telepulesek.add(new Telepules("Kecskemét", "6000",
                new Megye("BK", "Bács-Kiskun")));

        TreeMap<String, List<Telepules>> telepulesTreemap = new TreeMap<>();

        for (Telepules e : telepulesek) {
            // Ha még nincs ilyen kulcs, hozunk létre új listát
            telepulesTreemap.putIfAbsent(e.getMegye().getNev(), new ArrayList<>());

            // A meglévő listához adjuk hozzá az aktuális települést
            telepulesTreemap.get(e.getMegye().getNev()).add(e);
        }
        for (Map.Entry<String, List<Telepules>> entry : telepulesTreemap.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }




    }
}
