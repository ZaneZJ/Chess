package sample;

import java.util.Scanner;

public class Game {

    public int fromRow, fromCol, toRow, toCol;
    public boolean stopTheGame = false;
    public char playerTurn = Values.WHITE;

    public Grid grid = new Grid();
    public Pieces pieces = new Pieces(this);

    public void nextTurn() {
        if (playerTurn == Values.WHITE) {
            playerTurn = Values.BLACK;
        } else {
            playerTurn = Values.WHITE;
        }
    }

    public void print() {

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
                System.out.print(grid.chessGrid[i][j] + " | ");
            }

            System.out.println(defineNumber);
            defineNumber++;
        }

        for (int i = 1; i <= 8; i++) {
            System.out.print("+----");
        }
        System.out.println("+");
        char defineLetter = Values.UPPERCASE_A;
        for (int i = 1; i <= 8; i++) {
            System.out.print("  " + defineLetter + "  ");
            defineLetter++;
        }
        System.out.println();
    }

    public void move() {

        while (stopTheGame == false) {

            /**
             *
             *  Insert what you want to move
             *
             */

            if (playerTurn == Values.WHITE) {
                System.out.println();
                System.out.println("White players turn!");
            } else if (playerTurn == Values.BLACK) {
                System.out.println();
                System.out.println("Black players turn!");
            }

            // Insert column :
            while (true) {
                Scanner insertC1 = new Scanner(System.in);
                System.out.print("Column of the piece that you want to move: ");
                String c1 = insertC1.nextLine();
                if (c1.length() > 1) {
                    System.out.println();
                    System.out.println("Invalid input! Try Again");
                } else {
                    fromCol = c1.charAt(0);
                    if (fromCol >= Values.LOWERCASE_A && fromCol <= Values.LOWERCASE_H) {
                        fromCol = fromCol - Values.LOWERCASE_A + 1;
                        break;
                    } else if (fromCol >= Values.UPPERCASE_A && fromCol <= Values.UPPERCASE_H) {
                        fromCol = fromCol - Values.UPPERCASE_A + 1;
                        break;
                    } else {
                        System.out.println();
                        System.out.println("Invalid input! Try Again");
                    }
                }
            }
            fromCol -= 1;

            // Insert row :
            while (true) {
                Scanner insertR1 = new Scanner(System.in);
                System.out.print("Row of the piece that you want to move: ");
                String r1 = insertR1.nextLine();
                if (r1.length() > 1) {
                    System.out.println();
                    System.out.println("Invalid input!");
                } else {
                    fromRow = r1.charAt(0) - Values.ASCI_1 + 1;
                    if (fromRow < 1 || fromRow > Values.ROWS) {
                        System.out.println();
                        System.out.println("Invalid input!");
                    } else {
                        break;
                    }
                }
            }
            fromRow -= 1;

            /**
             *
             *  Insert where you want to move
             *
             */

            // Insert column :
            while (true) {
                Scanner insertC2 = new Scanner(System.in);
                System.out.print("Column where you want to move the piece: ");
                String c2 = insertC2.nextLine();
                if (c2.length() > 1) {
                    System.out.println("Invalid input!");
                } else {
                    toCol = c2.charAt(0);
                    if (toCol >= Values.LOWERCASE_A && toCol <= Values.LOWERCASE_H) {
                        toCol = toCol - Values.LOWERCASE_A + 1;
                        break;
                    } else if (toCol >= Values.UPPERCASE_A && toCol <= Values.UPPERCASE_H) {
                        toCol = toCol - Values.UPPERCASE_A + 1;
                        break;
                    } else {
                        System.out.println("Invalid input!");
                    }
                }
            }
            toCol -= 1;

            // Insert row :
            while (true) {
                Scanner insertR2 = new Scanner(System.in);
                System.out.print("Row where you want to move the piece: ");
                String r2 = insertR2.nextLine();
                if (r2.length() > 1) {
                    System.out.println();
                    System.out.println("Invalid input!");
                } else {
                    toRow = r2.charAt(0) - Values.ASCI_1 + 1;
                    if (toRow < 1 || toRow > Values.ROWS) {
                        System.out.println("Invalid input!");
                    } else {
                        break;
                    }
                }
            }
            toRow -= 1;

            pieces.grid(fromRow, fromCol, toRow, toCol);
            print();
            isGameOver();

        }
    }

    public void isGameOver() {

        boolean whiteKingAlive = false;
        boolean blackKingAlive = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (grid.getPiece(grid.chessGrid[i][j]) == Values.KING) {
                    if (grid.isWhite(grid.chessGrid[i][j])) {
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
                grid.boardClear();
                print();
            } else if (play == 'n') {
                stopTheGame = true;
            }
        } else if (whiteKingAlive == false) {
            System.out.println("End of the game!");
            System.out.println("Black won!");
            Scanner playYN = new Scanner(System.in);
            System.out.println("Do you want to play another game y/n: ");
            char play = playYN.next().charAt(0);
            if (play == 'y') {
                grid.boardClear();
                print();
            } else if (play == 'n') {
                stopTheGame = true;
            }
        }
    }

}
