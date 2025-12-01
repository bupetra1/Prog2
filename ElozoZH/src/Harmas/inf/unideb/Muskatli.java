package Harmas.inf.unideb;

public class Muskatli extends Virag{
    private boolean futoTipusu;
    private int terjedesMerteke;

    public Muskatli(double viztartalom, double energia, boolean futoTipusu) {
        super(viztartalom, energia);
        this.futoTipusu = futoTipusu;
        this.terjedesMerteke = 1;
    }
    public Muskatli(double viztartalom, boolean futoTipusu){
        this(viztartalom,100,futoTipusu);
    }

    @Override
    public void novekszik() {
        if(isFutoTipusu()){
            this.terjedesMerteke += 2;
        }
        else {
            this.terjedesMerteke += 1;
        }
    }
    public boolean isFutoTipusu(){
        return this.futoTipusu;
    }
    public int terjedesMerteke(){
        return terjedesMerteke;
    };

    @Override
    public void fotoszintetizal(boolean fotoszintetizal) {
        if (fotoszintetizal) {
            this.setEnergia(getEnergia()+1);
            this.setViztartalom(getViztartalom()-1);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Muskatli{");
        sb.append("futoTipusu=").append(futoTipusu);
        sb.append(", terjedesMerteke=").append(terjedesMerteke);
        sb.append(", viztartalom=").append(getViztartalom());
        sb.append(", energia=").append(getEnergia());
        sb.append('}');
        return sb.toString();
    }
}
