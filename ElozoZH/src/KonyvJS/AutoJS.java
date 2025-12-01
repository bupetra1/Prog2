package KonyvJS;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

public class AutoJS {
    /*
      "cim": "Az elveszett feher konyv",
      "szerzo": "Cassandra Clare",
      "kiadasDatuma": "2021.05.19",
      "oldalszam": "460",
      "kiado": "Konyvmolykepzo Kiado",
      "ISBN": "9789631"
     */
    private String cim;
    private String szerzo;
    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDate kiadasDatuma;
    private int oldalszam;
    private String kiado;
    private int ISBN;

    @JsonPropertyOrder({"cim, szerzo, kiadasDatuma, oldalszam, kiado, ISBN"})
    public AutoJS(String cim, String szerzo, LocalDate kiadasDatuma, int oldalszam, String kiado, int ISBN) {
        this.cim = cim;
        this.szerzo = szerzo;
        this.kiadasDatuma = kiadasDatuma;
        this.oldalszam = oldalszam;
        this.kiado = kiado;
        this.ISBN = ISBN;
    }

    public AutoJS() {
    }

    @JsonProperty("cim")
    public String getCim() {
        return cim;
    }
    @JsonProperty("cim")
    public void setCim(String cim) {
        this.cim = cim;
    }
    @JsonProperty("szerzo")
    public String getSzerzo() {
        return szerzo;
    }
    @JsonProperty("szerzo")
    public void setSzerzo(String szerzo) {
        this.szerzo = szerzo;
    }
    @JsonProperty("kiadasDatuma")
    public LocalDate getKiadasDatuma() {
        return kiadasDatuma;
    }
    @JsonProperty("kiadasDatuma")
    public void setKiadasDatuma(LocalDate kiadasDatuma) {
        this.kiadasDatuma = kiadasDatuma;
    }
    @JsonProperty("oldalszam")
    public int getOldalszam() {
        return oldalszam;
    }
    @JsonProperty("oldalszam")
    public void setOldalszam(int oldalszam) {
        this.oldalszam = oldalszam;
    }
    @JsonProperty("kiado")
    public String getKiado() {
        return kiado;
    }
    @JsonProperty("kiado")
    public void setKiado(String kiado) {
        this.kiado = kiado;
    }
    @JsonProperty("ISBN")
    public int getISBN() {
        return ISBN;
    }
    @JsonProperty("ISBN")
    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AutoJS{");
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
