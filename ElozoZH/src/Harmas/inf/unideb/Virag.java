package Harmas.inf.unideb;

public abstract class Virag implements Noveny {
    private static int letrehozottViragokSzama = 0;
    private double viztartalom;
    private double energia;

    public Virag(double viztartalom, double energia) {
        this.viztartalom = viztartalom;
        this.energia = energia;
        letrehozottViragokSzama += 1;
    }

    public static int getLetrehozottViragokSzama() {
        return letrehozottViragokSzama;
    }

    public double getViztartalom() {
        return viztartalom;
    }

    public double getEnergia() {
        return energia;
    }

    public void setViztartalom(double viztartalom) {
        this.viztartalom = viztartalom;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public abstract void fotoszintetizal(boolean fotoszintetizal);

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Virag{");
        sb.append("viztartalom=").append(viztartalom);
        sb.append(", energia=").append(energia);
        sb.append('}');
        return sb.toString();
    }
}
