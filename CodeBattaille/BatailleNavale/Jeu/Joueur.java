package BatailleNavale.Jeu;

import static BatailleNavale.Jeu.Grille.*;
import static BatailleNavale.Jeu.Bateau.*;

public class Joueur {

    private String name;
    private boolean isPlaying= false;
    private int score;
    boolean DesExist;
    boolean CruExist;
    boolean SubExist;
    boolean BattExist;
    boolean CarrExist;




    private Case[][] grid;

    public boolean isDesExist() {
        return DesExist;
    }

    public void setDesExist() {
        DesExist = false;
    }

    public boolean isCruExist() {
        return CruExist;
    }

    public void setCruExist() {
        CruExist = false;
    }

    public boolean isSubExist() {
        return SubExist;
    }

    public void setSubExist() {
        SubExist = false;
    }

    public boolean isBattExist() {
        return BattExist;
    }

    public void setBattExist() {
        BattExist = false;
    }

    public boolean isCarrExist() {
        return CarrExist;
    }

    public void setCarrExist() {
        CarrExist = false;
    }

    public Joueur(String name) {
        this.name = name;
        isPlaying = false;
        score = 0;
        grid = CreateGrid();
        DesExist=true;
        CruExist=true;
        SubExist=true;
        BattExist=true;
        CarrExist=true;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(){
        isPlaying = !isPlaying;
    }

    public void initialisation() {
        InitGrid(grid);
        int destroyer=1;
        int cruiser=1;
        int submarine=1;
        int battleship=1;

        int carrier=1;
        while (cruiser == 1 || carrier == 1 || destroyer == 1 || battleship == 1 || submarine == 1) {
            String suprime = addBoat(grid,destroyer,submarine,cruiser,battleship,carrier);
            switch (suprime) {
                case "destroyer" :
                    destroyer = 0;
                    break;
                case "submarine" :
                    submarine = 0;
                    break;
                case "cruiser" :
                    cruiser = 0;
                    break;
                case "battleship" :
                    battleship = 0;
                    break;
                case "carrier" :
                    carrier = 0;
                    break;
                case "" :
                    continue;
            }
            MyGridDisplay(grid);
        }
    }


    public Case[][] getGrid() {
        return grid;
    }

    public int getScore() {
        return score;
    }

    public int setScore(int newscore){
        score=newscore;
        return 1;
    }

    public void setName(String newname){
        name= newname;
    }
    public String getName() {
        return name;
    }

}