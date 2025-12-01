package etel.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Runner {
    static void main() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        JsonNode root = mapper.readTree(new File("C:/Users/Petra/IdeaProjects/ElozoZH/src/etel.json"));
        JsonNode arr = root.path("adatok");

        ArrayList<Etel> etelek = mapper.readValue(arr.traverse(), new TypeReference<ArrayList<Etel>>() {
        });
        etelek.stream().forEach(System.out::println);
    }
}
