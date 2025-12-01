package Harmas.inf.unideb;

public class Runner {
    static void main() {
        Muskatli m1 = new Muskatli(100,true);
        System.out.println(m1.toString());
        Fa f1 = new Fa("Makk",true);
        System.out.println(f1.toString());
        Hovirag h1 = new Hovirag(100,100,2);
        System.out.println(h1.toString());
        h1.novekszik();
        System.out.println(h1.toString());
        h1.fotoszintetizal(true);
        System.out.println(h1.toString());
        System.out.println(Virag.getLetrehozottViragokSzama());
    }
}
