package umsatz;

import java.util.Arrays;

public class Kasse {
    private Rechnung rechnungen[];
    private int cursor;
    private int initialeKapazitaet = 5;
    private int erweiternUm = 2;

    public Kasse() {
        rechnungen = new Rechnung[initialeKapazitaet];
        cursor = 0;
    }
    
    public void add(Rechnung r){
        if (cursor >= rechnungen.length) {
            rechnungen = Arrays.copyOf(rechnungen, rechnungen.length + erweiternUm);
        }
        rechnungen[cursor] = r;
        cursor++;   
    }
    
    @Override
    public String toString() {
        return rechnungen[rechnungen.length] != null ? Arrays.toString(rechnungen) : 
            Arrays.toString(Arrays.copyOf(rechnungen, cursor - 1));
    }
    
    public GeldBetrag kassenStand() {
        GeldBetrag total = new GeldBetrag();
        for ( Rechnung r : rechnungen ) {
            if (r != null) {
                total = total.add(r.rechnungsSumme());
            }
        }
        return total;
    }
    
    public GeldBetrag summePosition(Position pos) {
        GeldBetrag total = new GeldBetrag();
        for(Rechnung r : rechnungen){
            for(Position p : r.getPositionen()){
                if(p.equals(pos)){
                    total = total.add(p.getPreis());
                }
            }
        }
        return total;
    }
}
