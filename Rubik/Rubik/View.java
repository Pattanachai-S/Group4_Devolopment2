package Rubik;

public class View {
    private Model model;
    private Controller control;

    View(Model model){
        this.model = model;
    }

    public void set_controller(Controller c){
        this.control = c;
    }
}
