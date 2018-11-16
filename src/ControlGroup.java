public class ControlGroup {

    private Plateau p;
    private Model m;
    public Controller controlb;


    public ControlGroup(Model m) {

        this.m = m;
        p = new Plateau(m);
        controlb = new Controller(p, m);

    }


}
