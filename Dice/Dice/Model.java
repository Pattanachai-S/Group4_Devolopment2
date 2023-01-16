package Dice;

public class Model{
    private int front = 2;
    private int top = 1;
    private int right = 3;

    public void roll_up(){
        int left = 7-right;
        right = front;
        front = left;
    }

    public void roll_front(){
        int left = 7-right;
        right = top;
        top = left;
    }

    public void roll_right(){
        int down = 7-top;
        top = front;
        front = down;
    }

    public int get_front(){
        return front;
    }

    public void show_top(){
        System.out.println(top);
    }

    public static void  main(String[] args){
        Model dice = new Model();
        dice.show_top();
        dice.roll_right();
        dice.show_top();
        dice.roll_right();
        dice.show_top();
    }
}
