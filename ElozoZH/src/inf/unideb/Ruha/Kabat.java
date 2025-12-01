package inf.unideb.Ruha;

public class Kabat extends Ruha{
    private boolean tiszta;
    private String stilus;
    public Kabat(int meret, String stilus) {
        super(meret);
        this.stilus = stilus;
        this.tiszta = true;
    }
    public boolean isTiszta(){
        return tiszta = true;
    }
    @Override
    public void hord() {
        this.tiszta = false;
    }

    @Override
    public void megmos() {
        this.tiszta = true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Kabat{");
        sb.append("tiszta=").append(tiszta);
        sb.append(", stilus='").append(stilus).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
