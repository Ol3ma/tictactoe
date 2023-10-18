package ole.praktikum;

public class Spieler {
    private final int spielerNummer;
    private final String spielFigur;

    public Spieler(int spielerNummer, String spielFigur) {
        this.spielerNummer = spielerNummer;
        this.spielFigur = spielFigur;
    }

    public String getSpielFigur() {
        return spielFigur;
    }

    public int getSpielerNummer() {
        return spielerNummer;
    }
}
