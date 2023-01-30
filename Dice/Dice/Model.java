package Dice;

public class Model{
    private int front = 2;
    private int top = 1;
    private int right = 3;

    public void roll_up(){
        int back = get_back();
        front = right;
        right = back;
    }

    public void roll_front(){
        int left = get_left();
        right = top;
        top = left;
    }

    public void roll_right(){
        int down = get_down();
        top = front;
        front = down;
    }

    public void roll_back(){
        // It mean roll front 3 time
        for(int i=0;i<3;i++){
            roll_front();
        }
    }

    public void roll_left(){
        // It mean roll right 3 time
        for(int i=0;i<3;i++){
            roll_right();
        }
    }

    public void roll_down(){
        // It mean roll up 3 time
        for(int i=0;i<3;i++){
            roll_up();
        }
    }

    public int get_front(){
        return front;
    }

    public int get_right(){
        return right;
    }

    public int get_up(){
        return top;
    }

    public int get_back(){
        return 7-front;
    }

    public int get_left(){
        return 7-right;
    }

    public int get_down(){
        return 7-top;
    }



    public void show_top(){
        // method for test dice
        System.out.println(top);
    }

    public static void  main(String[] args){
        // tester for Dice can work
        Model dice = new Model();
        dice.show_top();
        dice.roll_front();
        dice.show_top();
        dice.roll_right();
        dice.show_top();
    }
}
