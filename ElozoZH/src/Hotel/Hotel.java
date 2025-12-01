package Hotel;

import java.util.Objects;

/**
 * @author Buza Petra
 * @since 2025
 */
public class Hotel {
    private String hotelName;
    private int rooms;
    private int avaibleRooms;
    private int bookedRooms;

    /**
     *
     * @param hotelName - A szálloda neve
     * @param rooms - A szállodában található szobák száma
     * @param avaibleRooms - Az elérhető szobák száma
     * @param bookedRooms - Az eddig lefoglalt szobák száma
     */
    public Hotel(String hotelName, int rooms, int avaibleRooms, int bookedRooms) {
        this.hotelName = hotelName;
        this.rooms = rooms;
        this.avaibleRooms = avaibleRooms;
        this.bookedRooms = bookedRooms;
    }

    /**
     * Ellenőrzi, hogy van-e elérhető szoba a szállodában.
     * @return true, ha van elérhető szoba, minden más esetben false
     */
    public boolean isRoomAvaible(){
        if (avaibleRooms>0) {
            return true;
        }
        else{
            return false;
        }
    }

    public int getBookedRooms() {
        return bookedRooms;
    }

    public void setBookedRooms(int bookedRooms) {
        this.bookedRooms = bookedRooms;
    }

    public int getAvaibleRooms() {
        return avaibleRooms;
    }

    public void setAvaibleRooms(int avaibleRooms) {
        this.avaibleRooms = avaibleRooms;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    /**
     * Szállodák összehasonlítása
     * @param o   the reference object with which to compare.
     * @return true, ha a hotel neve és a szobáinak száma megegyezik.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return rooms == hotel.rooms && Objects.equals(hotelName, hotel.hotelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelName, rooms);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hotel{");
        sb.append("hotelName='").append(hotelName).append('\'');
        sb.append(", rooms=").append(rooms);
        sb.append(", avaibleRooms=").append(avaibleRooms);
        sb.append(", bookedRooms=").append(bookedRooms);
        sb.append('}');
        return sb.toString();
    }
}
