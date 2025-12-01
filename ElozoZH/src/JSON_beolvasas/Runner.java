package JSON_beolvasas;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Runner {
    static void main() throws IOException {
        // premium beolvasas
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        JsonNode root = mapper.readTree(new File("C:/Users/Petra/IdeaProjects/ElozoZH/src/cipo.json"));
        JsonNode arr = root.path("adatok");

        ArrayList<Cipo> cipok = mapper.readValue(
                arr.traverse(mapper),
                new TypeReference<ArrayList<Cipo>>() { }
        );

        //cipok.stream().forEach(System.out::println);
        //Fekete színű
        cipok.stream().filter(c -> c.getSzin().equals("fekete")).forEach(System.out::println);
        //Legfeljebb 30-as
        cipok.stream().filter(c -> c.getMeret()<=30).forEach(System.out::println);
        //Fekete és legfeljebb 30
        cipok.stream().filter(c -> c.getSzin().equals("fekete")).filter(c->c.getMeret()<=30).forEach(System.out::println);
        System.out.println(cipok.stream().min(new Comparator<Cipo>()
        {
            @Override
            public int compare(Cipo o1, Cipo o2) {
                int m1 = o1.getMeret();
                int m2 = o2.getMeret();
                return m1 - m2;
            }
        }).get().getModellszam());

        Map<String, List<Cipo>> evszakMap = cipok.stream()
                .collect(Collectors.groupingBy(Cipo::getEvszak));

        evszakMap.forEach((evszak, adatok) -> {
            System.out.println(evszak + " -> " + adatok);
        });

    }
}
