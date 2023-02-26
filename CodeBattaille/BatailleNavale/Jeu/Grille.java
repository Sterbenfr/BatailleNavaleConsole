package BatailleNavale.Jeu;

import java.util.HashMap;
import java.util.Objects;
import java.util.Map;

public class Grille {
    private static final int GRID_SIZE = 10;
    private static int x;
    private static int y;

    public static Case[][] CreateGrid() {
        Case[][] tabCases = new Case[GRID_SIZE][GRID_SIZE];
        return tabCases;
    }

    public static void InitGrid(Case[][] tableau) {
        for (x = 0; x != GRID_SIZE; x++) {
            for (y = 0; y != GRID_SIZE; y++) {
                tableau[x][y] = new Case("water", x, y,"Mer");
            }
        }
    }

    public static void MyGridDisplay(Case[][] tableau) {
        int compteur = 0;
        System.out.println("-----------------------------------------");
        for (x = 0; x != GRID_SIZE; x++) {
            for (y = 0; y != GRID_SIZE; y++) {
                if (compteur % 10 == 0 && compteur != 0) {
                    System.out.println("|");
                    System.out.println("-----------------------------------------");
                }
                System.out.print(tableau[x][y].toString());
                compteur++;
            }
        }
        System.out.println("|");
        System.out.println("-----------------------------------------");
    }

    public static void OtherGridDisplay(Case[][] tableau) {
        int compteur = 0;
        System.out.println("-----------------------------------------");
        for (x = 0; x != GRID_SIZE; x++) {
            for (y = 0; y != GRID_SIZE; y++) {
                if (compteur % 10 == 0 && compteur != 0) {
                    System.out.println("|");
                    System.out.println("-----------------------------------------");
                }
                if (Objects.equals(tableau[x][y].toString(), "| B ")) {
                    System.out.print("|   ");
                } else {
                    System.out.print(tableau[x][y].toString());
                }
                compteur++;
            }
        }
        System.out.println("|");
        System.out.println("-----------------------------------------");
    }

    public static String IsABoatDead(Case[][] tab,boolean DesExist,boolean CruExist,boolean SubExist,boolean BattExist,boolean CarrExist){
        int compteur = 0;
        int DestroyerCompte=0;
        int CruiserCompte=0;
        int SubmarineCompte=0;
        int BattleshipCompte=0;
        int CarrierCompte=0;
        for(x=0;x != GRID_SIZE;x++){
            for(y=0;y!=GRID_SIZE;y++){
                if (!Objects.equals(tab[x][y].getAppartenance(), "Mer")){

                    if (Objects.equals(tab[x][y].getAppartenance(), "destroyer")){
                        DestroyerCompte++;
                    }
                    if (Objects.equals(tab[x][y].getAppartenance(), "cruiser")){
                        CruiserCompte++;
                    }
                    if (Objects.equals(tab[x][y].getAppartenance(), "submarine")){
                        SubmarineCompte++;
                    }
                    if (Objects.equals(tab[x][y].getAppartenance(), "battleship")){
                        BattleshipCompte++;
                    }
                    if (Objects.equals(tab[x][y].getAppartenance(), "carrier")){
                        CarrierCompte++;
                    }
                }

            }
        }
        if(BattleshipCompte==0 && BattExist){
            System.out.println("Battleship coulé ! +200");
            return "battleship";
        }
        if(CruiserCompte==0 && CruExist){
            System.out.println("Cruiser coulé ! +100");
            return "cruiser";
        }
        if (SubmarineCompte== 0 && SubExist){
            System.out.println("Submarine coulé ! +100");
            return "submarine";
        }
        if (DestroyerCompte==0 && DesExist){
            System.out.println("Destroyer coulé ! +50");
            return "destroyer";
        }
        if (CarrierCompte==0 && CarrExist){
            System.out.println("Carrier coulé ! +250");
            return "carrier";
        }
        return "no";
    }
}