package otodik;

import java.util.Objects;

public class Telepules {
    private String nev;
    private String iranyitoszam;
    private Megye megye;

    public Telepules(String nev, String iranyitoszam, Megye megye) {
        this.nev = nev;
        this.iranyitoszam = iranyitoszam;
        this.megye = megye;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getIranyitoszam() {
        return iranyitoszam;
    }

    public void setIranyitoszam(String iranyitoszam) {
        this.iranyitoszam = iranyitoszam;
    }

    public Megye getMegye() {
        return megye;
    }

    public void setMegye(Megye megye) {
        this.megye = megye;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Telepules{");
        sb.append("nev='").append(nev).append('\'');
        sb.append(", iranyitoszam='").append(iranyitoszam).append('\'');
        sb.append(", megye=").append(megye);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Telepules telepules = (Telepules) o;
        return Objects.equals(nev, telepules.nev);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nev);
    }
}
