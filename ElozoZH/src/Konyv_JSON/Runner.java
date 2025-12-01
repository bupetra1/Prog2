package Konyv_JSON;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Runner {

    public static void main() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        JsonNode root = mapper.readTree(new File("C:/Users/Petra/IdeaProjects/ElozoZH/src/konyv.json"));
        JsonNode arr = root.path("adatok");
        ArrayList<Konyv> konyvek = mapper.readValue(arr.traverse(mapper), new TypeReference<ArrayList<Konyv>>(){});
        //konyvek.stream().forEach(System.out::println);
        System.out.println("500 oldal alatti könyvek: ");
        konyvek.stream().filter(k -> k.getOldalszam()<500).forEach(System.out::println);

        double atlag = konyvek.stream().mapToInt(Konyv::getISBN).average().getAsDouble();
        System.out.println("ISBN kódok átlaga " + atlag);

        Map<String, List<String>> rendezett = konyvek.stream()
                .collect(Collectors.groupingBy(
                        Konyv::getSzerzo,
                        Collectors.mapping(Konyv::toString, Collectors.toList())
                ));
        rendezett.forEach((szerzo, szerzemeny)-> {
            System.out.println(szerzo + " -> " + szerzemeny);
        });

    }
}
