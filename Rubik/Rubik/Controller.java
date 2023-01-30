package Rubik;
import java.awt.event.*;

public class Controller {
    Model model;
	View view;

    Controller(Model model){
        this.model = model;
        //this.view = view;
    }

	public void event_roll_R(ActionEvent e) {
		model.roll_R(model.get_size()-1);
        System.out.println("Roll R");
	}

	public void event_roll_F(ActionEvent e) {
		model.roll_F(model.get_size()-1);
        System.out.println("Roll F");
	}

	public void event_roll_U(ActionEvent e) {
		model.roll_U(model.get_size()-1);
        System.out.println("Roll U");
	}

    public void event_roll_L(ActionEvent e) {
        for (int i=0;i<3;i++){
            model.roll_R(0);
        }
        System.out.println("Roll L");
	}

	public void event_roll_B(ActionEvent e) {
        for (int i=0;i<3;i++){
            model.roll_F(0);
        }
        System.out.println("Roll B");
	}

	public void event_roll_D(ActionEvent e) {
        for (int i=0;i<3;i++){
            model.roll_U(0);
        }
        System.out.println("Roll D");
	}

    public void event_flip_R(ActionEvent e){
        // Use for flip rubik right
        for (int i=0;i<model.get_size();i++){
            model.roll_D(i);
        }
        System.out.println("Flip R");
    }

    public void event_flip_L(ActionEvent e){
        // Use for flip rubik left
        for (int i=0;i<model.get_size();i++){
            model.roll_L(i);
        }
        System.out.println("Flip L");
    }
    
    public void event_flip_U(ActionEvent e){
        // Use for flip rubik up
        for (int i=0;i<model.get_size();i++){
            model.roll_R(i);
        }
        System.out.println("Flip U");
    }

    public void event_flip_D(ActionEvent e){
        // Use for flip rubik down
        for (int i=0;i<model.get_size();i++){
            model.roll_L(i);
        }
        System.out.println("Flip D");
    }

    public static void  main(String[] args){
        int size = 3;
        Model model = new Model(size);
        Controller control = new Controller(model);
        View view = new View(model, control);
    }
}
