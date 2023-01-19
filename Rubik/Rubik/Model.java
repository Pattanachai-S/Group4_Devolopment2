package Rubik;
import Dice.*;  // It have not error for run, It mean all class from Dice

public class Model {
    // Our 3D array is [x][y][z] so x=front, y=right, z=top
    private Dice.Model[][][] dices = new Dice.Model[3][3][3];  // 
        // In View we will map 1-6 to 6 colors and 0 = no color

    private int rubik_size = 3;  // Set size = 3 for default


    Model(int size){
        this.rubik_size = size;

        // Create rubik from dice by n*n*n
        for(int x=0; x<size; x++){
            for(int y=0; y<size; y++){
                for(int z=0; z<size; z++){
                    Dice.Model dice = new Dice.Model();
                    dices[x][y][z] = dice;  // Take dice to array
                }
            }
        }
    }

    public int get_point(int x, int y,int z, String side){
        // Get point from sice of dice
        if (side == "front"){
            return dices[x][y][z].get_front();
        } else if (side == "right") {
            return dices[x][y][z].get_right();
        } else if (side == "up") {
            return dices[x][y][z].get_up();
        } else if (side == "back") {
            return dices[x][y][z].get_back();
        } else if (side == "left") {
            return dices[x][y][z].get_left();
        } else if (side == "bottom") {
            return dices[x][y][z].get_down();
        }
        return 0;  // For error cases
    }

    public static void main(String[] args) {
    }
}