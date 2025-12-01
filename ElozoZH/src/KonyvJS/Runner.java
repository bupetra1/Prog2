package KonyvJS;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Runner {
    static void main() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        JsonNode root = mapper.readTree(new File("C:/Users/Petra/IdeaProjects/ElozoZH/konyv.json"));
        JsonNode arr = root.path("adatok");
        ArrayList<AutoJS> lista = mapper.readValue(arr.traverse(), new TypeReference<ArrayList<AutoJS>>() {
        });
        //lista.stream().forEach(System.out::println);
        lista.stream().filter(k -> k.getOldalszam()<500).forEach(System.out::println);
        System.out.println("Az ISBN kódok átlaga: " + lista.stream().mapToInt(AutoJS::getISBN).average().getAsDouble());
        Map<String, List<AutoJS>> listMap = lista.stream().collect(Collectors.groupingBy(AutoJS::getSzerzo, Collectors.toList()));
        listMap.forEach((k, kollekcio)-> System.out.println(k + "->" + kollekcio));

        Map<String, Optional<AutoJS>> mmin = lista.stream().collect(Collectors.groupingBy(AutoJS::getSzerzo, Collectors.minBy(Comparator.comparing(AutoJS::getISBN))));
        mmin.forEach((k, i) -> System.out.println(k + " " + i.get().getISBN()));
    }
}
