package sample;

public class Plateau {
    private int[][] plateau;

    public Plateau(){
        plateau = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                plateau[i][j] = 0;
            }
        }
    }

    public int[][] getPlateau() {
        return plateau;
    }
}
