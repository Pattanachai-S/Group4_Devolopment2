package Rubik;
import Dice.*;  // It have not error for run, It mean all class from Dice

public class Model {
    // Our 3D array is [x][y][z] so x=front, y=right, z=top
    private Dice.Model[][][] dices;  // 
        // In View we will map 1-6 to 6 colors and 0 = no color
        // methid for roll right is roll_R(y)

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

    public void roll_R(int y){
        int[][] series = get_series_for_roll_R(rubik_size,y);
        shift_in_series(series,"right");
    }

    public void roll_F(int x){
        int[][] series = get_series_for_roll_R(rubik_size,x);
        shift_in_series(series,"front");
    }

    public void roll_U(int z){
        int[][] series = get_series_for_roll_R(rubik_size,z);
        shift_in_series(series,"up");
    }

    private int cal_series_size(int s){
        // Find series size to shift
        int border = s*s;
        int in;
        if (s>2){  // Find in side size of border
            // if rubik size > 2
            in = s-2;
        }else{
            // if rubik size <= 2, it will no inside
            in = 0;
        }

        int in_side = in*in;
        return border - in_side; // return in side - out side
    }

    
    private void set_xyz_series_(int[][] s,int p,int x, int y, int z){
        // {x,y,z}
        s[p][0] = x; 
        s[p][1] = y; 
        s[p][2] = z;
    }

    private int[][] get_series_for_roll_R(int s,int y){
        // Find array of locantion Dices size = rubik_size^2 - (rubik_size-2)^2
        int series_size = cal_series_size(s);
        int[][] series = new int[series_size][3];
        // series is [(x,y,z),(x,y,z)] in dices[x][y][z]


        int x=0,z=0;
        int series_p = 0;
        while(x < s){      
            // {x,y,z}
            set_xyz_series_(series,series_p, x,y,z);
            x++;
            series_p++;
        }

        x = s-1; // reduces to last index
        z = z+1; // 1st dice get by last loop
        while(z < s){          
            // {x,y,z}
            set_xyz_series_(series,series_p, x,y,z);
            z++;
            series_p++;
        }

        z = s-1; // reduces to last index
        x = x-1; // 1st dice get by last loop
        while(x >= 0){       
            // {x,y,z}
            set_xyz_series_(series,series_p, x,y,z);
            x--;
            series_p++;
        }

        x = x+1; // back to 1st index
        z = z-1; // 1st dice get by last loop
        // last dice get by 1st loop
        while(z > 0){       
            // {x,y,z}
            set_xyz_series_(series,series_p, x,y,z);
            z--;
            series_p++;
        }

        return series;
    }

    private int[][] get_series_for_roll_F(int s,int x){
        // Find array of locantion Dices size = rubik_size^2 - (rubik_size-2)^2
        int series_size = cal_series_size(s);
        int[][] series = new int[series_size][3];
        // series is [(x,y,z),(x,y,z)] in dices[x][y][z]


        int y=0,z=0;
        int series_p = 0;
        while(z < s){      
            // {x,y,z}
            set_xyz_series_(series,series_p, x,y,z);
            z++;
            series_p++;
        }

        z = s-1; // reduces to last index
        y = y+1; // 1st dice get by last loop
        while(y < s){          
            // {x,y,z}
            set_xyz_series_(series,series_p, x,y,z);
            y++;
            series_p++;
        }

        y = s-1; // reduces to last index
        z = z-1; // 1st dice get by last loop
        while(z >= 0){       
            // {x,y,z}
            set_xyz_series_(series,series_p, x,y,z);
            z--;
            series_p++;
        }

        z = z+1; // back to 1st index
        y = y-1; // 1st dice get by last loop
        // last dice get by 1st loop
        while(y > 0){       
            // {x,y,z}
            set_xyz_series_(series,series_p, x,y,z);
            y--;
            series_p++;
        }

        return series;
    }

    private int[][] get_series_for_roll_U(int s,int z){
        // Find array of locantion Dices size = rubik_size^2 - (rubik_size-2)^2
        int series_size = cal_series_size(s);
        int[][] series = new int[series_size][3];
        // series is [(x,y,z),(x,y,z)] in dices[x][y][z]


        int x=0,y=0;
        int series_p = 0;
        while(y < s){      
            // {x,y,z}
            set_xyz_series_(series,series_p, x,y,z);
            y++;
            series_p++;
        }

        y = s-1; // reduces to last index
        x = x+1; // 1st dice get by last loop
        while(x < s){          
            // {x,y,z}
            set_xyz_series_(series,series_p, x,y,z);
            x++;
            series_p++;
        }

        x = s-1; // reduces to last index
        y = y-1; // 1st dice get by last loop
        while(y >= 0){       
            // {x,y,z}
            set_xyz_series_(series,series_p, x,y,z);
            y--;
            series_p++;
        }

        y = y+1; // back to 1st index
        x = x-1; // 1st dice get by last loop
        // last dice get by 1st loop
        while(x > 0){       
            // {x,y,z}
            set_xyz_series_(series,series_p, x,y,z);
            x--;
            series_p++;
        }

        return series;
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
        int series_size = series.length;  // find size of rubik_series for shift
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