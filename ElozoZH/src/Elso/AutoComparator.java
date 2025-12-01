package Elso;

import java.util.Comparator;

public class AutoComparator implements Comparator<Auto> {
    @Override
    public int compare(Auto a, Auto b) {
        if (a.getEvjarat() != b.getEvjarat()) {
            return Integer.compare(a.getEvjarat(), b.getEvjarat());
        }
        return a.getRendszam().compareToIgnoreCase(b.getRendszam());
    }
}
