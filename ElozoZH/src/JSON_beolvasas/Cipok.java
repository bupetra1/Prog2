package JSON_beolvasas;

import java.util.ArrayList;

public class Cipok {
    private ArrayList<Cipo> adatok = new ArrayList<>();

    public Cipok() {
    }

    public ArrayList<Cipo> getAdatok() {
        return adatok;
    }
    public void addCipo(Cipo c){
        this.adatok.add(c);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cipok{");
        sb.append("adatok=").append(adatok);
        sb.append('}');
        return sb.toString();
    }
}
