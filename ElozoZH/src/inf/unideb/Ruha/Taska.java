package inf.unideb.Ruha;

public class Taska implements Markas {
    public String marka;
    public String anyag;

    public Taska(String marka, String anyag) {
        this.marka = marka;
        this.anyag = anyag;
    }

    public Taska(String anyag) {
        this(Markas.NEVETELEN_MARKA,anyag);
    }

    public String getAnyag() {
        return anyag;
    }

    @Override
    public String getMarka() {
        return this.marka;
    }

    @Override
    public String valamiMarks(String marka) {
        return "";
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Taska{");
        sb.append("marka='").append(marka).append('\'');
        sb.append(", anyag='").append(anyag).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
