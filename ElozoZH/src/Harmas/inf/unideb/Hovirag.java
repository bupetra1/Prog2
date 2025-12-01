package Harmas.inf.unideb;

public class Hovirag extends Virag implements Noveny {
    private int sziromMeret;

    public Hovirag(double viztartalom, double energia, int sziromMeret) {
        super(viztartalom, energia);
        this.sziromMeret = sziromMeret;
    }

    public int getSziromMeret() {
        return sziromMeret;
    }

    @Override
    public void fotoszintetizal(boolean fotoszintetizal) {
        this.setEnergia(getEnergia()+3);
        this.setViztartalom(getViztartalom()-3);
    }

    @Override
    public void novekszik() {
        this.sziromMeret += 1;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hovirag{");
        sb.append("sziromMeret=").append(sziromMeret);
        sb.append("viztartalom=").append(getViztartalom());
        sb.append("energia=").append(getEnergia());
        sb.append('}');
        return sb.toString();
    }
}
