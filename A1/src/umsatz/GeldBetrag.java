package umsatz;

public class GeldBetrag {
    private int money; //only cents
    
    // Konstruktor - Teil A1.a falls nur Cent
    public GeldBetrag(int cent) {
    	if (cent < 0) { throw new IllegalArgumentException(); }
        this.money = cent;
    }
    
    //falls beides
    public GeldBetrag(int euro, int cent) {
        this.money = euro * 100 + cent;
    }

    //falls nichts
    public GeldBetrag() {
        this.money = 0;
    }
    
    // Teil A1.b
    @Override
    public String toString() {
    	if ((money % 100) == 0) return Integer.toString(money/100)+'€';
    	return Integer.toString(money/100)+','+Integer.toString(money%100)+'€';
    }
    
    // Teil A1.c
    public GeldBetrag add(GeldBetrag other) {
    	return new GeldBetrag(money + other.money);
    }
}
