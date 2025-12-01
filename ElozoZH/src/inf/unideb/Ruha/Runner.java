package inf.unideb.Ruha;

public class Runner {
    static void main() {
        Taska taska1 = new Taska("pamut");
        System.out.println(taska1.toString());
        Kesztyu kesztyu1 = new Kesztyu(10,25.1,"Nike");
        System.out.println(kesztyu1.toString());

        System.out.println(Ruha.getLetrehozottRuhakSzama());
        Kabat kabat1 = new Kabat(58,"Hosszított");
        System.out.println(kabat1.toString());
        kabat1.hord();
        System.out.println(kabat1.toString());
        kabat1.megmos();
        System.out.println(kabat1.toString());
        System.out.println(kesztyu1.getVastagsag());
    }
}
