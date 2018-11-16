class Appli {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                Model m = new Model();
                ControlGroup g = new ControlGroup(m);
            }


        });
    }
}
