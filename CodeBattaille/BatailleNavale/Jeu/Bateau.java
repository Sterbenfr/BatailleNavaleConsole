package BatailleNavale.Jeu;

import java.util.Objects;
import java.util.Scanner;

public class Bateau {
    private static int x;
    private static int y;
    private static int size = 0;
    private final String name;
    private static String orientation = null;

    public Bateau(String name, int x, int y, String orientation) {
        this.name = name;
        Bateau.x = x;
        Bateau.y = y;
        Bateau.orientation = orientation;
        size = setSizeFromName(name);
    }


    public int getY() {
        return y;
    }

    public String getOrientation() {
        return orientation;
    }

    public static boolean ThereIsAlreadyABoatH(Case[][] grid, int posx,int posy,int size1){
        for (int i = posy; i < posy + size1; i++){
            if (grid[posx][i].getEtat()=="Bateau"){
                return true;
            }
        }
        return false;
    }
    public static boolean ThereIsAlreadyABoatV(Case[][] grid, int posx,int posy,int size2){
        for (int i = posx; i < posx + size2; i++){
            if (grid[i][posy].getEtat()=="Bateau"){
                return true;
            }
        }
        return false;
    }
    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    private static int setSizeFromName(String name){
        return switch (name) {
            case "destroyer" -> 2;
            case "submarine" -> 3;
            case "cruiser" -> 3;
            case "battleship" -> 4;
            case "carrier" -> 5;
            default -> 0;
        };
    }

    private static boolean Unusable(String name,int des,int sub, int cruis,int ship, int carrier){
        if(Objects.equals(name, "destroyer") && des==1){
            return false;
        }else{
            if(Objects.equals(name, "submarine") && sub == 1){
                return false;
            }else {
                if(Objects.equals(name, "cruiser") && cruis==1){
                    return false;
                }else{
                    if(Objects.equals(name, "battleship") && ship==1){
                        return false;
                    }else{
                        if(Objects.equals(name, "carrier") && carrier==1){
                            return false;
                        }else{
                            return true;}
                    }
                }
            }
        }
    }

    public  static boolean IsOnNameList(String name){
        return Objects.equals(name, "destroyer") || Objects.equals(name, "submarine") ||
                Objects.equals(name, "cruiser") || Objects.equals(name, "battleship") || Objects.equals(name, "carrier");
    }
    public static void Shoot(Case[][] tabCase, int posX, int posY){
        String etat =tabCase[posX][posY].getEtat();
        if (Objects.equals(etat, "water")){
            tabCase[posX][posY].setEtat("TirMort");
        }else if(Objects.equals(etat, "Bateau")){
            System.out.println("Touché !");
            tabCase[posX][posY].setEtat("SunkenShip");
            tabCase[posX][posY].setAppartenance("Mer");
        }
    }
    public static String addBoat(Case[][] tabCases,int des,int sub, int cruis,int ship, int carrier) {
        Scanner sc = new Scanner(System.in);
        int posx;
        int posy;
        int maxX=10;
        int maxY=10;
        String name;
        do{
            System.out.println("Quel bateau souhaitez-vous placer ? (destroyer(2),submarine(3),cruiser(3),battleship(4),carrier(5))");
            name = sc.nextLine();
        }while (Unusable(name,des,sub,cruis,ship,carrier) && IsOnNameList(name) );

        int size = setSizeFromName(name);

        do {
            System.out.println("dans quel sens ? H ou V ");
            orientation = sc.nextLine();
        }while(!(Objects.equals(orientation, "h") || Objects.equals(orientation, "H") || Objects.equals(orientation, "v") || Objects.equals(orientation, "V")));

        if(Objects.equals(orientation, "H") || Objects.equals(orientation, "h")){
            maxY=10-size;
        }
        if(Objects.equals(orientation, "V") || Objects.equals(orientation, "v")) {
            maxX=10-size;
        }
        do {
            System.out.println("Position x");
            posx = sc.nextInt();
        }while (posx>maxX);
        do {
            System.out.println("Position y");
            posy=sc.nextInt();
        }while (posy>maxY);
        if ((Objects.equals(orientation, "V") || Objects.equals(orientation, "v")) && !ThereIsAlreadyABoatV(tabCases,posx,posy,size))  {
            for (int i = posx; i < posx + size; i++) {
                tabCases[i][posy].setEtat("Bateau");
                tabCases[i][posy].setAppartenance(name);
            }
        }
        else if ((Objects.equals(orientation, "H") || Objects.equals(orientation, "h")) && !ThereIsAlreadyABoatH(tabCases,posx,posy,size)) {
            for (int i = posy; i < posy + size; i++) {
                tabCases[posx][i].setEtat("Bateau");
                tabCases[posx][i].setAppartenance(name);
            }
        }
        else {
            return "";
        }
        return name;
    }
}

