package AutoJSON;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Runner {
    static void main() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        JsonNode root = mapper.readTree(new File("C:/Users/Petra/IdeaProjects/ElozoZH/src/auto.json"));
        JsonNode arr = root.path("adatok");
        ArrayList<Auto> autok = mapper.readValue(arr.traverse(), new TypeReference<ArrayList<Auto>>() {
        });
        autok.stream().forEach(System.out::println);
        //Összes autó rendszáma
        autok.stream().forEach(k -> System.out.print(k.getRendszam() + ", "));
        //Renault márkájú autók
        autok.stream().filter(k -> (k.getMarka().equals("Renault"))).forEach(System.out::println);
        //2010 előtti autó darabszáma
        System.out.println(autok.stream().filter(k -> k.getGyartasDatuma().isAfter(LocalDate.of(2010,1,1))).count());
        //Toyota típusok
        List<String> toyotak = autok.stream()
                .filter(k -> k.getMarka().equals("Toyota"))
                .map(Auto::getTipus)
                .collect(Collectors.toList());
        System.out.println(toyotak);
        //Teljesítmények összege
        int teljesitmenyek_osszege = autok.stream().mapToInt(Auto::getTeljesitmeny).sum();
        System.out.println(teljesitmenyek_osszege);
        //Reduce-al
        int to = autok.stream().map(Auto::getTeljesitmeny).reduce(0,(a,b) ->a+b);
        System.out.println(to);
        //Legnagyobb teljesitmeny
        autok.stream().max((a, b)-> Integer.compare(a.getTeljesitmeny(),b.getTeljesitmeny())).map(Auto::getTipus).ifPresent(System.out::println);
        //Autok csoportosítása márka szerint
        Map<String,List<String>> markaszerint = autok.stream()
                .collect(Collectors.groupingBy
                        (Auto::getMarka, Collectors.mapping(Auto::toString, Collectors.toList())));
        markaszerint.forEach((marka, kollekcio)-> System.out.println(marka + " -> "+kollekcio));
        //Rendezett autok márka szerint
        autok.stream().sorted(new Comparator<Auto>() {
            @Override
            public int compare(Auto o1, Auto o2) {
                String mar1 = o1.getMarka();
                String mar2 = o2.getMarka();
                return mar1.compareTo(mar2);
            }
        }).forEach(System.out::println);
    }
}
