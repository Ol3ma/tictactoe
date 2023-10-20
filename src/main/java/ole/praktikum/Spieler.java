package ole.praktikum;

public class Spieler {
    private final String spielerNummer;
    private final String spielFigur;

    public int getGewonnendeSpiele() {
        return gewonnendeSpiele;
    }

    public void setGewonnendeSpielepluseins() {
        this.gewonnendeSpiele++;
    }

    private int gewonnendeSpiele;

    public Spieler(String spielerNummer, String spielFigur) {
        this.spielerNummer = spielerNummer;
        this.spielFigur = spielFigur;
    }

    public String getSpielFigur() {
        return spielFigur;
    }

    public String getSpielerNummer() {
        return spielerNummer;
    }
}
