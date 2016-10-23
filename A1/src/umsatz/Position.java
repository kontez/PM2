package umsatz;

public class Position {
    private String name;
    private GeldBetrag preis;

    //Teil A2a
    public Position(String name, GeldBetrag preis) {
        this.name = name;
        this.preis = preis;
    }

    //Teil A2b
    public GeldBetrag getPreis() {
        return preis;
    }
    
    //Teil A2c
    
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass() ) return false;
        Position position = (Position) other;
        return name.equals(position.name);
    }
}
