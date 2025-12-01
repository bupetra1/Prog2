package inf.unideb.Ruha;

public abstract class Ruha {
    private static int letrehozottRuhakSzama;
    private int meret;

    protected Ruha(int meret) {
        this.meret = meret;
        letrehozottRuhakSzama++;
    }

    public static int getLetrehozottRuhakSzama() {
        return letrehozottRuhakSzama;
    }

    public int getMeret() {
        return meret;
    }
    public abstract void hord();
    public abstract void megmos();

}
