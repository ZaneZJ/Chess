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

            if (playerTurn == Values.WHITE) {
                System.out.println();
                System.out.println("White players turn!");
            } else if (playerTurn == Values.BLACK) {
                System.out.println();
                System.out.println("Black players turn!");
            }

            // Insert column :
            fromCol = inputCol("Column of the piece that you want to move: ");

            // Insert row :
            fromRow = inputRow("Row of the piece that you want to move: ");

            // Insert column :
            toCol = inputCol("Column where you want to move the piece: ");

            // Insert row :
            toRow = inputRow("Row where you want to move the piece: ");

            pieces.grid(fromRow, fromCol, toRow, toCol);
            print();
            isGameOver();

        }
    }

    private int inputCol(String message) {
        int col;
        while (true) {
            Scanner insert = new Scanner(System.in);
            System.out.print(message);
            String c = insert.nextLine();
            if (c.length() > 1) {
                System.out.println("Invalid input!");
            } else {
                col = c.charAt(0);
                if (col >= Values.LOWERCASE_A && col <= Values.LOWERCASE_H) {
                    col = col - Values.LOWERCASE_A + 1;
                    break;
                } else if (col >= Values.UPPERCASE_A && col <= Values.UPPERCASE_H) {
                    col = col - Values.UPPERCASE_A + 1;
                    break;
                } else {
                    System.out.println("Invalid input!");
                }
            }
        }
        col -= 1;
        return col;
    }

    private int inputRow(String message) {
        int row;
        while (true) {
            Scanner insert = new Scanner(System.in);
            System.out.print(message);
            String r = insert.nextLine();
            if (r.length() > 1) {
                System.out.println();
                System.out.println("Invalid input!");
            } else {
                row = r.charAt(0) - Values.ASCI_1 + 1;
                if (row < 1 || row > Values.ROWS) {
                    System.out.println();
                    System.out.println("Invalid input!");
                } else {
                    break;
                }
            }
        }
        row -= 1;
        return row;
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
