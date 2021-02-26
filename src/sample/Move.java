package sample;

import java.util.Scanner;

public class Move {

    public static void move() {

        Game game = new Game();
        Values values = new Values();
        EndOfTheGame end = new EndOfTheGame();
        Print pr = new Print();
        Grid gr = new Grid();

        while (game.stopTheGame == false) {

            /**
             *
             *  Insert what you want to move
             *
             */

            if (game.white == true) {
                System.out.println();
                System.out.println("White players turn!");
            } else if (game.black == true) {
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
                    game.fromCol = c1.charAt(0);
                    if (game.fromCol >= values.LOWERCASE_A && game.fromCol <= values.LOWERCASE_H) {
                        game.fromCol = game.fromCol - values.LOWERCASE_A + 1;
                        break;
                    } else if (game.fromCol >= values.UPPERCASE_A && game.fromCol <= values.UPPERCASE_H) {
                        game.fromCol = game.fromCol - values.UPPERCASE_A + 1;
                        break;
                    } else {
                        System.out.println();
                        System.out.println("Invalid input! Try Again");
                    }
                }
            }
            game.fromCol -= 1;

            // Insert row :
            while (true) {
                Scanner insertR1 = new Scanner(System.in);
                System.out.print("Row of the piece that you want to move: ");
                String r1 = insertR1.nextLine();
                if (r1.length() > 1) {
                    System.out.println();
                    System.out.println("Invalid input!");
                } else {
                    game.fromRow = r1.charAt(0) - values.ASCI_1 + 1;
                    if (game.fromRow < 1 || game.fromRow > values.ROWS) {
                        System.out.println();
                        System.out.println("Invalid input!");
                    } else {
                        break;
                    }
                }
            }
            game.fromRow -= 1;

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
                    game.toCol = c2.charAt(0);
                    if (game.toCol >= values.LOWERCASE_A && game.toCol <= values.LOWERCASE_H) {
                        game.toCol = game.toCol - values.LOWERCASE_A + 1;
                        break;
                    } else if (game.toCol >= values.UPPERCASE_A && game.toCol <= values.UPPERCASE_H) {
                        game.toCol = game.toCol - values.UPPERCASE_A + 1;
                        break;
                    } else {
                        System.out.println("Invalid input!");
                    }
                }
            }
            game.toCol -= 1;

            // Insert row :
            while (true) {
                Scanner insertR2 = new Scanner(System.in);
                System.out.print("Row where you want to move the piece: ");
                String r2 = insertR2.nextLine();
                if (r2.length() > 1) {
                    System.out.println();
                    System.out.println("Invalid input!");
                } else {
                    game.toRow = r2.charAt(0) - values.ASCI_1 + 1;
                    if (game.toRow < 1 || game.toRow > values.ROWS) {
                        System.out.println("Invalid input!");
                    } else {
                        break;
                    }
                }
            }
            game.toRow -= 1;

            gr.grid(game.fromRow, game.fromCol, game.toRow, game.toCol);
            pr.print();
            end.isGameOver();

        }
    }

}
