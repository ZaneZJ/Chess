package sample;

import java.util.Scanner;

public class Grid {

    public String[][] chessGrid = {
            { "wR", "wN", "wB", "wQ", "wK", "wB", "wN", "wR" },
            { "wP", "wP", "wP", "wP", "wP", "wP", "wP", "wP" },
            { "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  " },
            { "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  " },
            { "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  " },
            { "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  " },
            { "bP", "bP", "bP", "bP", "bP", "bP", "bP", "bP" },
            { "bR", "bN", "bB", "bQ", "bK", "bB", "bN", "bR" }
    };

    public static boolean isWhite(String piece) {

        if (piece.charAt(0) == Values.WHITE) {
            return true;
        }
        return false;
    }

    public static boolean isBlack(String piece) {

        if (piece.charAt(0) == Values.BLACK) {
            return true;
        }
        return false;
    }

    public static boolean isColor(String piece, char color) {

        if (color == Values.WHITE) {
            return isWhite(piece);
        } else if (color == Values.BLACK) {
            return isBlack(piece);
        }
        return false;
    }

    public char getPiece(String piece) {

        return piece.charAt(1);
    }

    public String createPiece(char color, char piece) {

        String colorStr = Character.toString(color);
        String pieceStr = Character.toString(piece);

        String newPiece = colorStr + pieceStr;

        return newPiece;
    }

    public void boardClear() {

        Game game = new Game();

        String[][] clearChessGrid = {
                { "wR", "wN", "wB", "wQ", "wK", "wB", "wN", "wR" },
                { "wP", "wP", "wP", "wP", "wP", "wP", "wP", "wP" },
                { "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  " },
                { "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  " },
                { "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  " },
                { "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  " },
                { "bP", "bP", "bP", "bP", "bP", "bP", "bP", "bP" },
                { "bR", "bN", "bB", "bQ", "bK", "bB", "bN", "bR" }
        };

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                game.grid.chessGrid[i][j] = clearChessGrid[i][j];
            }
        }
    }

}
