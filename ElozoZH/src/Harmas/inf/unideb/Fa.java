package Harmas.inf.unideb;

public class Fa implements Noveny{
    private String termes;
    private boolean orokzold;
    private  boolean fotoszintetizal;
    private  int NOVEKEDES_MERTEKE = 15;
    private double magassag;

    public Fa(String termes, boolean orokzold) {
        this.termes = termes;
        this.orokzold = orokzold;
    }

    public String getTermes() {
        return termes;
    }
    public boolean IsOrokzold(){
        return this.orokzold;
    }
    public boolean IsFotoszintetizal(){
        return this.fotoszintetizal;
    }
    @Override
    public void novekszik() {
        if (IsOrokzold()) {
            this.magassag = magassag + NOVEKEDES_MERTEKE;
        }
        else{
            this.magassag = magassag + (NOVEKEDES_MERTEKE*0.75);
        }

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fa{");
        sb.append("termes='").append(termes).append('\'');
        sb.append(", orokzold=").append(orokzold);
        sb.append(", fotoszintetizal=").append(fotoszintetizal);
        sb.append(", NOVEKEDES_MERTEKE=").append(NOVEKEDES_MERTEKE);
        sb.append(", magassag=").append(magassag);
        sb.append('}');
        return sb.toString();
    }
}
