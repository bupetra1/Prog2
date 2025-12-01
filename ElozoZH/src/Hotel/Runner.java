package Hotel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Runner {
    static void main(String[] args) throws FileNotFoundException {
        ArrayList<Hotel> listaHotel = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(args[0])))
        {
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String [] parts = line.split(";");
                listaHotel.add(new Hotel(parts[0],
                        Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]),
                        Integer.parseInt(parts[3])));
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File hiba");
        }
        HashMap<String, Hotel> hotelHashMap = new HashMap<>();
        for (Hotel h : listaHotel) {
            hotelHashMap.put(h.getHotelName(), h);
        }
        hotelHashMap.forEach((h,kollekcio)-> kollekcio.getHotelName());
        //System.out.println(hotelHashMap);
        List<Hotel> elerhetoszoba = findAvailableHotels(hotelHashMap);
        elerhetoszoba.sort(Comparator.comparing(Hotel::getAvaibleRooms).thenComparing(Hotel::getHotelName));
        //elerhetoszoba.forEach(System.out::println);

    }

    public static List<Hotel> findAvailableHotels(HashMap<String, Hotel> mapocska){
        List<Hotel> listaHotelek = new ArrayList<>();
        for (Hotel h : mapocska.values()){
            if (h.getAvaibleRooms()>0){
                listaHotelek.add(h);
            }
        }
        return listaHotelek;
    }
}
