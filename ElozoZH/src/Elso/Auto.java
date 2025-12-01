package Elso;

import java.util.Objects;

public class Auto {
    private String rendszam;
    private String marka;
    private String tipus;
    private int evjarat;
    private String tulajdonosNeve;

    /**
     * Létrehoz egy új {@code Auto} objektumot a megadott adatokkal.
     *
     * @param rendszam       az autó rendszáma
     * @param marka          az autó márkája
     * @param tipus          az autó típusa
     * @param evjarat        az autó gyártási éve
     * @param tulajdonosNeve az autó tulajdonosának neve
     */

    public Auto(String rendszam, String marka, String tipus, int evjarat, String tulajdonosNeve) {
        this.rendszam = rendszam;
        this.marka = marka;
        this.tipus = tipus;
        this.evjarat = evjarat;
        this.tulajdonosNeve = tulajdonosNeve;
    }
    /**
     * Visszaadja az autó rendszámát.
     *
     * @return az autó rendszáma
     */
    public String getRendszam() {
        return rendszam;
    }

    public String getMarka() {
        return marka;
    }

    public String getTipus() {
        return tipus;
    }

    public int getEvjarat() {
        return evjarat;
    }

    public String getTulajdonosNeve() {
        return tulajdonosNeve;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Auto{");
        sb.append("rendszam='").append(rendszam).append('\'');
        sb.append(", marka='").append(marka).append('\'');
        sb.append(", tipus='").append(tipus).append('\'');
        sb.append(", evjarat=").append(evjarat);
        sb.append(", tulajdonosNeve='").append(tulajdonosNeve).append('\'');
        sb.append('}');
        return sb.toString();
    }
    /**
     * Meghatározza, hogy ez az autó objektum logikailag egyenlő-e
     * a megadott objektummal. Két autó akkor számít egyenlőnek,
     * ha a rendszámuk és a tulajdonosuk neve megegyezik.
     *
     * @param o az összehasonlítandó objektum
     * @return {@code true}, ha a két objektum egyenlő, egyébként {@code false}
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return Objects.equals(rendszam, auto.rendszam) && Objects.equals(tulajdonosNeve, auto.tulajdonosNeve);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rendszam, tulajdonosNeve);
    }
}
