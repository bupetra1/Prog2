package JSON_beolvasas;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;
@JsonPropertyOrder({"modellszam", "meret","szin","evszak","gyartasDatuma"})
public class Cipo {
    private String modellszam;
    private Integer meret;
    private String szin;
    private String evszak;
    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDate gyartasDatuma;

    public Cipo(String modellszam, Integer meret, String szin, String evszak, LocalDate gyartasDatuma) {
        this.modellszam = modellszam;
        this.meret = meret;
        this.szin = szin;
        this.evszak = evszak;
        this.gyartasDatuma = gyartasDatuma;
    }
    public Cipo(){}
    //@JsonProperty("modellszam")
    public String getModellszam() {
        return modellszam;
    }
    //@JsonProperty("meret")
    public Integer getMeret() {
        return meret;
    }
    //@JsonProperty("szin")
    public String getSzin() {
        return szin;
    }
    //@JsonProperty("evszak")
    public String getEvszak() {
        return evszak;
    }
    //@JsonProperty("gyartasDatuma")
    public LocalDate getGyartasDatuma() {
        return gyartasDatuma;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cipo{");
        sb.append("modellszam='").append(modellszam).append('\'');
        sb.append(", meret=").append(meret);
        sb.append(", szin='").append(szin).append('\'');
        sb.append(", evszak='").append(evszak).append('\'');
        sb.append(", gyartasDatuma=").append(gyartasDatuma);
        sb.append('}');
        return sb.toString();
    }
}
