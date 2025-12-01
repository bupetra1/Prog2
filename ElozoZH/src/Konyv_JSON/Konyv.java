package Konyv_JSON;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JacksonCollectors;
@JsonPropertyOrder({"cim", "szerzo", "kiadasDatuma","oldalszam", "kiado", "ISBN"})
public class Konyv {
    private String cim;
    private String szerzo;
    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDate kiadasDatuma;
    private int oldalszam;
    private String kiado;
    private int ISBN;

    public Konyv(String cim, String szerzo, LocalDate kiadasDatuma, int oldalszam, String kiado, int ISBN) {
        this.cim = cim;
        this.szerzo = szerzo;
        this.kiadasDatuma = kiadasDatuma;
        this.oldalszam = oldalszam;
        this.kiado = kiado;
        this.ISBN = ISBN;
    }

    public Konyv() {
    }

    @JsonProperty("cim")
    public String getCim() {
        return cim;
    }
    @JsonProperty("szerzo")
    public String getSzerzo() {
        return szerzo;
    }
    @JsonProperty("kiadasDatuma")
    public LocalDate getKiadasDatuma() {
        return kiadasDatuma;
    }
    @JsonProperty("kiado")
    public String getKiado() {
        return kiado;
    }
    @JsonProperty("ISBN")
    public int getISBN() {
        return ISBN;
    }
    @JsonProperty("oldalszam")
    public int getOldalszam() {
        return oldalszam;
    }
    @JsonProperty("ISBN")
    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Konyv{");
        sb.append("cim='").append(cim).append('\'');
        sb.append(", szerzo='").append(szerzo).append('\'');
        sb.append(", kiadasDatuma=").append(kiadasDatuma);
        sb.append(", oldalszam=").append(oldalszam);
        sb.append(", kiado='").append(kiado).append('\'');
        sb.append(", ISBN='").append(ISBN).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
