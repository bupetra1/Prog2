package AutoJSON;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

@JsonPropertyOrder({"rendszam", "tipus","marka","gyartasDatuma","teljesitmeny"})
public class Auto {
    private String rendszam;
    private String tipus;
    private String marka;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate gyartasDatuma;
    private int teljesitmeny;

    public Auto(String rendszam, String tipus, String marka, LocalDate gyartasDatuma, int teljesitmeny) {
        this.rendszam = rendszam;
        this.tipus = tipus;
        this.marka = marka;
        this.gyartasDatuma = gyartasDatuma;
        this.teljesitmeny = teljesitmeny;
    }
    public Auto(){}
    @JsonProperty("rendszam")
    public String getRendszam() {
        return rendszam;
    }
    @JsonProperty("rendszam")
    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }
    @JsonProperty("tipus")
    public String getTipus() {
        return tipus;
    }
    @JsonProperty("tipus")
    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
    @JsonProperty("marka")
    public String getMarka() {
        return marka;
    }
    @JsonProperty("marka")
    public void setMarka(String marka) {
        this.marka = marka;
    }
    @JsonProperty("gyartasDatuma")
    public LocalDate getGyartasDatuma() {
        return gyartasDatuma;
    }
    @JsonProperty("gyartasDatuma")
    public void setGyartasDatuma(LocalDate gyartasDatuma) {
        this.gyartasDatuma = gyartasDatuma;
    }
    @JsonProperty("teljesitmeny")
    public int getTeljesitmeny() {
        return teljesitmeny;
    }
    @JsonProperty("teljesitmeny")
    public void setTeljesitmeny(int teljesitmeny) {
        this.teljesitmeny = teljesitmeny;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Auto{");
        sb.append("rendszam='").append(rendszam).append('\'');
        sb.append(", tipus='").append(tipus).append('\'');
        sb.append(", marka='").append(marka).append('\'');
        sb.append(", gyartasDatuma=").append(gyartasDatuma);
        sb.append(", teljesitmeny=").append(teljesitmeny);
        sb.append('}');
        return sb.toString();
    }
}

