package BatailleNavale.Jeu;

import java.util.Objects;

public class Case {
    private String Etat;
    private final int x;
    private final int y;

    private String appartenance;

    public Case(String Etat, int x, int y,String appartien) {
        this.Etat = Etat;
        this.x = x;
        this.y = y;
        this.appartenance=appartien;
    }

    public String toString() {
        if (Objects.equals(Etat, "water")) {
            return "|   ";
        }
        if (Objects.equals(Etat, "Bateau")) {
            return "| B ";
        }
        if (Objects.equals(Etat, "TirMort")) {
            return "| ° ";
        }
        if (Objects.equals(Etat, "SunkenShip")) {
            return "| * ";
        } else {
            return "| ! ";
        }
    }

    public void setEtat(String etat) {
        Etat = etat;
    }

    public String getEtat() {
        return Etat;
    }

    public int getX() {
        return x;
    }

    public void setAppartenance(String appartenance1){
        appartenance=appartenance1;
    }
    public String getAppartenance(){
        return appartenance;
    }

    public int getY() {
        return y;
    }
}