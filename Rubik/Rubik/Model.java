package Rubik;
import Dice.*;  // It have not error for run, It mean all class from Dice

public class Model {
    // Our 3D array is [x][y][z] so x=front, y=right, z=top
    private Dice.Model[][][] dices;  // 
        // In View we will map 1-6 to 6 colors and 0 = no color

    private int rubik_size = 3;  // Set size = 3 for default


    Model(int size){
        this.rubik_size = size;  // Change rubik size
        dices = new Dice.Model[size][size][size];  // Create 3D array for Dices

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

    public void roll_R(){

    }

    private void get_series_for_roll_R(){
        // Find array of Dices size = rubik_size^2 - (rubik_size-2)^2
        // series is [(x,y,z),(x,y,z)] in dices[x][y][z]
    }

    private void shift_in_series(int[][] series, String roll){

        // Keep dices for shift
        int keeper_size = rubik_size-1;
        Dice.Model[] keeper = new Dice.Model[keeper_size];
        int pointer_dice = 0;
        for(int i =0;i<keeper_size;i++){
            keeper[i] = dices[series[i][0]][series[i][1]][series[i][2]];  // move some dice in rubik to keep
            pointer_dice++;
        }

        // Shift dice in series
        // Now pointer_dice is pointer of dice to shift      
        int series_size = (rubik_size * rubik_size)-1;  // find size of rubik_series for shift
        int destination = 0;
        while(pointer_dice < series_size){
            // shift dice in series 
            // that look like dices[x][y][z] = dices[x][y][z+1]
            Dice.Model dice_des = dices[series[destination][0]][series[destination][1]][series[destination][2]];
            Dice.Model dice_from = dices[series[pointer_dice][0]][series[pointer_dice][1]][series[pointer_dice][2]];
            dice_des = dice_from; 

            // roll dice after shift
            roll_dices_series(dice_des, roll);

            pointer_dice++;
            destination++;
        }

        // Take dices form keeper to last of series
        // Now pointer_dice is point to keep    
        pointer_dice = 0; // Dice.Model[] keeper = new Dice.Model[keeper_size];
        while(destination < series_size){
            Dice.Model dice_des = dices[series[destination][0]][series[destination][1]][series[destination][2]];
            Dice.Model dice_from = keeper[pointer_dice];
            dice_des = dice_from; 
        }
    }

    private void roll_dices_series(Dice.Model dice,String roll){
        if (roll == "front"){
            dice.roll_front();
        } else if (roll == "right") {
            dice.roll_right();
        } else if (roll == "up") {
            dice.roll_up();
        } else if (roll == "back") {
            dice.roll_back();
        } else if (roll == "left") {
            dice.roll_left();
        } else if (roll == "bottom") {
            dice.roll_down();
        }
    }

    public static void main(String[] args) {
    }
}