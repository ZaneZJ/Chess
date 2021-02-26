package sample;

public class Print {

    public static void print() {

        Game game = new Game();
        Values values = new Values();

        int defineNumber = 1;
        for (int i = 0; i < 8; i++) {
            String plus = "+----";
            for (int k = 0; k < 8; k++) {
                System.out.print(plus);
            }
            System.out.print("+");
            System.out.println();
            System.out.print("| ");

            for(int j = 0; j < 8; j++) {
                System.out.print(game.chessGrid[i][j] + " | ");
            }

            System.out.println(defineNumber);
            defineNumber++;
        }

        for (int i = 1; i <= 8; i++) {
            System.out.print("+----");
        }
        System.out.println("+");
        char defineLetter = values.UPPERCASE_A;
        for (int i = 1; i <= 8; i++) {
            System.out.print("  " + defineLetter + "  ");
            defineLetter++;
        }
        System.out.println();
    }

}
