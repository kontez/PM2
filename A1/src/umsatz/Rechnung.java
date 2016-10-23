package umsatz;

import java.util.Arrays;

public class Rechnung {
	private int initialeKapazitaet = 5;
	private int cursor;
	private int rechnungsnummer;
	private Position positionen[];
	private int erweiternUm = 2;
	
	public Rechnung(int rechnungsnummer) {
		this.rechnungsnummer = rechnungsnummer;
		positionen = new Position[initialeKapazitaet];
		cursor = 0;
	}
	
	public Position[] getPositionen() {
		return positionen;
    }
	
	public void add(Position p){
		if (cursor >= positionen.length) {
			positionen = Arrays.copyOf(positionen, positionen.length + erweiternUm);
		}
		positionen[cursor] = p;
		cursor++;	
	}
	
	@Override
	public String toString() {
		return positionen[positionen.length] != null ? Arrays.toString(positionen) : 
			Arrays.toString(Arrays.copyOf(positionen, cursor - 1));
	}
	
	public GeldBetrag rechnungsSumme() {
        GeldBetrag total = new GeldBetrag();
        for( Position p : positionen ) {
            if (p != null) {
                total = total.add(p.getPreis());
            }
        }
        return total;
	}
	
    public GeldBetrag summePosition(Position pos) {
        GeldBetrag gesamt = new GeldBetrag();
        for ( Position p : positionen ) {
            if (p == pos) {
                gesamt = gesamt.add(p.getPreis());
            }
        }
        return gesamt;
    }

}
