import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RosterExample {

    public static void main(String[] args) {
        // "roster" – a példabeli Person lista
        List<Person> roster = new ArrayList<>();
        roster.add(new Person("Anna", LocalDate.of(2000, 5, 10), Person.Sex.FEMALE, "anna@example.com"));
        roster.add(new Person("Béla", LocalDate.of(1995, 3, 20), Person.Sex.MALE, "bela@example.com"));
        roster.add(new Person("Csaba", LocalDate.of(1988, 11, 2), Person.Sex.MALE, "csaba@example.com"));
        roster.add(new Person("Dóra", LocalDate.of(2003, 1, 15), Person.Sex.FEMALE, "dora@example.com"));

        // 1) forEach – minden tag neve
        System.out.println("--- összes név forEach-csel ---");
        roster.stream()
                .forEach(p -> System.out.println(p.getName()));
        roster.stream().forEach(System.out::println);

        // 2) filter + forEach – csak a férfiak nevei
        System.out.println("\n--- férfiak nevei (filter + forEach) ---");
        roster.stream()
                .filter(p -> p.getGender() == Person.Sex.MALE)
                .forEach(p -> System.out.println(p.getName()));

        // 3) mapToInt + average – férfiak átlagéletkora
        System.out.println("\n--- férfiak átlagéletkora (mapToInt + average) ---");
        double averageAgeOfMales = roster.stream()
                .filter(p -> p.getGender() == Person.Sex.MALE)
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);
        System.out.println("Átlagéletkor (férfiak): " + averageAgeOfMales);

        // 4) sum – mindenki életkorának összege mapToInt + sum
        System.out.println("\n--- összes életkor (sum) ---");
        int totalAge = roster.stream()
                .mapToInt(Person::getAge)
                .sum();
        System.out.println("Összes életkor (sum): " + totalAge);

        // 5) reduce – ugyanaz, de reduce-szal (általános reduction)
        System.out.println("\n--- összes életkor (reduce) ---");
        Integer totalAgeReduce = roster.stream()
                .map(Person::getAge)
                .reduce(0, (a, b) -> a + b);
        System.out.println("Összes életkor (reduce): " + totalAgeReduce);

        // 6) collect + Collectors.toList – férfiak neveinek listája
        System.out.println("\n--- férfiak nevei listában (collect(Collectors.toList())) ---");
        List<String> namesOfMaleMembers = roster.stream()
                .filter(p -> p.getGender() == Person.Sex.MALE)
                .map(Person::getName)
                .collect(Collectors.toList());
        namesOfMaleMembers.forEach(System.out::println);

        // 7) groupingBy – csoportosítás nem szerint: Map<Sex, List<Person>>
        System.out.println("\n--- csoportosítás nem szerint (groupingBy) ---");
        Map<Person.Sex, List<Person>> byGender = roster.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        byGender.forEach((gender, people) -> {
            System.out.println(gender + " -> " + people);
        });

        // 8) groupingBy + mapping – Map<Sex, List<String>> (csak a nevek)
        System.out.println("\n--- nevek csoportosítva nem szerint (groupingBy + mapping) ---");
        Map<Person.Sex, List<String>> namesByGender = roster.stream()
                .collect(Collectors.groupingBy(
                        Person::getGender,
                        Collectors.mapping(Person::getName, Collectors.toList())
                ));
        namesByGender.forEach((gender, names) -> {
            System.out.println(gender + " -> " + names);
        });

        // 9) groupingBy + reducing – életkorok összege nemenént: Map<Sex, Integer>
        System.out.println("\n--- összes életkor nemenként (groupingBy + reducing) ---");
        Map<Person.Sex, Integer> totalAgeByGender = roster.stream()
                .collect(Collectors.groupingBy(
                        Person::getGender,
                        Collectors.reducing(
                                0,
                                Person::getAge,
                                Integer::sum
                        )
                ));
        totalAgeByGender.forEach((gender, sumAge) -> {
            System.out.println(gender + " -> " + sumAge);
        });

        // 10) groupingBy + averagingInt – átlagéletkor nemenként: Map<Sex, Double>
        System.out.println("\n--- átlagéletkor nemenként (groupingBy + averagingInt) ---");
        Map<Person.Sex, Double> averageAgeByGender = roster.stream()
                .collect(Collectors.groupingBy(
                        Person::getGender,
                        Collectors.averagingInt(Person::getAge)
                ));
        averageAgeByGender.forEach((gender, avgAge) -> {
            System.out.println(gender + " -> " + avgAge);
        });
    }
}

// A diáknak megfelelő Person osztály + Sex enum
class Person {

    public enum Sex { MALE, FEMALE }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        // Egyszerű életkor-számítás: év különbség (nem napra pontos, de példához elég)
        return LocalDate.now().getYear() - birthday.getYear();
    }

    public String getName() {
        return name;
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
