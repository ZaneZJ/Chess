package sample;

import java.util.Scanner;

public class EndOfTheGame {

    public static void isGameOver() {

        General general = new General();
        Game game = new Game();
        Values values = new Values();
        Print pr = new Print();

        boolean whiteKingAlive = false;
        boolean blackKingAlive = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (general.getPiece(game.chessGrid[i][j]) == values.KING) {
                    if (general.isWhite(game.chessGrid[i][j])) {
                        whiteKingAlive = true;
                    } else {
                        blackKingAlive = true;
                    }
                }
            }
        }
        if (blackKingAlive == false) {
            System.out.println("End of the game!");
            System.out.println("White won!");
            Scanner playYN = new Scanner(System.in);
            System.out.println("Do you want to play another game y/n: ");
            char play = playYN.next().charAt(0);
            if (play == 'y') {
                general.boardClear();
                pr.print();
            } else if (play == 'n') {
                game.stopTheGame = true;
            }
        } else if (whiteKingAlive == false) {
            System.out.println("End of the game!");
            System.out.println("Black won!");
            Scanner playYN = new Scanner(System.in);
            System.out.println("Do you want to play another game y/n: ");
            char play = playYN.next().charAt(0);
            if (play == 'y') {
                general.boardClear();
                pr.print();
            } else if (play == 'n') {
                game.stopTheGame = true;
            }
        }
    }

}
