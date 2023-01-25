package Rubik;
import java.awt.event.*;

public class Controller {
    Model model;
	View view;

    Controller(Model model,View view){
        this.model = model;
        this.view = view;
    }

	public void event_roll_R(ActionEvent e) {
		model.roll_R(model.get_size()-1);
        System.out.println("Roll R");
	}

	public void event_roll_F(ActionEvent e) {
		model.roll_F(model.get_size()-1);
        System.out.println("Roll R");
	}

	public void event_roll_U(ActionEvent e) {
		model.roll_U(model.get_size()-1);
        System.out.println("Roll R");
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

    public void flip_R(){
        // Use for flip rubik right
        for (int i=0;i<model.get_size();i++){
            model.roll_D(i);
        }
    }

    public void flip_L(){
        // Use for flip rubik left
        for (int i=0;i<model.get_size();i++){
            model.roll_L(i);
        }
    }
    
    public void flip_U(){
        // Use for flip rubik up
        for (int i=0;i<model.get_size();i++){
            model.roll_R(i);
        }
    }

    public void flip_D(){
        // Use for flip rubik down
        for (int i=0;i<model.get_size();i++){
            model.roll_L(i);
        }
    }

    public static void  main(String[] args){
        int size = 3;
        Model model = new Model(size);
        View view = new View(model);
        Controller control = new Controller(model, view);
        view.set_controller(control);
        // view.add_event_buttons();
    }
}
