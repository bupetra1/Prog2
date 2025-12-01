package etel.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

@JsonPropertyOrder({"nev","vonalokod","ar","lejaratDatuma","etelTipus"})
public class Etel {
    private String nev;
    private String vonalokod;
    private double ar;
    @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate lejaratDatuma;
    private String etelTipus;

    public Etel(){}

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getVonalokod() {
        return vonalokod;
    }

    public void setVonalokod(String vonalkod) {
        this.vonalokod = vonalkod;
    }

    public double getAr() {
        return ar;
    }

    public void setAr(double ar) {
        this.ar = ar;
    }

    public LocalDate getLejaratDatuma() {
        return lejaratDatuma;
    }

    public void setLejaratDatuma(LocalDate lejaratDatuma) {
        this.lejaratDatuma = lejaratDatuma;
    }

    public String getEtelTipus() {
        return etelTipus;
    }

    public void setEtelTipus(String etelTipus) {
        this.etelTipus = etelTipus;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Etel{");
        sb.append("nev='").append(nev).append('\'');
        sb.append(", vonalkod='").append(vonalokod).append('\'');
        sb.append(", ar=").append(ar);
        sb.append(", lejaratDatuma=").append(lejaratDatuma);
        sb.append(", etelTipus='").append(etelTipus).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
