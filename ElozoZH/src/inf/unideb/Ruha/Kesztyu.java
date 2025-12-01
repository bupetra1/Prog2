package inf.unideb.Ruha;

public class Kesztyu extends Ruha implements Markas{
    private boolean tiszta;
    private double vastagsag;
    private String Marka;

    public Kesztyu(int meret, double vastagsag, String marka) {
        super(meret);
        this.vastagsag = vastagsag;
        Marka = marka;
        this.tiszta = true;
    }

    @Override
    public String getMarka() {
        return this.Marka;
    }

    public void setMarka(String marka) {
        Marka = marka;
    }
    public boolean isTiszta(){
        return this.tiszta;
    }

    public double getVastagsag() {
        return vastagsag;
    }

    @Override
    public String valamiMarks(String marka) {
        return "";
    }

    @Override
    public void hord() {
        this.tiszta = false;
        if (vastagsag > 1) {
            this.vastagsag = vastagsag - 1;
        }

    }

    @Override
    public void megmos() {
        this.tiszta = true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Kesztyu{");
        sb.append("tiszta=").append(tiszta);
        sb.append(", vastagsag=").append(vastagsag);
        sb.append(", Marka='").append(Marka).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
