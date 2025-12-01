package IO_muveletek;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Buza Petra
 * @since 2025
 */
public class Etel {
    private String nev;
    private String vonalkod;
    private double ar;
    private LocalDate LejaratDatuma;
    private String etelTipus;

    /**
     *
     * @param nev - az étel neve
     * @param vonalkod - az étel vonalkódja
     * @param ar - az étel ára
     * @param lejaratDatuma - az étel lejárati dátuma
     * @param etelTipus - az étel típusa
     */
    public Etel(String nev, String vonalkod, double ar, LocalDate lejaratDatuma, String etelTipus) {
        this.nev = nev;
        this.vonalkod = vonalkod;
        this.ar = ar;
        LejaratDatuma = lejaratDatuma;
        this.etelTipus = etelTipus;
    }

    /**
     * Vissza adja az étel példány nevét.
     * @return nev
     */
    public String getNev() {
        return nev;
    }

    /**
     * Segítségével módosíthatjuk a változó értékét.
     * @param nev
     */
    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getVonalkod() {
        return vonalkod;
    }

    public void setVonalkod(String vonalkod) {
        this.vonalkod = vonalkod;
    }

    public double getAr() {
        return ar;
    }

    public void setAr(double ar) {
        this.ar = ar;
    }

    public LocalDate getLejaratDatuma() {
        return LejaratDatuma;
    }

    public void setLejaratDatuma(LocalDate lejaratDatuma) {
        LejaratDatuma = lejaratDatuma;
    }

    public String getEtelTipus() {
        return etelTipus;
    }

    public void setEtelTipus(String etelTipus) {
        this.etelTipus = etelTipus;
    }

    /**
     * Két étel egyenlő, ha a vonalkódjuk megegyezik
     * @param o   the reference object with which to compare.
     * @return igaz/hamis érték
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Etel etel = (Etel) o;
        return Objects.equals(vonalkod, etel.vonalkod);
    }

    /**
     * @return a vonalkód hashCode-ját adja vissza
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(vonalkod);
    }

    /**
     * Az étel objektum kiírására szolgál.
     * @return visszaadja stringként a példány adatait.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Etel{");
        sb.append("nev='").append(nev).append('\'');
        sb.append("; vonalkod='").append(vonalkod).append('\'');
        sb.append("; ar=").append(ar);
        sb.append("; LejaratDatuma=").append(LejaratDatuma);
        sb.append("; etelTipus='").append(etelTipus).append('\'');
        sb.append('}');
        return sb.toString();
    }
    public String toCSV() {
        return nev + ";" + vonalkod + ";" + ar + ";" + LejaratDatuma + ";" + etelTipus;
    }

}
