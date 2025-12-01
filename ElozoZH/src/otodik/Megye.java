package otodik;

public class Megye {
    private String nev;
    private String rovidNev;

    public Megye(String rovidNev, String nev) {
        this.rovidNev = rovidNev;
        this.nev = nev;
    }

    public String getNev() {
        return nev;
    }

    public String getRovidNev() {
        return rovidNev;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Megye{");
        sb.append("nev='").append(nev).append('\'');
        sb.append(", rovidNev='").append(rovidNev).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
