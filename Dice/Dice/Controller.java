package Dice;
import java.awt.event.*;

public class Controller {
    Model model;
	View view;

    Controller(Model model,View view){
        this.model = model;
        this.view = view;
    }

    // Event for buttons
	public void event_roll_up(ActionEvent e) {
		model.roll_up();
        view.update_numer();
        System.out.println("roll up");
	}
    public void event_roll_front(ActionEvent e) {
		model.roll_front();
        view.update_numer();
        System.out.println("roll front");
	}
    public void event_roll_right(ActionEvent e) {
		model.roll_right();
        view.update_numer();
        System.out.println("roll right");
	}

    
    public static void  main(String[] args){
        Model model = new Model();
        View view = new View();
        Controller control = new Controller(model, view);
        view.set_model(model);
        view.set_controller(control);
        view.add_event_buttons();
    }
}
