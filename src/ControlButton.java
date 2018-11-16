import java.awt.*;
import java.awt.event.*;

class ControlButton implements ActionListener {

    public Plateau p;
    private int i;
    private int j;

    public ControlButton(Plateau p, int i, int j) {
        this.p = p;
        this.i = i;
        this.j = j;

    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("i = " + i + " j = " + j);
    }


}
